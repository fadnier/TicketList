package org.sochidrive.ticketlist.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter
import org.sochidrive.ticketlist.App
import org.sochidrive.ticketlist.R
import org.sochidrive.ticketlist.databinding.FragmentTicketBinding
import org.sochidrive.ticketlist.mvp.model.entity.Manager
import org.sochidrive.ticketlist.mvp.model.entity.TicketDetail
import org.sochidrive.ticketlist.mvp.presenter.TicketPresenter
import org.sochidrive.ticketlist.mvp.view.TicketView
import org.sochidrive.ticketlist.ui.BackButtonListener

class TicketFragment: MvpAppCompatFragment(), BackButtonListener, TicketView {
    private lateinit var binding: FragmentTicketBinding

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
        val manager = arguments?.getParcelable<Manager>(MANAGER_ARG) as Manager
        val ticket = arguments?.getParcelable<TicketDetail>(TICKET_ARG) as TicketDetail
        TicketPresenter(manager,ticket).apply { App.instance.appComponent.inject(this) }
    }

    override fun backPressed() = presenter.backClick()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentTicketBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun init() {
        binding.bottomNavigationView.setOnItemSelectedListener { item ->
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

    override fun setRecordId(record_id: Int) {
        binding.textRecordId.text = record_id.toString()
    }

    override fun setUsername(username: String) {
        binding.textUsername.text = username
    }

    override fun setDescr(descr: String) {
        binding.textDescr.text = descr
    }

    override fun setAddress(address: String) {
        binding.textAddress.text = address
    }

    override fun setNumber(number: String) {
        binding.textNumber.text = number
    }

    override fun setCreated(created: String) {
        binding.textCreated.text = created
    }

    override fun setExecuteStart(execute_start: String) {
        binding.textExecuteStart.text = execute_start
    }

    override fun settextExecuteFinal(execute_final: String) {
        binding.textExecuteFinal.text = execute_final
    }

    override fun setMobile(mobile: String) {
        binding.textMobile.text = mobile
    }

    override fun setTask(task: String) {
        binding.textTask.text = task
    }
}