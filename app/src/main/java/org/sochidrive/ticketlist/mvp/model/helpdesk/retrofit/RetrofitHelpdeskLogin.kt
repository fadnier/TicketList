package org.sochidrive.ticketlist.mvp.model.helpdesk.retrofit

import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers
import org.sochidrive.ticketlist.mvp.model.api.IDataSource
import org.sochidrive.ticketlist.mvp.model.cache.IHelpdeskManagerCache
import org.sochidrive.ticketlist.mvp.model.entity.AuthAnswer
import org.sochidrive.ticketlist.mvp.model.entity.AuthData
import org.sochidrive.ticketlist.mvp.model.entity.Manager
import org.sochidrive.ticketlist.mvp.model.helpdesk.IHelpdeskLogin
import org.sochidrive.ticketlist.mvp.model.network.INetworkStatus

class RetrofitHelpdeskLogin(val api: IDataSource, val networkStatus: INetworkStatus, val cache: IHelpdeskManagerCache): IHelpdeskLogin {
    override fun getAuth(login: String, password: String) = networkStatus.isOnlineSingle().flatMap { isOnline->
        if(isOnline) {
            api.getAuth(AuthData(login, password)).flatMap { authAnswer ->
                cache.saveAuthManager(authAnswer.data).toSingleDefault(authAnswer)
            }
        } else {
            Single.fromCallable{ AuthAnswer(
                result = "Error",
                data = Manager(answer = "No internet connection",
                    id = 0,
                    login = "",
                    name = "",
                    user_level = 0,
                    token = "")
            ) }
        }
    }.subscribeOn(Schedulers.io())

    override fun checkCacheAuth() = networkStatus.isOnlineSingle().flatMap { isOnline->

        if(isOnline) {
            cache.getAuthManager().flatMap { cacheManager->
                if(cacheManager.result=="ok") {
                    api.getTickets(cacheManager.data, cacheManager.data.token).flatMap {
                        cacheManager.result = it.result
                        Single.fromCallable { cacheManager }
                    }
                } else {
                    Single.fromCallable{ AuthAnswer(
                        result = "Error",
                        data = Manager(answer = "No save login",
                            id = 0,
                            login = "",
                            name = "",
                            user_level = 0,
                            token = "")
                    ) }
                }
            }
        } else {
            Single.fromCallable{ AuthAnswer(
                result = "Error",
                data = Manager(answer = "No internet connection",
                    id = 0,
                    login = "",
                    name = "",
                    user_level = 0,
                    token = "")
            ) }
        }
    }.subscribeOn(Schedulers.io())

}