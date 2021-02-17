package org.sochidrive.ticketlist.mvp.model.entity

import android.os.Parcelable
import com.google.gson.annotations.Expose
import kotlinx.android.parcel.Parcelize

@Parcelize
data class TicketAnswer (
    @Expose
    val result: String,
    @Expose
    val data: List<Ticket>
): Parcelable