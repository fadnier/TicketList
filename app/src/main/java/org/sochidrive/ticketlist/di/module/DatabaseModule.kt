package org.sochidrive.ticketlist.di.module

import androidx.room.Room
import dagger.Module
import dagger.Provides
import org.sochidrive.ticketlist.App
import org.sochidrive.ticketlist.mvp.model.cache.IHelpdeskTicketsCache
import org.sochidrive.ticketlist.mvp.model.cache.room.RoomHelpdeskTicketsCache
import org.sochidrive.ticketlist.mvp.model.entity.room.Database
import javax.inject.Singleton

@Module
class DatabaseModule {
    @Singleton
    @Provides
    fun database(app: App) = Room.databaseBuilder(app, Database::class.java, Database.DB_NAME)
            .fallbackToDestructiveMigration()// - для разрушения бд и создания новой
            //.addMigrations(MIGRATION_1_2)
            .build()

    @Singleton
    @Provides
    fun ticketsCache(database: Database): IHelpdeskTicketsCache {
        return RoomHelpdeskTicketsCache(database)
    }
}