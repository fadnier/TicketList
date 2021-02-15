package org.sochidrive.ticketlist.di.module

import dagger.Module
import dagger.Provides
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Scheduler
import org.sochidrive.ticketlist.App

@Module
class AppModule(val app: App) {

    @Provides
    fun app(): App {
        return app
    }

    @Provides
    fun mainTreadSchelduler(): Scheduler = AndroidSchedulers.mainThread()
}