package org.sochidrive.ticketlist.mvp.model.cache.room

import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers
import org.sochidrive.ticketlist.mvp.model.cache.IHelpdeskTicketCache
import org.sochidrive.ticketlist.mvp.model.entity.TicketComment
import org.sochidrive.ticketlist.mvp.model.entity.TicketDetail
import org.sochidrive.ticketlist.mvp.model.entity.TicketDetailAnswer
import org.sochidrive.ticketlist.mvp.model.entity.room.Database
import org.sochidrive.ticketlist.mvp.model.entity.room.RoomTicket

class RoomHelpdeskTicketCache(val db: Database): IHelpdeskTicketCache {
    override fun putTicket(ticket: TicketDetail) = Completable.fromAction {
        val roomTicket = RoomTicket(record_id =  ticket.record_id,
            username = ticket.username,
            theme = ticket.theme,
            address = ticket.address,
            number = ticket.number,
            created = ticket.created,
            execute_start = ticket.execute_start,
            execute_final = ticket.execute_final,
            task = ticket.task,
            mobile = ticket.mobile,
            date_start = ticket.date_start,
            date_start_minute = ticket.date_start_minute,
            date_start_hour = ticket.date_start_hour,
            date_final = ticket.date_final,
            date_final_minute = ticket.date_final_minute,
            date_final_hour = ticket.date_final_hour,
            status_id = ticket.status_id,
            status_id_color = ticket.status_id_color,
            status_id_descr = ticket.status_id_descr,
            author_name = ticket.author_name)
        db.ticket.update(roomTicket)
    }.subscribeOn(Schedulers.io())

    override fun getTicket(ticket: TicketDetail) = Single.fromCallable {
        db.ticket.findForTicket(ticket.record_id).let { roomTicket ->
            TicketDetailAnswer( "ok",
                    "",
                TicketDetail(record_id =  roomTicket.record_id,
                    username =  roomTicket.username,
                    task =  roomTicket.task,
                    address =  roomTicket.address,
                    number =  roomTicket.number,
                    mobile = roomTicket.mobile,
                    theme = roomTicket.theme,
                    date_start = roomTicket.date_start,
                    date_start_minute = roomTicket.date_start_minute,
                    date_start_hour = roomTicket.date_start_hour,
                    date_final = roomTicket.date_final,
                    date_final_minute = roomTicket.date_final_minute,
                    date_final_hour =  roomTicket.date_final_hour,
                    created = roomTicket.created,
                    execute_final = roomTicket.execute_final,
                    execute_start = roomTicket.execute_start,
                    status_id = roomTicket.status_id,
                    status_id_color = roomTicket.status_id_color,
                    status_id_descr = roomTicket.status_id_descr,
                    author_name = roomTicket.author_name,
                    comments = listOf<TicketComment>()
                )
            )
        }
    }
}