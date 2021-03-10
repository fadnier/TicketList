package org.sochidrive.ticketlist.mvp.model.entity.room

import androidx.room.RoomDatabase
import org.sochidrive.ticketlist.mvp.model.entity.room.dao.ManagerDao
import org.sochidrive.ticketlist.mvp.model.entity.room.dao.TicketsDao

@androidx.room.Database(entities = [RoomTicket::class, RoomManager::class],version = 3)
abstract class Database: RoomDatabase() {
    abstract val ticket: TicketsDao
    abstract val manager: ManagerDao

    companion object {
        const val DB_NAME = "database.db"
    }
}