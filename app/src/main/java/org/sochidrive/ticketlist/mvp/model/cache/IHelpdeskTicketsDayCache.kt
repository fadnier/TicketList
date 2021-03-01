package org.sochidrive.ticketlist.mvp.model.cache

import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Single
import org.sochidrive.ticketlist.mvp.model.entity.TicketDetail

interface IHelpdeskTicketsDayCache {
    fun putTickets(tickets: List<TicketDetail>): Completable
    fun getTickets(day: String): Single<List<TicketDetail>>
}