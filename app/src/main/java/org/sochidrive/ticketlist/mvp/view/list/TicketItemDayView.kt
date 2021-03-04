package org.sochidrive.ticketlist.mvp.view.list

interface TicketItemDayView: IItemView {
    fun setTime(time: String)
    fun setTicketNumber(number: String)
    fun setTicketAddress(address: String)
    fun setStatusColor(color: String)
}