package org.sochidrive.ticketlist.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.main_menu_fragment.*
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter
import org.sochidrive.ticketlist.App
import org.sochidrive.ticketlist.R
import org.sochidrive.ticketlist.mvp.model.entity.Manager
import org.sochidrive.ticketlist.mvp.presenter.MainMenuPresenter
import org.sochidrive.ticketlist.mvp.view.MainMenuView
import org.sochidrive.ticketlist.ui.BackButtonListener

class MainMenuFragment: MvpAppCompatFragment(), BackButtonListener, MainMenuView {

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

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle? ) =
            View.inflate(context, R.layout.main_menu_fragment, null)

    override fun backPressed() = presenter.backClick()

    override fun init() {
        btnTicketToday.setOnClickListener { clickBtnTodayTicket() }
        btnExit.setOnClickListener { clickBtnExit() }
    }

    override fun clickBtnTodayTicket() {
        presenter.clickBtnTodayTicket()
    }

    override fun clickBtnExit() {
        presenter.clickBtnExit()
    }

    override fun setName(name: String) {
        montagName.text = name
    }
}