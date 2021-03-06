package org.sochidrive.ticketlist.mvp.model.entity.room.dao

import androidx.room.*
import org.sochidrive.ticketlist.mvp.model.entity.room.RoomManager

@Dao
interface ManagerDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(manager: RoomManager)

    @Query("DELETE FROM RoomManager")
    fun deleteAll()

    @Query("SELECT * FROM RoomManager LIMIT 1")
    fun getManager(): RoomManager
}