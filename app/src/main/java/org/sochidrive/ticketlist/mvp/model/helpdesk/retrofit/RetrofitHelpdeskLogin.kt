package org.sochidrive.ticketlist.mvp.model.helpdesk.retrofit

import io.reactivex.rxjava3.core.Single
import org.sochidrive.ticketlist.mvp.model.entity.AuthData
import org.sochidrive.ticketlist.mvp.model.api.IDataSource
import org.sochidrive.ticketlist.mvp.model.entity.AuthAnswer
import org.sochidrive.ticketlist.mvp.model.helpdesk.IHelpdeskLogin
import org.sochidrive.ticketlist.mvp.model.network.INetworkStatus

class RetrofitHelpdeskLogin(val api: IDataSource, val networkStatus: INetworkStatus): IHelpdeskLogin {
    override fun getAuth(login: String, password: String): Single<AuthAnswer> {
        //return api.getAuth(login, password)
        return api.getAuth(AuthData(login,password))
    }

}