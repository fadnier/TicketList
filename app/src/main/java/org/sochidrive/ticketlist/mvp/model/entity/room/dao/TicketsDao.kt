package org.sochidrive.ticketlist.mvp.model.entity.room.dao

import androidx.room.*
import org.sochidrive.ticketlist.mvp.model.entity.room.RoomTicket

@Dao
interface TicketsDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(ticket: RoomTicket)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(vararg ticket: RoomTicket)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(ticket: List<RoomTicket>)

    @Update
    fun update(ticket: RoomTicket)

    @Update
    fun update(vararg ticket: RoomTicket)

    @Update
    fun update(ticket: List<RoomTicket>)

    @Delete
    fun delete(ticket: RoomTicket)

    @Delete
    fun delete(vararg ticket: RoomTicket)

    @Delete
    fun delete(ticket: List<RoomTicket>)

    @Query("SELECT * FROM RoomTicket")
    fun getAll(): List<RoomTicket>

    @Query("SELECT * FROM RoomTicket WHERE record_id = :recordId")
    fun findForTicket(recordId: Int): RoomTicket
}