package org.sochidrive.ticketlist.mvp.view

import moxy.MvpView
import moxy.viewstate.strategy.alias.AddToEndSingle

@AddToEndSingle
interface MainMenuView: MvpView {
    fun init()
    fun clickBtnAllTicket()
    fun clickBtnTodayTicket()
    fun setName(name: String)
}