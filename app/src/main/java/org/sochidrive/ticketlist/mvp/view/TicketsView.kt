package org.sochidrive.ticketlist.mvp.view

import moxy.MvpView
import moxy.viewstate.strategy.alias.AddToEndSingle

@AddToEndSingle
interface TicketsView: MvpView {
    fun init()
    fun updateTicketsList()
}