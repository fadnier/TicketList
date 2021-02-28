package org.sochidrive.ticketlist.mvp.model.cache

import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Single
import org.sochidrive.ticketlist.mvp.model.entity.TicketDetail

interface IHelpdeskTicketCache {
    fun putTicket(ticket: TicketDetail): Completable
    fun getTicket(ticket: TicketDetail): Single<TicketDetail>
}