package org.sochidrive.ticketlist.mvp.presenter

import io.reactivex.rxjava3.core.Scheduler
import moxy.MvpPresenter
import org.sochidrive.ticketlist.mvp.model.entity.AuthAnswer
import org.sochidrive.ticketlist.mvp.model.helpdesk.IHelpdeskLogin
import org.sochidrive.ticketlist.mvp.view.LoginView
import org.sochidrive.ticketlist.navigation.Screens
import ru.terrakok.cicerone.Router
import javax.inject.Inject

class LoginPresenter: MvpPresenter<LoginView>() {

    @Inject
    lateinit var authManager: IHelpdeskLogin
    @Inject
    lateinit var router: Router
    @Inject
    lateinit var mainThreadScheduler: Scheduler

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        viewState.init()
        viewState.loadLogo("https://api.tvintel.info/pic/logo_tvintel3.png")
//        authManager.checkCacheAuth().observeOn(mainThreadScheduler).subscribe({
//            auth(it)
//        },{
//            it.fillInStackTrace()
//        })
    }

    fun clickLoginBtn(login: String, password: String) {
        authManager.getAuth(login,password)
                .observeOn(mainThreadScheduler)
                .subscribe({
                    auth(it)
                },{
                    it.fillInStackTrace()
                })
    }

    fun auth(authAnswer: AuthAnswer) {
        if(authAnswer.result=="Ok") {
            viewState.showMessage("Успешно: "+authAnswer.data.name)
            router.replaceScreen(Screens.MainMenuScreen(authAnswer.data))
        } else {
            viewState.showMessage(authAnswer.data.answer)
        }
    }

    fun backClick(): Boolean {
        router.exit()
        return true
    }
}