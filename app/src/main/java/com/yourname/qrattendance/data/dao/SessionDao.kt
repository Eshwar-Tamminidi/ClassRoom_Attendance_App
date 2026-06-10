package com.yourname.qrattendance.data.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.yourname.qrattendance.data.entities.Session

@Dao
interface SessionDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSession(session: Session): Long

    @Update
    suspend fun updateSession(session: Session)

    @Query("SELECT * FROM sessions WHERE classId = :classId ORDER BY generatedAt DESC")
    fun getSessionsByClass(classId: Int): LiveData<List<Session>>

    @Query("SELECT * FROM sessions WHERE id = :sessionId LIMIT 1")
    suspend fun getSessionById(sessionId: Int): Session?

    // FIX: Use @Query with UPDATE instead of raw SQL string for type safety
    @Query("UPDATE sessions SET isActive = 0 WHERE id = :sessionId")
    suspend fun endSession(sessionId: Int)
}
