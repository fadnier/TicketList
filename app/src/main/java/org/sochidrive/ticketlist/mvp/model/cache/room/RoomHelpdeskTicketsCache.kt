package org.sochidrive.ticketlist.mvp.model.cache.room

import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers
import org.sochidrive.ticketlist.mvp.model.cache.IHelpdeskTicketsCache
import org.sochidrive.ticketlist.mvp.model.entity.Ticket
import org.sochidrive.ticketlist.mvp.model.entity.room.Database
import org.sochidrive.ticketlist.mvp.model.entity.room.RoomTicket

class RoomHelpdeskTicketsCache(val db: Database): IHelpdeskTicketsCache{
    override fun putTickets(tickets: List<Ticket>) = Completable.fromAction {
        val roomTicket = tickets.map { ticket -> RoomTicket(ticket.record_id, ticket.username, ticket.descr, ticket.address, ticket.number) }
        db.ticket.insert(roomTicket)
    }.subscribeOn(Schedulers.io())

    override fun getTickets() = Single.fromCallable {
        db.ticket.getAll().map { roomTicket ->
            Ticket(roomTicket.record_id, roomTicket.username, roomTicket.descr, roomTicket.address, roomTicket.number)
        }
    }

}