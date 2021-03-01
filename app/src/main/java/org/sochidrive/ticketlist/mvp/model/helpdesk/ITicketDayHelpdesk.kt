package org.sochidrive.ticketlist.mvp.model.helpdesk

import io.reactivex.rxjava3.core.Single
import org.sochidrive.ticketlist.mvp.model.entity.Manager
import org.sochidrive.ticketlist.mvp.model.entity.TicketDetail

interface ITicketDayHelpdesk {
    fun getTickets(manager: Manager): Single<List<TicketDetail>>
}