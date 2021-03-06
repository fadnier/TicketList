package org.sochidrive.ticketlist.mvp.model.entity.room

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class RoomManager (
    @PrimaryKey
    val id: Int,
    val login: String,
    val name: String,
    val user_level: Int,
    val token: String
)