package com.yourname.qrattendance.data.repository

import androidx.lifecycle.LiveData
import com.yourname.qrattendance.data.dao.*
import com.yourname.qrattendance.data.entities.*

class AppRepository(
    private val userDao: UserDao,
    private val classRoomDao: ClassRoomDao,
    private val sessionDao: SessionDao,
    private val attendanceDao: AttendanceDao
) {
    // User operations
    suspend fun registerUser(user: User) = userDao.insertUser(user)
    suspend fun login(email: String, password: String) = userDao.login(email, password)
    suspend fun getUserByEmail(email: String) = userDao.getUserByEmail(email)
    suspend fun getUserById(userId: Int) = userDao.getUserById(userId)

    // Class operations
    suspend fun insertClass(classRoom: ClassRoom) = classRoomDao.insertClass(classRoom)
    suspend fun updateClass(classRoom: ClassRoom) = classRoomDao.updateClass(classRoom)
    suspend fun deleteClass(classRoom: ClassRoom) = classRoomDao.deleteClass(classRoom)
    fun getClassesByTeacher(id: Int) = classRoomDao.getClassesByTeacher(id)
    suspend fun getClassByCode(code: String) = classRoomDao.getClassByCode(code)
    suspend fun getClassById(id: Int) = classRoomDao.getClassById(id)

    // Session operations
    suspend fun insertSession(session: Session) = sessionDao.insertSession(session)
    suspend fun updateSession(session: Session) = sessionDao.updateSession(session)
    fun getSessionsByClass(id: Int) = sessionDao.getSessionsByClass(id)
    suspend fun getSessionById(id: Int) = sessionDao.getSessionById(id)
    suspend fun endSession(id: Int) = sessionDao.endSession(id)

    // Attendance operations
    suspend fun insertAttendance(a: Attendance) = attendanceDao.insertAttendance(a)
    fun getAttendanceBySession(id: Int) = attendanceDao.getAttendanceBySession(id)
    fun getStudentAttendance(sId: Int, cId: Int) = attendanceDao.getStudentAttendance(sId, cId)
    fun getAttendanceCount(id: Int) = attendanceDao.getAttendanceCount(id)
    suspend fun checkAlreadyMarked(sId: Int, stId: Int) = attendanceDao.checkAlreadyMarked(sId, stId)
}
