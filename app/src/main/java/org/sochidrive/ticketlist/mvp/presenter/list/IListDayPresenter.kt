package org.sochidrive.ticketlist.mvp.presenter.list

import org.sochidrive.ticketlist.mvp.view.list.TicketItemDayView

interface IListDayPresenter<V : TicketItemDayView> {
    var itemClickListener: ((V) -> Unit)?
    fun bindView(view: V)
    fun getCount(): Int
}