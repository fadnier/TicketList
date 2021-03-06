package org.sochidrive.ticketlist.mvp.presenter

import io.reactivex.rxjava3.core.Scheduler
import moxy.MvpPresenter
import org.sochidrive.ticketlist.mvp.model.entity.Manager
import org.sochidrive.ticketlist.mvp.model.entity.TicketDetail
import org.sochidrive.ticketlist.mvp.model.helpdesk.ITicketDayHelpdesk
import org.sochidrive.ticketlist.mvp.presenter.list.ITicketsDayListPresenter
import org.sochidrive.ticketlist.mvp.presenter.list.ITicketsListPresenter
import org.sochidrive.ticketlist.mvp.view.TicketsView
import org.sochidrive.ticketlist.mvp.view.list.TicketItemDayView
import org.sochidrive.ticketlist.mvp.view.list.TicketItemView
import org.sochidrive.ticketlist.navigation.Screens
import ru.terrakok.cicerone.Router
import javax.inject.Inject

class TicketsDayPresenter(val manager: Manager): MvpPresenter<TicketsView>() {

    @Inject
    lateinit var ticketsDayHelpdesk: ITicketDayHelpdesk

    @Inject
    lateinit var router: Router

    @Inject
    lateinit var mainThreadScheduler: Scheduler


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
        viewState.init()
        loadData()

        ticketsListPresenter.itemClickListener = {
            router.navigateTo(Screens.TicketScreen(manager,ticketsListPresenter.tickets[it.pos]))
        }
    }

    fun loadData() {
        ticketsDayHelpdesk.getTickets(manager)
            .observeOn(mainThreadScheduler)
            .subscribe({
                ticketsListPresenter.tickets.clear()
                ticketsListPresenter.tickets.addAll(it)
                viewState.updateTicketsList()
            },{
                it.fillInStackTrace()
            })
    }

    fun backClick(): Boolean {
        router.exit()
        return true
    }
}