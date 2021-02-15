package org.sochidrive.ticketlist.di

import dagger.Component
import org.sochidrive.ticketlist.di.module.AppModule
import org.sochidrive.ticketlist.mvp.presenter.MainPresenter
import org.sochidrive.ticketlist.ui.MainActivity
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AppModule::class
    ]
)
interface AppComponent {
    fun inject(mainActivity: MainActivity)
    fun inject(mainPresenter: MainPresenter)
}