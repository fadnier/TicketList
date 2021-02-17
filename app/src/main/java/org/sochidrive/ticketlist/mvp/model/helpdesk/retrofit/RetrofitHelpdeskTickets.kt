package org.sochidrive.ticketlist.mvp.model.helpdesk.retrofit

import io.reactivex.rxjava3.core.Single
import org.sochidrive.ticketlist.mvp.model.api.IDataSource
import org.sochidrive.ticketlist.mvp.model.entity.Manager
import org.sochidrive.ticketlist.mvp.model.entity.TicketAnswer
import org.sochidrive.ticketlist.mvp.model.helpdesk.ITicketHelpdesk
import org.sochidrive.ticketlist.mvp.model.network.INetworkStatus

class RetrofitHelpdeskTickets(val api: IDataSource, val networkStatus: INetworkStatus): ITicketHelpdesk {
    override fun getTickets(manager: Manager): Single<TicketAnswer> {
        return api.getTickets(manager)
    }

}