package org.sochidrive.ticketlist.mvp.model.helpdesk.retrofit

import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers
import org.sochidrive.ticketlist.mvp.model.api.IDataSource
import org.sochidrive.ticketlist.mvp.model.cache.IHelpdeskTicketsDayCache
import org.sochidrive.ticketlist.mvp.model.entity.Manager
import org.sochidrive.ticketlist.mvp.model.entity.TicketDayData
import org.sochidrive.ticketlist.mvp.model.helpdesk.ITicketDayHelpdesk
import org.sochidrive.ticketlist.mvp.model.network.INetworkStatus
import org.sochidrive.ticketlist.mvp.model.util.DataTime

class RetrofitHelpdeskTicketsDay(val api: IDataSource, val networkStatus: INetworkStatus, val cache: IHelpdeskTicketsDayCache): ITicketDayHelpdesk {

    override fun getTickets(manager: Manager, day: String) = networkStatus.isOnlineSingle().flatMap { isOnline->
        var myDate = DataTime.getCurrentTime()
        if(day != "") {
            myDate = day
        }

        if(isOnline) {
            api.getTicketsDay(TicketDayData(manager.id, manager.name,myDate), manager.token).flatMap { tickets->
                cache.putTickets(tickets.data).toSingleDefault(tickets)
            }
        } else {
            cache.getTickets(myDate)
        }
    }.subscribeOn(Schedulers.io())
}