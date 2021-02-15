package org.sochidrive.ticketlist

import android.app.Application
import org.sochidrive.ticketlist.di.AppComponent
import org.sochidrive.ticketlist.di.DaggerAppComponent
import org.sochidrive.ticketlist.di.module.AppModule

class App : Application() {

    lateinit var appComponent: AppComponent
        private set

    companion object {
        lateinit var instance: App
    }

    override fun onCreate() {
        super.onCreate()
        instance = this

        appComponent = DaggerAppComponent.builder().appModule(AppModule(this)).build()
    }
}