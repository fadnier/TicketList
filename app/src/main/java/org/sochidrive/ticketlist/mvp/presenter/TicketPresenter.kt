package org.sochidrive.ticketlist.mvp.presenter

import io.reactivex.rxjava3.core.Scheduler
import moxy.MvpPresenter
import org.sochidrive.ticketlist.mvp.model.entity.Manager
import org.sochidrive.ticketlist.mvp.model.entity.TicketDetail
import org.sochidrive.ticketlist.mvp.model.helpdesk.ITicketDetailHelpdesk
import org.sochidrive.ticketlist.mvp.view.TicketView
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
                .subscribe({
                    viewState.setAddress(it.address)
                    viewState.setCreated(it.created)
                    viewState.setDescr(it.theme)
                    viewState.setExecuteStart(it.execute_start)
                    viewState.setMobile(it.mobile)
                    viewState.setNumber(it.number)
                    viewState.setRecordId(it.record_id)
                    viewState.setTask(it.task)
                    viewState.setUsername(it.username)
                    viewState.settextExecuteFinal(it.execute_final)
                },{
                    it.fillInStackTrace()
                })
    }

    fun backClick(): Boolean {
        router.exit()
        return true
    }
}