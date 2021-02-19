package org.sochidrive.ticketlist.mvp.model.entity

import android.os.Parcelable
import com.google.gson.annotations.Expose
import kotlinx.android.parcel.Parcelize

@Parcelize
data class TicketData (
        @Expose
        val id: Int,
        @Expose
        val record_id: Int
): Parcelable