package org.sochidrive.ticketlist.mvp.model.entity.room

import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase

val MIGRATION_1_2 = object : Migration(1,2) {
    override fun migrate(database: SupportSQLiteDatabase) {
        database.execSQL("ALTER TABLE RoomTicket ADD COLUMN status_id INTEGER NOT NULL DEFAULT '0'")
        database.execSQL("ALTER TABLE RoomTicket ADD COLUMN status_id_descr TEXT NOT NULL DEFAULT ''")
        database.execSQL("ALTER TABLE RoomTicket ADD COLUMN status_id_color TEXT NOT NULL DEFAULT ''")
        database.execSQL("UPDATE RoomTicket SET status_id_color = 'FF0000'")
        database.execSQL("ALTER TABLE RoomTicket ADD COLUMN author_name TEXT NOT NULL DEFAULT ''")
    }

}