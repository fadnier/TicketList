package org.sochidrive.ticketlist.mvp.view.list

import org.sochidrive.ticketlist.mvp.view.list.IItemView

interface TicketItemView: IItemView {
    fun setTicketId(id: Int)
}