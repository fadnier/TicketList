package org.sochidrive.ticketlist.mvp.presenter

import moxy.MvpPresenter
import org.sochidrive.ticketlist.mvp.view.MainView
import org.sochidrive.ticketlist.navigation.Screens
import ru.terrakok.cicerone.Router

import javax.inject.Inject

class MainPresenter(): MvpPresenter<MainView>() {

    @Inject
    lateinit var router : Router

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        router.replaceScreen(Screens.LoginScreen())
    }

    fun backClick() {
        router.exit()
    }

}