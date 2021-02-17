package org.sochidrive.ticketlist.navigation

import androidx.fragment.app.Fragment
import org.sochidrive.ticketlist.mvp.model.entity.Manager
import org.sochidrive.ticketlist.ui.fragment.LoginFragment
import org.sochidrive.ticketlist.ui.fragment.TicketsFragment
import ru.terrakok.cicerone.android.support.SupportAppScreen

class Screens {

    class LoginScreen() : SupportAppScreen() {
        override fun getFragment() = LoginFragment.newInstance()
    }

    class TicketsScreen(val manager: Manager) : SupportAppScreen() {
        override fun getFragment() = TicketsFragment.newInstance(manager)
    }
}