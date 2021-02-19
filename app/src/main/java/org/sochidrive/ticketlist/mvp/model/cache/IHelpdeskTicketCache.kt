package org.sochidrive.ticketlist.mvp.model.cache

import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Single
import org.sochidrive.ticketlist.mvp.model.entity.Ticket
import org.sochidrive.ticketlist.mvp.model.entity.TicketDetail

interface IHelpdeskTicketCache {
    fun putTicket(ticket: Ticket): Completable
    fun getTicket(ticket: Ticket): Single<TicketDetail>
}