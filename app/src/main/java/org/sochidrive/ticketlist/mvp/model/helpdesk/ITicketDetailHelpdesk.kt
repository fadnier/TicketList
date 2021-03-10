package org.sochidrive.ticketlist.mvp.model.helpdesk

import io.reactivex.rxjava3.core.Single
import org.sochidrive.ticketlist.mvp.model.entity.Manager
import org.sochidrive.ticketlist.mvp.model.entity.TicketDetail
import org.sochidrive.ticketlist.mvp.model.entity.TicketDetailAnswer

interface ITicketDetailHelpdesk {
    fun getTicketId(manager: Manager,ticket: TicketDetail): Single<TicketDetailAnswer>
}