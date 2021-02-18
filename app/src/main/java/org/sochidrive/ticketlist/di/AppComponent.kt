package org.sochidrive.ticketlist.di

import dagger.Component
import org.sochidrive.ticketlist.di.module.*
import org.sochidrive.ticketlist.mvp.presenter.LoginPresenter
import org.sochidrive.ticketlist.mvp.presenter.MainMenuPresenter
import org.sochidrive.ticketlist.mvp.presenter.MainPresenter
import org.sochidrive.ticketlist.mvp.presenter.TicketsPresenter
import org.sochidrive.ticketlist.ui.MainActivity
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AppModule::class,
        CiceroneModule::class,
        AuthModule::class,
        ApiModule::class,
        TicketModule::class
    ]
)
interface AppComponent {
    fun inject(mainActivity: MainActivity)
    fun inject(mainPresenter: MainPresenter)
    fun inject(loginPresenter: LoginPresenter)
    fun inject(ticketsPresenter: TicketsPresenter)
    fun inject(mainMenuPresenter: MainMenuPresenter)
}