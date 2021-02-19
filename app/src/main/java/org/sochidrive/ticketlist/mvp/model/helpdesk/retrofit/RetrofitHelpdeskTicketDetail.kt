package org.sochidrive.ticketlist.mvp.model.helpdesk.retrofit

import io.reactivex.rxjava3.schedulers.Schedulers
import org.sochidrive.ticketlist.mvp.model.api.IDataSource
import org.sochidrive.ticketlist.mvp.model.cache.IHelpdeskTicketCache
import org.sochidrive.ticketlist.mvp.model.entity.Manager
import org.sochidrive.ticketlist.mvp.model.entity.Ticket
import org.sochidrive.ticketlist.mvp.model.entity.TicketData
import org.sochidrive.ticketlist.mvp.model.helpdesk.ITicketDetailHelpdesk
import org.sochidrive.ticketlist.mvp.model.network.INetworkStatus

class RetrofitHelpdeskTicketDetail(val api: IDataSource, val networkStatus: INetworkStatus, val cache: IHelpdeskTicketCache): ITicketDetailHelpdesk {
    override fun getTicketId(manager: Manager, ticket: Ticket) = networkStatus.isOnlineSingle().flatMap { isOnline->
        if(isOnline) {
            api.getTicketsId(TicketData(manager.id!!,ticket.record_id),manager.token.toString()).flatMap { tickets->
                cache.putTicket(ticket).toSingleDefault(tickets.data)
            }
        } else {
            cache.getTicket(ticket)
        }
    }.subscribeOn(Schedulers.io())

}