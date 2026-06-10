package com.yourname.qrattendance.data.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.yourname.qrattendance.data.entities.ClassRoom

@Dao
interface ClassRoomDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertClass(classRoom: ClassRoom)

    @Update
    suspend fun updateClass(classRoom: ClassRoom)

    @Delete
    suspend fun deleteClass(classRoom: ClassRoom)

    @Query("SELECT * FROM classes WHERE teacherId = :teacherId")
    fun getClassesByTeacher(teacherId: Int): LiveData<List<ClassRoom>>

    @Query("SELECT * FROM classes WHERE classCode = :code LIMIT 1")
    suspend fun getClassByCode(code: String): ClassRoom?

    @Query("SELECT * FROM classes WHERE id = :classId LIMIT 1")
    suspend fun getClassById(classId: Int): ClassRoom?
}
