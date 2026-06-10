package com.yourname.qrattendance.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.yourname.qrattendance.data.dao.*
import com.yourname.qrattendance.data.entities.*

@Database(
    entities = [User::class, ClassRoom::class, Session::class, Attendance::class],
    version = 1,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
    abstract fun classRoomDao(): ClassRoomDao
    abstract fun sessionDao(): SessionDao
    abstract fun attendanceDao(): AttendanceDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "qr_attendance_database"  // FIX: was bare identifier `qr_attendance_database` (compile error); must be a quoted String
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}
