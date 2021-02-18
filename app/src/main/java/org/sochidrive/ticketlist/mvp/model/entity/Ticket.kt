package org.sochidrive.ticketlist.mvp.model.entity

import android.os.Parcelable
import com.google.gson.annotations.Expose
import kotlinx.android.parcel.Parcelize

@Parcelize
class Ticket (
    @Expose
    val record_id: Int,
    @Expose
    val username: String,
    @Expose
    val descr: String,
    @Expose
    val address: String,
    @Expose
    val number: String
): Parcelable