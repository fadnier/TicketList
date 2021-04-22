package org.sochidrive.ticketlist.mvp.view

import moxy.MvpView
import moxy.viewstate.strategy.alias.AddToEndSingle

@AddToEndSingle
interface TicketsViewToday: MvpView {
    fun init()
    fun updateTicketsList()
    fun clickTomorrowBtn(day: String)
    fun clickYesterdayBtn(day: String)
    fun setToday(day: String)
}