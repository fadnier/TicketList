package org.sochidrive.ticketlist.mvp.model.entity.room

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.Expose

@Entity
class RoomTicket (
    @PrimaryKey
    var record_id: Int,
    var username: String,
    var theme: String,
    var address: String,
    var number: String,
    val created: String,
    val execute_start: String,
    val execute_final: String,
    val task: String,
    val mobile: String,
    val date_start: String,
    val date_start_minute: String,
    val date_start_hour: String,
    val date_final: String,
    val date_final_minute: String,
    val date_final_hour: String,
    val status_id: Int,
    val status_id_descr: String,
    val status_id_color: String,
    val author_name: String
)