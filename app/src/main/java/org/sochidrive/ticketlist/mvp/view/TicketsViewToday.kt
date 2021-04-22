package org.sochidrive.ticketlist.mvp.view

import moxy.MvpView
import moxy.viewstate.strategy.alias.AddToEndSingle

@AddToEndSingle
interface TicketsViewToday: MvpView {
    fun init()
    fun updateTicketsList()
    fun clickTomorrowBtn()
    fun clickYesterdayBtn()
    fun setTextTomorrowBtn(day: String)
    fun setTextYesterdayBtn(day: String)
    fun setToday(day: String)
}