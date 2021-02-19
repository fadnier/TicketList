package org.sochidrive.ticketlist.mvp.model.entity.room

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.Expose

@Entity
class RoomTicket (
        @PrimaryKey
    var record_id: Int,
        var username: String,
        var descr: String,
        var address: String,
        var number: String,
        val created: String? = null,
        val execute_start: String? = null,
        val execute_final: String? = null,
        val task: String? = null,
        val mobile: String? = null,
        val date_start: String? = null,
        val date_start_minute: String? = null,
        val date_start_hour: String? = null,
        val date_final: String? = null,
        val date_final_minute: String? = null,
        val date_final_hour: String? = null
)