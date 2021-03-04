package org.sochidrive.ticketlist.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_list_ticket.*
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter
import org.sochidrive.ticketlist.App
import org.sochidrive.ticketlist.R
import org.sochidrive.ticketlist.mvp.model.entity.Manager
import org.sochidrive.ticketlist.mvp.presenter.TicketsDayPresenter
import org.sochidrive.ticketlist.mvp.view.TicketsView
import org.sochidrive.ticketlist.ui.BackButtonListener
import org.sochidrive.ticketlist.ui.adapter.TicketsDayRvAdapter

class TicketsDayFragment: MvpAppCompatFragment(), BackButtonListener, TicketsView {

    companion object {
        private const val MANAGER_ARG = "manager"

        fun newInstance(manager: Manager) = TicketsDayFragment().apply {
            arguments = Bundle().apply {
                putParcelable(MANAGER_ARG, manager)
            }
        }
    }

    var adapter: TicketsDayRvAdapter? = null

    val presenter by moxyPresenter {
        val managers = arguments?.getParcelable<Manager>(MANAGER_ARG) as Manager
        TicketsDayPresenter(managers).apply { App.instance.appComponent.inject(this) }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle? ) =
        View.inflate(context, R.layout.fragment_list_ticket, null)

    override fun backPressed() = presenter.backClick()

    override fun init() {
        rv_tickets.layoutManager = LinearLayoutManager(requireContext())
        adapter = TicketsDayRvAdapter(presenter.ticketsListPresenter)
        rv_tickets.adapter = adapter
    }

    override fun updateTicketsList() {
        adapter?.notifyDataSetChanged()
    }

}