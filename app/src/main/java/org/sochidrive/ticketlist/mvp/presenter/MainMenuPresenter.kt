package org.sochidrive.ticketlist.mvp.presenter

import io.reactivex.rxjava3.core.Scheduler
import moxy.MvpPresenter
import org.sochidrive.ticketlist.mvp.model.cache.IHelpdeskManagerCache
import org.sochidrive.ticketlist.mvp.model.entity.Manager
import org.sochidrive.ticketlist.mvp.view.MainMenuView
import org.sochidrive.ticketlist.navigation.Screens
import ru.terrakok.cicerone.Router
import javax.inject.Inject

class MainMenuPresenter(private val manager: Manager): MvpPresenter<MainMenuView>() {

    @Inject
    lateinit var router: Router
    @Inject
    lateinit var cacheManager: IHelpdeskManagerCache
    @Inject
    lateinit var mainThreadScheduler: Scheduler

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        viewState.init()
        viewState.setName(manager.name.toString())
    }

    fun clickBtnTodayTicket() {
        router.navigateTo(Screens.TicketsDayScreen(manager))
    }

    fun clickBtnExit() {
        cacheManager.delSaveManager().observeOn(mainThreadScheduler).subscribe({
            this.router.newRootScreen(Screens.LoginScreen())
        },{
            //empty
        })
    }

    fun backClick(): Boolean {
        router.exit()
        return true
    }
}