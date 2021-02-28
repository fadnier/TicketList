package org.sochidrive.ticketlist.mvp.model.entity

import android.os.Parcelable
import com.google.gson.annotations.Expose
import kotlinx.android.parcel.Parcelize

@Parcelize
class TicketDetail (
    @Expose
    val record_id: Int,
    @Expose
    val created: String,
    @Expose
    val execute_start: String,
    @Expose
    val execute_final: String,
    @Expose
    val username: String,
    @Expose
    val task: String,
    @Expose
    val mobile: String,
    @Expose
    val address: String,
    @Expose
    val theme: String,
    @Expose
    val date_start: String,
    @Expose
    val date_start_minute: String,
    @Expose
    val date_start_hour: String,
    @Expose
    val date_final: String,
    @Expose
    val date_final_minute: String,
    @Expose
    val date_final_hour: String,
    @Expose
    val number: String,
): Parcelable