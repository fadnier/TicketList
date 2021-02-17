package org.sochidrive.ticketlist.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.item_ticket.*
import org.sochidrive.ticketlist.R
import org.sochidrive.ticketlist.mvp.presenter.list.ITicketsListPresenter
import org.sochidrive.ticketlist.mvp.view.list.TicketItemView

class TicketsRvAdapter(val presenter: ITicketsListPresenter) : RecyclerView.Adapter<TicketsRvAdapter.ViewHolder>() {

    inner class ViewHolder(override val containerView: View) :RecyclerView.ViewHolder(containerView), TicketItemView, LayoutContainer {
        override var pos = -1

        override fun setTicketId(id: Int) {
            ticket_id.text = id.toString()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_ticket, parent, false))


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.pos = position
        holder.containerView.setOnClickListener { presenter.itemClickListener?.invoke(holder) }
        presenter.bindView(holder)
    }

    override fun getItemCount() = presenter.getCount()
}