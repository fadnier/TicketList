package org.sochidrive.ticketlist.mvp.view.list

interface TicketItemView: IItemView {
    fun setTicketId(id: Int)
    fun setTicketNumber(number: String)
    fun setTicketAddress(address: String)
    fun setTicketDescr(descr: String)
    fun setTicketUsername(username: String)
}