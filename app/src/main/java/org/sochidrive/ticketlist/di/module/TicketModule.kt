package org.sochidrive.ticketlist.di.module

import dagger.Module
import dagger.Provides
import org.sochidrive.ticketlist.mvp.model.api.IDataSource
import org.sochidrive.ticketlist.mvp.model.helpdesk.ITicketHelpdesk
import org.sochidrive.ticketlist.mvp.model.helpdesk.retrofit.RetrofitHelpdeskTickets
import org.sochidrive.ticketlist.mvp.model.network.INetworkStatus
import javax.inject.Singleton

@Module
class TicketModule {

    @Singleton
    @Provides
    fun ticketsHelpdesk(api: IDataSource, networkStatus: INetworkStatus) : ITicketHelpdesk = RetrofitHelpdeskTickets(api, networkStatus)
}