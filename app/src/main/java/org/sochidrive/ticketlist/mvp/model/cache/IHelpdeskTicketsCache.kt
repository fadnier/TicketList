package org.sochidrive.ticketlist.mvp.model.cache

import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Single
import org.sochidrive.ticketlist.mvp.model.entity.Ticket

interface IHelpdeskTicketsCache {
    fun putTickets(tickets: List<Ticket>): Completable
    fun getTickets(): Single<List<Ticket>>
}