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
import org.sochidrive.ticketlist.mvp.presenter.TicketPresenter
import org.sochidrive.ticketlist.mvp.view.TicketView
import org.sochidrive.ticketlist.ui.BackButtonListener

class TicketFragment: MvpAppCompatFragment(), BackButtonListener, TicketView {

    companion object {
        private const val MANAGER_ARG = "manager"
        private const val TICKET_ARG = "ticket"

        fun newInstance(manager: Manager, ticket: TicketDetail) = TicketFragment().apply {
            arguments = Bundle().apply {
                putParcelable(MANAGER_ARG, manager)
                putParcelable(TICKET_ARG, ticket)
            }
        }
    }

    val presenter by moxyPresenter {
        val manager = arguments?.getParcelable<Manager>(TicketFragment.MANAGER_ARG) as Manager
        val ticket = arguments?.getParcelable<TicketDetail>(TicketFragment.TICKET_ARG) as TicketDetail
        TicketPresenter(manager,ticket).apply { App.instance.appComponent.inject(this) }
    }

    override fun backPressed() = presenter.backClick()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?) =
            View.inflate(context, R.layout.fragment_ticket, null)

    override fun init() {
        ///
    }

    override fun setRecordId(record_id: Int) {
        textRecordId.text = record_id.toString()
    }

    override fun setUsername(username: String) {
        textUsername.text = username
    }

    override fun setDescr(descr: String) {
        textDescr.text = descr
    }

    override fun setAddress(address: String) {
        textAddress.text = address
    }

    override fun setNumber(number: String) {
        textNumber.text = number
    }

    override fun setCreated(created: String) {
        textCreated.text = created
    }

    override fun setExecuteStart(execute_start: String) {
        textExecuteStart.text = execute_start
    }

    override fun settextExecuteFinal(execute_final: String) {
        textExecuteFinal.text = execute_final
    }

    override fun setMobile(mobile: String) {
        textMobile.text = mobile
    }

    override fun setTask(task: String) {
        textTask.text = task
    }
}