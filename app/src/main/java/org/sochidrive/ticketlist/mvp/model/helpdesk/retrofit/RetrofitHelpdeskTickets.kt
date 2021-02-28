package org.sochidrive.ticketlist.mvp.model.helpdesk.retrofit

import io.reactivex.rxjava3.schedulers.Schedulers
import org.sochidrive.ticketlist.mvp.model.api.IDataSource
import org.sochidrive.ticketlist.mvp.model.cache.IHelpdeskTicketsCache
import org.sochidrive.ticketlist.mvp.model.entity.Manager
import org.sochidrive.ticketlist.mvp.model.helpdesk.ITicketHelpdesk
import org.sochidrive.ticketlist.mvp.model.network.INetworkStatus

class RetrofitHelpdeskTickets(val api: IDataSource, val networkStatus: INetworkStatus, val cache: IHelpdeskTicketsCache): ITicketHelpdesk {

    override fun getTickets(manager: Manager) = networkStatus.isOnlineSingle().flatMap { isOnline->
        if(isOnline) {
            api.getTickets(manager,manager.token.toString()).flatMap { tickets->
                cache.putTickets(tickets.data).toSingleDefault(tickets.data)
            }
        } else {
            cache.getTickets()
        }
    }.subscribeOn(Schedulers.io())
}