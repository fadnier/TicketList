package org.sochidrive.ticketlist.mvp.presenter

import io.reactivex.rxjava3.core.Scheduler
import moxy.MvpPresenter
import org.sochidrive.ticketlist.mvp.model.entity.Manager
import org.sochidrive.ticketlist.mvp.model.entity.TicketDetail
import org.sochidrive.ticketlist.mvp.model.helpdesk.ITicketDetailHelpdesk
import org.sochidrive.ticketlist.mvp.view.TicketView
import org.sochidrive.ticketlist.navigation.Screens
import ru.terrakok.cicerone.Router
import javax.inject.Inject

class TicketPresenter(val manager: Manager, val ticket: TicketDetail): MvpPresenter<TicketView>() {
    @Inject
    lateinit var ticketHelpdesk: ITicketDetailHelpdesk

    @Inject
    lateinit var router: Router

    @Inject
    lateinit var mainThreadScheduler: Scheduler

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        viewState.init()
        loadData()
    }

    fun loadData() {
        ticketHelpdesk.getTicketId(manager,ticket)
                .observeOn(mainThreadScheduler)
                .subscribe({ answer ->
                    if(answer.result=="Ok") {
                        viewState.setAddress(answer.data.address)
                        viewState.setCreated(answer.data.created)
                        viewState.setDescr(answer.data.theme)
                        viewState.setExecuteStart(answer.data.execute_start)
                        viewState.setMobile(answer.data.mobile)
                        viewState.setNumber(answer.data.number)
                        viewState.setRecordId(answer.data.record_id)
                        viewState.setTask(answer.data.task)
                        viewState.setUsername(answer.data.username)
                        viewState.settextExecuteFinal(answer.data.execute_final)
                        viewState.setComments(answer.data.comments.size)
                    } else {
                        router.navigateTo(Screens.LoginScreen())
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