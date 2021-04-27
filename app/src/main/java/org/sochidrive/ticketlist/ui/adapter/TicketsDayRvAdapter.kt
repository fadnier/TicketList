package org.sochidrive.ticketlist.ui.adapter

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.item_ticket2.*
import org.sochidrive.ticketlist.R
import org.sochidrive.ticketlist.mvp.presenter.list.ITicketsDayListPresenter
import org.sochidrive.ticketlist.mvp.view.list.TicketItemDayView

class TicketsDayRvAdapter(val presenter: ITicketsDayListPresenter) : RecyclerView.Adapter<TicketsDayRvAdapter.ViewHolder>() {

    inner class ViewHolder(override val containerView: View) :RecyclerView.ViewHolder(containerView), TicketItemDayView, LayoutContainer {
        override var pos = -1

        override fun setTime(time: String) {
            ticket_time.text = time
        }

        override fun setTicketNumber(number: String) {
            ticket_number.text = number
        }

        override fun setTicketAddress(address: String) {
            ticket_address.text = address
        }

        override fun setStatusColor(color: String) {
            ticket_line.setBackgroundColor(Color.parseColor("#"+color))
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_ticket_day, parent, false))


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.pos = position
        holder.containerView.setOnClickListener { presenter.itemClickListener?.invoke(holder) }
        presenter.bindView(holder)
    }

    override fun getItemCount() = presenter.getCount()
}