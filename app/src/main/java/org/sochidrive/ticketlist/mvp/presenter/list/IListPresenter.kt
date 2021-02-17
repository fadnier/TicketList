package org.sochidrive.ticketlist.mvp.presenter.list

import org.sochidrive.ticketlist.mvp.view.list.TicketItemView

interface IListPresenter<V : TicketItemView> {
    var itemClickListener: ((V) -> Unit)?
    fun bindView(view: V)
    fun getCount(): Int
}