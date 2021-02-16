package org.sochidrive.ticketlist.mvp.model.entity

import android.os.Parcelable
import com.google.gson.annotations.Expose
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Answer (
    @Expose
    val result: String,
    @Expose
    val data: Manager
): Parcelable