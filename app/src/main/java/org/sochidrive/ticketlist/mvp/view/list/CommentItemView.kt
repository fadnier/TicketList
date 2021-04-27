package org.sochidrive.ticketlist.mvp.view.list

interface CommentItemView: IItemView {
    fun setAuthorName(name: String)
    fun setText(text: String)
    fun setDate(date: String)
}