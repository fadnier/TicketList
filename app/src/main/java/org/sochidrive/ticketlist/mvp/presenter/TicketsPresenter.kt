package org.sochidrive.ticketlist.mvp.presenter

import io.reactivex.rxjava3.core.Scheduler
import moxy.MvpPresenter
import org.sochidrive.ticketlist.mvp.model.entity.Manager
import org.sochidrive.ticketlist.mvp.model.entity.Ticket
import org.sochidrive.ticketlist.mvp.model.helpdesk.ITicketHelpdesk
import org.sochidrive.ticketlist.mvp.presenter.list.ITicketsListPresenter
import org.sochidrive.ticketlist.mvp.view.TicketsView
import org.sochidrive.ticketlist.mvp.view.list.TicketItemView
import org.sochidrive.ticketlist.navigation.Screens
import ru.terrakok.cicerone.Router
import javax.inject.Inject

class TicketsPresenter(val manager: Manager): MvpPresenter<TicketsView>() {

    @Inject
    lateinit var ticketsHelpdesk: ITicketHelpdesk

    @Inject
    lateinit var router: Router

    @Inject
    lateinit var mainThreadScheduler: Scheduler


    class TicketsListPresenter() : ITicketsListPresenter {
        override var itemClickListener: ((TicketItemView) -> Unit)? = null

        val tickets = mutableListOf<Ticket>()

        override fun bindView(view: TicketItemView) {
            val ticket = tickets[view.pos]

            ticket?.record_id.let { view.setTicketId(it) }
        }

        override fun getCount() = tickets.size


    }

    val ticketsListPresenter = TicketsListPresenter()

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        viewState.init()
        loadData()

        ticketsListPresenter.itemClickListener = {
            //router.navigateTo(Screens.TicketsScreen)
        }
    }

    fun loadData() {
        ticketsHelpdesk.getTickets(manager)
            .observeOn(mainThreadScheduler)
            .subscribe({
                ticketsListPresenter.tickets.clear()
                ticketsListPresenter.tickets.addAll(it.data)
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