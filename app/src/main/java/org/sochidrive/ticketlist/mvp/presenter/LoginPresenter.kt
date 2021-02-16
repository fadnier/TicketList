package org.sochidrive.ticketlist.mvp.presenter

import moxy.MvpPresenter
import org.sochidrive.ticketlist.mvp.view.LoginView
import ru.terrakok.cicerone.Router
import javax.inject.Inject

class LoginPresenter: MvpPresenter<LoginView>() {

    @Inject
    lateinit var router: Router

    fun backClick(): Boolean {
        router.exit()
        return true
    }
}