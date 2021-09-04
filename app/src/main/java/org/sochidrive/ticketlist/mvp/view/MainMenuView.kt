package org.sochidrive.ticketlist.mvp.view

import moxy.MvpView
import moxy.viewstate.strategy.alias.AddToEndSingle

@AddToEndSingle
interface MainMenuView: MvpView {
    fun init()
    fun clickBtnTodayTicket()
    fun clickBtnExit()
    fun setName(name: String)
}