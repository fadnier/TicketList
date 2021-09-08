package org.sochidrive.ticketlist.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_ticket.*
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter
import org.sochidrive.ticketlist.App
import org.sochidrive.ticketlist.R
import org.sochidrive.ticketlist.mvp.model.entity.Manager
import org.sochidrive.ticketlist.mvp.model.entity.TicketDetail
import org.sochidrive.ticketlist.mvp.presenter.AgreementsPresenter
import org.sochidrive.ticketlist.mvp.view.AgreementsView
import org.sochidrive.ticketlist.ui.BackButtonListener

class AgreementsFragment: MvpAppCompatFragment(), BackButtonListener, AgreementsView {

    companion object {
        private const val MANAGER_ARG = "manager"
        private const val TICKET_ARG = "ticket"

        fun newInstance(manager: Manager, ticket: TicketDetail) = AgreementsFragment().apply {
            arguments = Bundle().apply {
                putParcelable(MANAGER_ARG, manager)
                putParcelable(TICKET_ARG, ticket)
            }
        }
    }

    val presenter by moxyPresenter {
        val manager = arguments?.getParcelable<Manager>(MANAGER_ARG) as Manager
        val ticket = arguments?.getParcelable<TicketDetail>(TICKET_ARG) as TicketDetail
        AgreementsPresenter(manager, ticket).apply { App.instance.appComponent.inject(this) }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View =
        View.inflate(context, R.layout.fragment_agreements, null)

    override fun init() {
        bottom_navigation_view.selectedItemId = R.id.menu_agrm_info
        bottom_navigation_view.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.menu_ticket_info -> {
                    presenter.btnTicketClick()
                }
                R.id.menu_agrm_info -> {
                    presenter.btnAgrmClick()
                }
                R.id.menu_exit -> {
                    presenter.btnExitClick()
                }
            }
            true
        }
    }

    override fun backPressed(): Boolean {
        TODO("Not yet implemented")
    }
}