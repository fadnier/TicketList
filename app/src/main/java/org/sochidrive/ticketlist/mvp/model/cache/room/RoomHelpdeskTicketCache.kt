package org.sochidrive.ticketlist.mvp.model.cache.room

import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers
import org.sochidrive.ticketlist.mvp.model.cache.IHelpdeskTicketCache
import org.sochidrive.ticketlist.mvp.model.entity.Ticket
import org.sochidrive.ticketlist.mvp.model.entity.TicketDetail
import org.sochidrive.ticketlist.mvp.model.entity.room.Database
import org.sochidrive.ticketlist.mvp.model.entity.room.RoomTicket

class RoomHelpdeskTicketCache(val db: Database): IHelpdeskTicketCache {
    override fun putTicket(ticket: Ticket) = Completable.fromAction {
        val roomTicket = RoomTicket(ticket.record_id, ticket.username, ticket.descr, ticket.address, ticket.number)
        db.ticket.update(roomTicket)
    }.subscribeOn(Schedulers.io())

    override fun getTicket(ticket: Ticket) = Single.fromCallable {
        db.ticket.findForTicket(ticket.record_id).let { roomTicket ->
            TicketDetail(roomTicket.record_id, roomTicket.username, roomTicket.descr, roomTicket.address, roomTicket.number, roomTicket.task!!, roomTicket.mobile!!, roomTicket.address, roomTicket.descr, roomTicket.date_start!!, roomTicket.date_start_minute!!, roomTicket.date_start_hour!!, roomTicket.date_final!!, roomTicket.date_final_minute!!, roomTicket.date_final_hour!!, roomTicket.number)
        }
    }
}