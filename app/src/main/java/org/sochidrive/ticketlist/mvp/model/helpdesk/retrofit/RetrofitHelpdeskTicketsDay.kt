package org.sochidrive.ticketlist.mvp.model.helpdesk.retrofit

import io.reactivex.rxjava3.schedulers.Schedulers
import org.sochidrive.ticketlist.mvp.model.api.IDataSource
import org.sochidrive.ticketlist.mvp.model.cache.IHelpdeskTicketsDayCache
import org.sochidrive.ticketlist.mvp.model.entity.Manager
import org.sochidrive.ticketlist.mvp.model.entity.TicketDayData
import org.sochidrive.ticketlist.mvp.model.helpdesk.ITicketDayHelpdesk
import org.sochidrive.ticketlist.mvp.model.network.INetworkStatus
import java.text.SimpleDateFormat
import java.util.*

class RetrofitHelpdeskTicketsDay(val api: IDataSource, val networkStatus: INetworkStatus, val cache: IHelpdeskTicketsDayCache): ITicketDayHelpdesk {

    override fun getTickets(manager: Manager) = networkStatus.isOnlineSingle().flatMap { isOnline->
        val formatDate = SimpleDateFormat("yyyy-MM-dd")
        val myDate = formatDate.format(Date())
        if(isOnline) {
            api.getTicketsDay(TicketDayData(manager.id!!,manager.name!!,myDate.toString()),manager.token.toString()).flatMap { tickets->
                cache.putTickets(tickets.data).toSingleDefault(tickets.data)
            }
        } else {
            cache.getTickets(myDate.toString())
        }
    }.subscribeOn(Schedulers.io())
}