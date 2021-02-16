package org.sochidrive.ticketlist.mvp.model.helpdesk.retrofit

import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers
import org.sochidrive.ticketlist.mvp.model.api.AuthData
import org.sochidrive.ticketlist.mvp.model.api.IDataSource
import org.sochidrive.ticketlist.mvp.model.entity.Answer
import org.sochidrive.ticketlist.mvp.model.helpdesk.IHelpdeskLogin
import org.sochidrive.ticketlist.mvp.model.network.INetworkStatus

class RetrofitHelpdeskLogin(val api: IDataSource, val networkStatus: INetworkStatus): IHelpdeskLogin {
    override fun getAuth(login: String, password: String): Single<Answer> {
        return api.getAuth(login, password)
        //return api.getAuth(AuthData(login,password))
    }

}