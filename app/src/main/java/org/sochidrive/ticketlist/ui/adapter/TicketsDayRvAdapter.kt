package org.sochidrive.ticketlist.ui.adapter

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import org.sochidrive.ticketlist.databinding.ItemTicket2Binding
import org.sochidrive.ticketlist.mvp.presenter.list.ITicketsDayListPresenter
import org.sochidrive.ticketlist.mvp.view.list.TicketItemDayView

class TicketsDayRvAdapter(val presenter: ITicketsDayListPresenter) : RecyclerView.Adapter<TicketsDayRvAdapter.ViewHolder>() {

    inner class ViewHolder(var binding: ItemTicket2Binding) :RecyclerView.ViewHolder(binding.root), TicketItemDayView {
        override var pos = -1

        override fun setTime(time: String) {
            binding.ticketTime.text = time
        }

        override fun setTicketNumber(number: String) {
            binding.ticketNumber.text = number
        }

        override fun setTicketAddress(address: String) {
            binding.ticketAddress.text = address
        }

        override fun setStatusColor(color: String) {
            binding.ticketLine.setBackgroundColor(Color.parseColor("#"+color))
        }


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) : ViewHolder {
        val binding = ItemTicket2Binding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }



    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.pos = position
        holder.binding.root.setOnClickListener { presenter.itemClickListener?.invoke(holder) }
        presenter.bindView(holder)
    }

    override fun getItemCount() = presenter.getCount()
}