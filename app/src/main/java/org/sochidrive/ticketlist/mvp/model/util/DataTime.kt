package org.sochidrive.ticketlist.mvp.model.util

import java.text.SimpleDateFormat
import java.util.*

object  DataTime {
    fun getCurrentTime():String {
        val formatDate = SimpleDateFormat("yyyy-MM-dd")
        return formatDate.format(Date())
    }

    fun getDayTomorrow(date: String):String {
        val myDate = SimpleDateFormat("yyyy-MM-dd").parse(date)
        val instance = Calendar.getInstance()
        instance.time = myDate
        instance.add(Calendar.DAY_OF_MONTH, 1)
        val newDate = instance.time
        val formatDate = SimpleDateFormat("yyyy-MM-dd")
        return formatDate.format(newDate)
    }

    fun getDayYesterday(date: String):String {
        val myDate = SimpleDateFormat("yyyy-MM-dd").parse(date)
        val instance = Calendar.getInstance()
        instance.time = myDate
        instance.add(Calendar.DAY_OF_MONTH, -1)
        val newDate = instance.time
        val formatDate = SimpleDateFormat("yyyy-MM-dd")
        return formatDate.format(newDate)
    }
}