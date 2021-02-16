package org.sochidrive.ticketlist.navigation

import androidx.fragment.app.Fragment
import org.sochidrive.ticketlist.ui.fragment.LoginFragment
import ru.terrakok.cicerone.android.support.SupportAppScreen

class Screens {

    class LoginScreen() : SupportAppScreen() {
        override fun getFragment() = LoginFragment.newInstance()
    }
}