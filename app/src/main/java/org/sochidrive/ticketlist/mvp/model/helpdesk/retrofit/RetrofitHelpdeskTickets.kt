package org.sochidrive.ticketlist.mvp.model.helpdesk.retrofit

import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers
import org.sochidrive.ticketlist.mvp.model.api.IDataSource
import org.sochidrive.ticketlist.mvp.model.cache.IHelpdeskTicketsCache
import org.sochidrive.ticketlist.mvp.model.entity.Manager
import org.sochidrive.ticketlist.mvp.model.helpdesk.ITicketHelpdesk
import org.sochidrive.ticketlist.mvp.model.network.INetworkStatus

class RetrofitHelpdeskTickets(val api: IDataSource, val networkStatus: INetworkStatus, val cache: IHelpdeskTicketsCache): ITicketHelpdesk {

    override fun getTickets(manager: Manager) = networkStatus.isOnlineSingle().flatMap { isOnline->
        if(isOnline) {
            api.getTickets(manager, manager.token).flatMap { tickets->
                tickets.data?.let { cache.putTickets(it) }
                Single.fromCallable { tickets }
            }
        } else {
            cache.getTickets()
        }
    }.subscribeOn(Schedulers.io())
}