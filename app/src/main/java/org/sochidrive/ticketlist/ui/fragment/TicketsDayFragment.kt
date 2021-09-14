package org.sochidrive.ticketlist.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter
import org.sochidrive.ticketlist.App
import org.sochidrive.ticketlist.databinding.FragmentListTicketDayBinding
import org.sochidrive.ticketlist.mvp.model.entity.Manager
import org.sochidrive.ticketlist.mvp.presenter.TicketsDayPresenter
import org.sochidrive.ticketlist.mvp.view.TicketsViewToday
import org.sochidrive.ticketlist.ui.BackButtonListener
import org.sochidrive.ticketlist.ui.adapter.TicketsDayRvAdapter

class TicketsDayFragment: MvpAppCompatFragment(), BackButtonListener, TicketsViewToday {
    private lateinit var binding: FragmentListTicketDayBinding

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

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle? ): View {
        binding = FragmentListTicketDayBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun backPressed() = presenter.backClick()

    override fun init() {
        binding.rvTickets.layoutManager = LinearLayoutManager(requireContext())
        adapter = TicketsDayRvAdapter(presenter.ticketsListPresenter)
        binding.rvTickets.adapter = adapter
        binding.btnYesterday.setOnClickListener { presenter.clickYesterdayBtn() }
        binding.btnTomorrow.setOnClickListener { presenter.clickTomorrowBtn() }
    }

    override fun updateTicketsList() {
        adapter?.notifyDataSetChanged()
    }

    override fun clickTomorrowBtn() {
        presenter.clickTomorrowBtn()
    }

    override fun clickYesterdayBtn() {
        presenter.clickYesterdayBtn()
    }

    override fun setTextTomorrowBtn(day: String) {
        binding.btnTomorrow.text = day
    }

    override fun setTextYesterdayBtn(day: String) {
        binding.btnYesterday.text = day
    }

    override fun setToday(day: String) {
        binding.textToday.text = day
    }

}