package com.yourname.qrattendance.data.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.yourname.qrattendance.data.entities.Attendance

@Dao
interface AttendanceDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAttendance(attendance: Attendance)

    @Query("SELECT * FROM attendance WHERE sessionId = :sessionId")
    fun getAttendanceBySession(sessionId: Int): LiveData<List<Attendance>>

    @Query("SELECT * FROM attendance WHERE studentId = :studentId AND classId = :classId")
    fun getStudentAttendance(studentId: Int, classId: Int): LiveData<List<Attendance>>

    @Query("SELECT COUNT(*) FROM attendance WHERE sessionId = :sessionId")
    fun getAttendanceCount(sessionId: Int): LiveData<Int>

    @Query("SELECT * FROM attendance WHERE sessionId = :sessionId AND studentId = :studentId LIMIT 1")
    suspend fun checkAlreadyMarked(sessionId: Int, studentId: Int): Attendance?

    @Query("SELECT COUNT(*) FROM attendance WHERE studentId = :studentId AND classId = :classId")
    suspend fun getStudentAttendanceCount(studentId: Int, classId: Int): Int
}
