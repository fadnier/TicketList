package org.sochidrive.ticketlist.mvp.model.entity

import android.os.Parcelable
import com.google.gson.annotations.Expose
import kotlinx.android.parcel.Parcelize

@Parcelize
class TicketDayData (
    @Expose
    val id: Int,
    @Expose
    val name: String,
    @Expose
    val day: String
): Parcelable