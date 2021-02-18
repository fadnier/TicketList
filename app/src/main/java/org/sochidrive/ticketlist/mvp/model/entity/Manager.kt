package org.sochidrive.ticketlist.mvp.model.entity

import android.os.Parcelable
import com.google.gson.annotations.Expose
import kotlinx.android.parcel.Parcelize

@Parcelize
class Manager (
    @Expose
    val answer: String?,
    @Expose
    val id: Int?,
    @Expose
    val login: String?,
    @Expose
    val password: String?,
    @Expose
    val name: String?,
    @Expose
    val user_level: Int?,
    @Expose
    val token: String?
): Parcelable