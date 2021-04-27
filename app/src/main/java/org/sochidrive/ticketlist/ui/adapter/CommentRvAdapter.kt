package org.sochidrive.ticketlist.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.item_comment.*
import org.sochidrive.ticketlist.R
import org.sochidrive.ticketlist.mvp.presenter.list.ICommentListPresenter
import org.sochidrive.ticketlist.mvp.view.list.CommentItemView

class CommentRvAdapter(val presenter: ICommentListPresenter) : RecyclerView.Adapter<CommentRvAdapter.ViewHolder>() {

    inner class ViewHolder(override val containerView: View) :RecyclerView.ViewHolder(containerView), CommentItemView, LayoutContainer {
        override var pos = -1

        override fun setAuthorName(name: String) {
            comment_author.text = name
        }

        override fun setText(text: String) {
            comment_text.text = text
        }

        override fun setDate(date: String) {
            comment_time.text = date
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CommentRvAdapter.ViewHolder  =
            ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_comment, parent, false))

    override fun onBindViewHolder(holder: CommentRvAdapter.ViewHolder, position: Int) {
        holder.pos = position
        holder.containerView.setOnClickListener { presenter.itemClickListener?.invoke(holder) }
        presenter.bindView(holder)
    }

    override fun getItemCount(): Int = presenter.getCount()

}