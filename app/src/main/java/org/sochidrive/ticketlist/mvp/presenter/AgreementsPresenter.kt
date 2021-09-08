package org.sochidrive.ticketlist.mvp.presenter

import moxy.MvpPresenter
import org.sochidrive.ticketlist.mvp.model.entity.Manager
import org.sochidrive.ticketlist.mvp.model.entity.TicketDetail
import org.sochidrive.ticketlist.mvp.view.AgreementsView
import org.sochidrive.ticketlist.navigation.Screens
import ru.terrakok.cicerone.Router
import javax.inject.Inject

class AgreementsPresenter(val manager: Manager, val ticket: TicketDetail): MvpPresenter<AgreementsView>() {
    @Inject
    lateinit var router: Router

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        viewState.init()
        loadData()
    }

    fun loadData() {

    }

    fun btnTicketClick(): Boolean {
        router.replaceScreen(Screens.TicketScreen(manager, ticket))
        return true
    }

    fun btnAgrmClick(): Boolean {
        router.replaceScreen(Screens.AgreementsScreen(manager, ticket))
        return true
    }

    fun btnExitClick(): Boolean {
        router.replaceScreen(Screens.MainMenuScreen(manager))
        return true
    }

    fun backClick(): Boolean {
        router.exit()
        return true
    }
}