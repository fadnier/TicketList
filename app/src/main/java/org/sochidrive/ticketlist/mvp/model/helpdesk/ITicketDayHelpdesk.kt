package org.sochidrive.ticketlist.mvp.model.helpdesk

import io.reactivex.rxjava3.core.Single
import org.sochidrive.ticketlist.mvp.model.entity.Manager
import org.sochidrive.ticketlist.mvp.model.entity.TicketAnswer

interface ITicketDayHelpdesk {
    fun getTickets(manager: Manager, day: String = ""): Single<TicketAnswer>
}