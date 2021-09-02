package org.sochidrive.ticketlist.mvp.model.helpdesk.retrofit

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
            api.getAuth(AuthData(login, password)).flatMap {
                it.data?.let { cache.saveAuthManager(it) }
                Single.fromCallable { it }
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
            println("DEBUG: retrofit start check cache")
            cache.getAuthManager().flatMap { cacheManager->
                println("DEBUG: room get login")
                api.getTickets(cacheManager.data, cacheManager.data.token).flatMap {
                    cacheManager.result = it.result
                    Single.fromCallable { cacheManager }
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