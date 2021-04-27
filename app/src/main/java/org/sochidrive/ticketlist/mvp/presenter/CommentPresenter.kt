package org.sochidrive.ticketlist.mvp.presenter

import moxy.MvpPresenter
import org.sochidrive.ticketlist.mvp.model.entity.TicketComment
import org.sochidrive.ticketlist.mvp.view.CommentsView

class CommentPresenter(val comments: List<TicketComment>): MvpPresenter<CommentsView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        viewState.init()
        loadData()
    }

    private fun loadData() {
        TODO("Not yet implemented")
    }

}