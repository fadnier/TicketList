package org.sochidrive.ticketlist.mvp.presenter

import io.reactivex.rxjava3.core.Scheduler
import moxy.MvpPresenter
import org.sochidrive.ticketlist.mvp.model.entity.Manager
import org.sochidrive.ticketlist.mvp.model.entity.TicketDetail
import org.sochidrive.ticketlist.mvp.model.helpdesk.ITicketDayHelpdesk
import org.sochidrive.ticketlist.mvp.model.util.DataTime
import org.sochidrive.ticketlist.mvp.presenter.list.ITicketsDayListPresenter
import org.sochidrive.ticketlist.mvp.view.TicketsViewToday
import org.sochidrive.ticketlist.mvp.view.list.TicketItemDayView
import org.sochidrive.ticketlist.navigation.Screens
import ru.terrakok.cicerone.Router
import javax.inject.Inject

class TicketsDayPresenter(val manager: Manager): MvpPresenter<TicketsViewToday>() {

    @Inject
    lateinit var ticketsDayHelpdesk: ITicketDayHelpdesk

    @Inject
    lateinit var router: Router

    @Inject
    lateinit var mainThreadScheduler: Scheduler

    private var selectToday: String = "2021-01-01"


    class TicketsListPresenter() : ITicketsDayListPresenter {
        override var itemClickListener: ((TicketItemDayView) -> Unit)? = null

        val tickets = mutableListOf<TicketDetail>()

        override fun bindView(view: TicketItemDayView) {
            val ticket = tickets[view.pos]
            val time = ticket.date_start_hour+":"+ticket.date_start_minute+"-"+ticket.date_final_hour+":"+ticket.date_final_minute
            view.setTicketAddress(ticket.address)
            view.setTime(time)
            view.setTicketNumber(ticket.number)
            view.setStatusColor(ticket.status_id_color)
        }

        override fun getCount() = tickets.size
    }

    val ticketsListPresenter = TicketsListPresenter()

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        selectToday = DataTime.getCurrentTime()
        viewState.init()
        loadData()

        ticketsListPresenter.itemClickListener = {
            router.navigateTo(Screens.TicketScreen(manager,ticketsListPresenter.tickets[it.pos]))
        }

    }

    private fun loadData() {
        ticketsDayHelpdesk.getTickets(manager,selectToday)
            .observeOn(mainThreadScheduler)
            .subscribe({
                if(it.result=="Ok") {
                    ticketsListPresenter.tickets.clear()
                    ticketsListPresenter.tickets.addAll(it.data)
                    viewState.updateTicketsList()
                } else {
                    router.navigateTo(Screens.LoginScreen())
                }
            },{
                it.fillInStackTrace()
            })
        viewState.setTextTomorrowBtn(DataTime.getDayTomorrow(selectToday))
        viewState.setTextYesterdayBtn(DataTime.getDayYesterday(selectToday))
    }

    fun clickTomorrowBtn() {
        selectToday = DataTime.getDayTomorrow(selectToday)
        loadData()
    }

    fun clickYesterdayBtn() {
        selectToday = DataTime.getDayYesterday(selectToday)
        loadData()
    }

    fun backClick(): Boolean {
        router.exit()
        return true
    }
}