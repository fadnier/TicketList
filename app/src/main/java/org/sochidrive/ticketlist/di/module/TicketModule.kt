package org.sochidrive.ticketlist.di.module

import dagger.Module
import dagger.Provides
import org.sochidrive.ticketlist.mvp.model.api.IDataSource
import org.sochidrive.ticketlist.mvp.model.cache.IHelpdeskTicketCache
import org.sochidrive.ticketlist.mvp.model.cache.IHelpdeskTicketsDayCache
import org.sochidrive.ticketlist.mvp.model.helpdesk.ITicketDayHelpdesk
import org.sochidrive.ticketlist.mvp.model.helpdesk.ITicketDetailHelpdesk
import org.sochidrive.ticketlist.mvp.model.helpdesk.ITicketHelpdesk
import org.sochidrive.ticketlist.mvp.model.helpdesk.retrofit.RetrofitHelpdeskTicketDetail
import org.sochidrive.ticketlist.mvp.model.helpdesk.retrofit.RetrofitHelpdeskTicketsDay
import org.sochidrive.ticketlist.mvp.model.network.INetworkStatus
import javax.inject.Singleton

@Module
class TicketModule {

    @Singleton
    @Provides
    fun ticketsDayHelpdesk(api: IDataSource, networkStatus: INetworkStatus, cache: IHelpdeskTicketsDayCache) : ITicketDayHelpdesk = RetrofitHelpdeskTicketsDay(api, networkStatus, cache)

    @Singleton
    @Provides
    fun ticketHelpdesk(api: IDataSource, networkStatus: INetworkStatus, cache: IHelpdeskTicketCache) : ITicketDetailHelpdesk = RetrofitHelpdeskTicketDetail(api, networkStatus, cache)
}