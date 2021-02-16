package org.sochidrive.ticketlist.mvp.view

import moxy.MvpView
import moxy.viewstate.strategy.alias.AddToEndSingle

@AddToEndSingle
interface LoginView: MvpView {
    fun init()
    fun clickLoginBtn()
    fun showMessage(message: String?)
}