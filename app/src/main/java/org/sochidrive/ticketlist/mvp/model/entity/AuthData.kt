package org.sochidrive.ticketlist.mvp.model.entity

import android.os.Parcelable
import com.google.gson.annotations.Expose
import kotlinx.android.parcel.Parcelize
import java.io.Serializable

@Parcelize
data class AuthData (
    @Expose
    val login: String,
    @Expose
    val pass: String
): Parcelable