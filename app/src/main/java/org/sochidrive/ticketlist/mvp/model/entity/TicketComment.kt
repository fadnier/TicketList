package org.sochidrive.ticketlist.mvp.model.entity

import android.os.Parcelable
import com.google.gson.annotations.Expose
import kotlinx.android.parcel.Parcelize

@Parcelize
class TicketComment (
    @Expose
    val id: Int,
    @Expose
    val date: String,
    @Expose
    val id_man: Int,
    @Expose
    val fio_man: String,
    @Expose
    val text: String,
): Parcelable