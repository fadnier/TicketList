package org.sochidrive.ticketlist.mvp.presenter

import io.reactivex.rxjava3.core.Scheduler
import moxy.MvpPresenter
import org.sochidrive.ticketlist.mvp.model.helpdesk.IHelpdeskLogin
import org.sochidrive.ticketlist.mvp.view.LoginView
import ru.terrakok.cicerone.Router
import java.util.concurrent.Flow
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
    }

    fun clickLoginBtn(login: String, password: String) {
        authManager.getAuth(login,password)
                .observeOn(mainThreadScheduler)
                .subscribe({
                    if(it.result=="Ok") {
                        viewState.showMessage("Успешно: "+it.data.name)
                    } else {
                        viewState.showMessage(it.data.answer)
                    }
                },{
                    it.fillInStackTrace()
                })
    }

    fun backClick(): Boolean {
        router.exit()
        return true
    }
}