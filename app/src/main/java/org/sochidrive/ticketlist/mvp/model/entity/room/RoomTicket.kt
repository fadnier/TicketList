package org.sochidrive.ticketlist.mvp.model.entity.room

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class RoomTicket (
    @PrimaryKey
    var record_id: Int,
    var username: String,
    var descr: String,
    var address: String,
    var number: String
)