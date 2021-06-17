package org.sochidrive.ticketlist.di

import dagger.Component
import org.sochidrive.ticketlist.di.module.*
import org.sochidrive.ticketlist.mvp.presenter.*
import org.sochidrive.ticketlist.ui.MainActivity
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AppModule::class,
        CiceroneModule::class,
        AuthModule::class,
        ApiModule::class,
        TicketModule::class,
        DatabaseModule::class
    ]
)
interface AppComponent {
    fun inject(mainActivity: MainActivity)
    fun inject(mainPresenter: MainPresenter)
    fun inject(loginPresenter: LoginPresenter)
    fun inject(mainMenuPresenter: MainMenuPresenter)
    fun inject(ticketPresenter: TicketPresenter)
    fun inject(ticketsDayPresenter: TicketsDayPresenter)
}