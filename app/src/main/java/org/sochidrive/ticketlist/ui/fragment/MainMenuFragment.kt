package org.sochidrive.ticketlist.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter
import org.sochidrive.ticketlist.App
import org.sochidrive.ticketlist.databinding.MainMenuFragmentBinding
import org.sochidrive.ticketlist.mvp.model.entity.Manager
import org.sochidrive.ticketlist.mvp.presenter.MainMenuPresenter
import org.sochidrive.ticketlist.mvp.view.MainMenuView
import org.sochidrive.ticketlist.ui.BackButtonListener

class MainMenuFragment: MvpAppCompatFragment(), BackButtonListener, MainMenuView {
    private lateinit var binding: MainMenuFragmentBinding

    companion object {
        private const val MANAGER_ARG = "manager"

        fun newInstance(manager: Manager) = MainMenuFragment().apply {
            arguments = Bundle().apply {
                putParcelable(MANAGER_ARG, manager)
            }
        }
    }

    val presenter by moxyPresenter {
        val managers = arguments?.getParcelable<Manager>(MainMenuFragment.MANAGER_ARG) as Manager
        MainMenuPresenter(managers).apply { App.instance.appComponent.inject(this) }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle? ) : View {
        binding = MainMenuFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun backPressed() = presenter.backClick()

    override fun init() {
        binding.btnTicketToday.setOnClickListener { clickBtnTodayTicket() }
        binding.btnExit.setOnClickListener { clickBtnExit() }
    }

    override fun clickBtnTodayTicket() {
        presenter.clickBtnTodayTicket()
    }

    override fun clickBtnExit() {
        presenter.clickBtnExit()
    }

    override fun setName(name: String) {
        binding.montagName.text = name
    }
}