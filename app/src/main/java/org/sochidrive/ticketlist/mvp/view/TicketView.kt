package org.sochidrive.ticketlist.mvp.view

import moxy.MvpView
import moxy.viewstate.strategy.alias.AddToEndSingle

@AddToEndSingle
interface TicketView: MvpView {
    fun init()
    fun setRecordId(record_id: Int)
    fun setUsername(username: String)
    fun setDescr(descr: String)
    fun setAddress(address: String)
    fun setNumber(number: String)
    fun setCreated(created: String)
    fun setExecuteStart(execute_start: String)
    fun settextExecuteFinal(execute_final: String)
    fun setMobile(mobile: String)
    fun setTask(task: String)
    fun setComments(commentCount: Int)
}