package com.yourname.qrattendance.data.dao;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u00a7@\u00a2\u0006\u0002\u0010\u0007J\u001c\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\n0\t2\u0006\u0010\u0004\u001a\u00020\u0005H\'J\u0016\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00050\t2\u0006\u0010\u0004\u001a\u00020\u0005H\'J$\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\n0\t2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u0005H\'J\u001e\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u0005H\u00a7@\u00a2\u0006\u0002\u0010\u0007J\u0016\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0003H\u00a7@\u00a2\u0006\u0002\u0010\u0012\u00a8\u0006\u0013"}, d2 = {"Lcom/yourname/qrattendance/data/dao/AttendanceDao;", "", "checkAlreadyMarked", "Lcom/yourname/qrattendance/data/entities/Attendance;", "sessionId", "", "studentId", "(IILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAttendanceBySession", "Landroidx/lifecycle/LiveData;", "", "getAttendanceCount", "getStudentAttendance", "classId", "getStudentAttendanceCount", "insertAttendance", "", "attendance", "(Lcom/yourname/qrattendance/data/entities/Attendance;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
@androidx.room.Dao()
public abstract interface AttendanceDao {
    
    @androidx.room.Insert(onConflict = 1)
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object insertAttendance(@org.jetbrains.annotations.NotNull()
    com.yourname.qrattendance.data.entities.Attendance attendance, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Query(value = "SELECT * FROM attendance WHERE sessionId = :sessionId")
    @org.jetbrains.annotations.NotNull()
    public abstract androidx.lifecycle.LiveData<java.util.List<com.yourname.qrattendance.data.entities.Attendance>> getAttendanceBySession(int sessionId);
    
    @androidx.room.Query(value = "SELECT * FROM attendance WHERE studentId = :studentId AND classId = :classId")
    @org.jetbrains.annotations.NotNull()
    public abstract androidx.lifecycle.LiveData<java.util.List<com.yourname.qrattendance.data.entities.Attendance>> getStudentAttendance(int studentId, int classId);
    
    @androidx.room.Query(value = "SELECT COUNT(*) FROM attendance WHERE sessionId = :sessionId")
    @org.jetbrains.annotations.NotNull()
    public abstract androidx.lifecycle.LiveData<java.lang.Integer> getAttendanceCount(int sessionId);
    
    @androidx.room.Query(value = "SELECT * FROM attendance WHERE sessionId = :sessionId AND studentId = :studentId LIMIT 1")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object checkAlreadyMarked(int sessionId, int studentId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.yourname.qrattendance.data.entities.Attendance> $completion);
    
    @androidx.room.Query(value = "SELECT COUNT(*) FROM attendance WHERE studentId = :studentId AND classId = :classId")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getStudentAttendanceCount(int studentId, int classId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Integer> $completion);
}