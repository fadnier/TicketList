package org.sochidrive.ticketlist.mvp.presenter.list

import org.sochidrive.ticketlist.mvp.view.list.CommentItemView

interface IListCommentPresenter<V : CommentItemView> {
    var itemClickListener: ((V) -> Unit)?
    fun bindView(view: V)
    fun getCount(): Int
}