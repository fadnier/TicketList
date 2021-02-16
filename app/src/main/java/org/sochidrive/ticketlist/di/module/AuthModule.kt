package org.sochidrive.ticketlist.di.module

import dagger.Module
import dagger.Provides
import org.sochidrive.ticketlist.mvp.model.api.IDataSource
import org.sochidrive.ticketlist.mvp.model.helpdesk.IHelpdeskLogin
import org.sochidrive.ticketlist.mvp.model.helpdesk.retrofit.RetrofitHelpdeskLogin
import org.sochidrive.ticketlist.mvp.model.network.INetworkStatus
import javax.inject.Singleton

@Module
class AuthModule {

    @Singleton
    @Provides
    fun authManager(api: IDataSource, networkStatus: INetworkStatus) : IHelpdeskLogin = RetrofitHelpdeskLogin(api, networkStatus)
}