package org.sochidrive.ticketlist.mvp.model.entity.room

import androidx.room.RoomDatabase
import org.sochidrive.ticketlist.mvp.model.entity.room.dao.TicketsDao

@androidx.room.Database(entities = [RoomTicket::class],version = 2)
abstract class Database: RoomDatabase() {
    abstract val ticket: TicketsDao

    companion object {
        const val DB_NAME = "database.db"
    }
}