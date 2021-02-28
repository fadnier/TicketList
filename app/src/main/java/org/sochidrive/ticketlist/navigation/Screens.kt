package org.sochidrive.ticketlist.navigation

import org.sochidrive.ticketlist.mvp.model.entity.Manager
import org.sochidrive.ticketlist.mvp.model.entity.TicketDetail
import org.sochidrive.ticketlist.ui.fragment.LoginFragment
import org.sochidrive.ticketlist.ui.fragment.MainMenuFragment
import org.sochidrive.ticketlist.ui.fragment.TicketFragment
import org.sochidrive.ticketlist.ui.fragment.TicketsFragment
import ru.terrakok.cicerone.android.support.SupportAppScreen

class Screens {

    class LoginScreen() : SupportAppScreen() {
        override fun getFragment() = LoginFragment.newInstance()
    }

    class TicketsScreen(val manager: Manager) : SupportAppScreen() {
        override fun getFragment() = TicketsFragment.newInstance(manager)
    }

    class MainMenuScreen(val manager: Manager) : SupportAppScreen() {
        override fun getFragment() = MainMenuFragment.newInstance(manager)
    }

    class TicketScreen(val manager: Manager, val ticket: TicketDetail) : SupportAppScreen() {
        override fun getFragment() = TicketFragment.newInstance(manager, ticket)
    }
}