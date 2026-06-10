package com.yourname.qrattendance

import android.app.Application
import com.yourname.qrattendance.data.database.AppDatabase
import com.yourname.qrattendance.data.repository.AppRepository

class QRAttendanceApp : Application() {
    val database by lazy { AppDatabase.getDatabase(this) }
    val repository by lazy {
        AppRepository(
            database.userDao(),
            database.classRoomDao(),
            database.sessionDao(),
            database.attendanceDao()
        )
    }
}
