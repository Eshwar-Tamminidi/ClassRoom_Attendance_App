package com.yourname.qrattendance.data.repository;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u000b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u00a2\u0006\u0002\u0010\nJ \u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000eH\u0086@\u00a2\u0006\u0002\u0010\u0010J\u0016\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0086@\u00a2\u0006\u0002\u0010\u0015J\u0016\u0010\u0016\u001a\u00020\u00122\u0006\u0010\u0017\u001a\u00020\u000eH\u0086@\u00a2\u0006\u0002\u0010\u0018J\u001a\u0010\u0019\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u001b0\u001a2\u0006\u0010\u0017\u001a\u00020\u000eJ\u0014\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u000e0\u001a2\u0006\u0010\u0017\u001a\u00020\u000eJ\u0018\u0010\u001d\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u001e\u001a\u00020\u001fH\u0086@\u00a2\u0006\u0002\u0010 J\u0018\u0010!\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0017\u001a\u00020\u000eH\u0086@\u00a2\u0006\u0002\u0010\u0018J\u001a\u0010\"\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\u001b0\u001a2\u0006\u0010\u0017\u001a\u00020\u000eJ\u0018\u0010#\u001a\u0004\u0018\u00010$2\u0006\u0010\u0017\u001a\u00020\u000eH\u0086@\u00a2\u0006\u0002\u0010\u0018J\u001a\u0010%\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020$0\u001b0\u001a2\u0006\u0010\u0017\u001a\u00020\u000eJ\"\u0010&\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u001b0\u001a2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\'\u001a\u00020\u000eJ\u0018\u0010(\u001a\u0004\u0018\u00010)2\u0006\u0010*\u001a\u00020\u001fH\u0086@\u00a2\u0006\u0002\u0010 J\u0018\u0010+\u001a\u0004\u0018\u00010)2\u0006\u0010,\u001a\u00020\u000eH\u0086@\u00a2\u0006\u0002\u0010\u0018J\u0016\u0010-\u001a\u00020\u00122\u0006\u0010.\u001a\u00020\fH\u0086@\u00a2\u0006\u0002\u0010/J\u0016\u00100\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0086@\u00a2\u0006\u0002\u0010\u0015J\u0016\u00101\u001a\u0002022\u0006\u00103\u001a\u00020$H\u0086@\u00a2\u0006\u0002\u00104J \u00105\u001a\u0004\u0018\u00010)2\u0006\u0010*\u001a\u00020\u001f2\u0006\u00106\u001a\u00020\u001fH\u0086@\u00a2\u0006\u0002\u00107J\u0016\u00108\u001a\u00020\u00122\u0006\u00109\u001a\u00020)H\u0086@\u00a2\u0006\u0002\u0010:J\u0016\u0010;\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0086@\u00a2\u0006\u0002\u0010\u0015J\u0016\u0010<\u001a\u00020\u00122\u0006\u00103\u001a\u00020$H\u0086@\u00a2\u0006\u0002\u00104R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006="}, d2 = {"Lcom/yourname/qrattendance/data/repository/AppRepository;", "", "userDao", "Lcom/yourname/qrattendance/data/dao/UserDao;", "classRoomDao", "Lcom/yourname/qrattendance/data/dao/ClassRoomDao;", "sessionDao", "Lcom/yourname/qrattendance/data/dao/SessionDao;", "attendanceDao", "Lcom/yourname/qrattendance/data/dao/AttendanceDao;", "(Lcom/yourname/qrattendance/data/dao/UserDao;Lcom/yourname/qrattendance/data/dao/ClassRoomDao;Lcom/yourname/qrattendance/data/dao/SessionDao;Lcom/yourname/qrattendance/data/dao/AttendanceDao;)V", "checkAlreadyMarked", "Lcom/yourname/qrattendance/data/entities/Attendance;", "sId", "", "stId", "(IILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteClass", "", "classRoom", "Lcom/yourname/qrattendance/data/entities/ClassRoom;", "(Lcom/yourname/qrattendance/data/entities/ClassRoom;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "endSession", "id", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAttendanceBySession", "Landroidx/lifecycle/LiveData;", "", "getAttendanceCount", "getClassByCode", "code", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getClassById", "getClassesByTeacher", "getSessionById", "Lcom/yourname/qrattendance/data/entities/Session;", "getSessionsByClass", "getStudentAttendance", "cId", "getUserByEmail", "Lcom/yourname/qrattendance/data/entities/User;", "email", "getUserById", "userId", "insertAttendance", "a", "(Lcom/yourname/qrattendance/data/entities/Attendance;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insertClass", "insertSession", "", "session", "(Lcom/yourname/qrattendance/data/entities/Session;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "login", "password", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "registerUser", "user", "(Lcom/yourname/qrattendance/data/entities/User;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateClass", "updateSession", "app_debug"})
public final class AppRepository {
    @org.jetbrains.annotations.NotNull()
    private final com.yourname.qrattendance.data.dao.UserDao userDao = null;
    @org.jetbrains.annotations.NotNull()
    private final com.yourname.qrattendance.data.dao.ClassRoomDao classRoomDao = null;
    @org.jetbrains.annotations.NotNull()
    private final com.yourname.qrattendance.data.dao.SessionDao sessionDao = null;
    @org.jetbrains.annotations.NotNull()
    private final com.yourname.qrattendance.data.dao.AttendanceDao attendanceDao = null;
    
    public AppRepository(@org.jetbrains.annotations.NotNull()
    com.yourname.qrattendance.data.dao.UserDao userDao, @org.jetbrains.annotations.NotNull()
    com.yourname.qrattendance.data.dao.ClassRoomDao classRoomDao, @org.jetbrains.annotations.NotNull()
    com.yourname.qrattendance.data.dao.SessionDao sessionDao, @org.jetbrains.annotations.NotNull()
    com.yourname.qrattendance.data.dao.AttendanceDao attendanceDao) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object registerUser(@org.jetbrains.annotations.NotNull()
    com.yourname.qrattendance.data.entities.User user, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object login(@org.jetbrains.annotations.NotNull()
    java.lang.String email, @org.jetbrains.annotations.NotNull()
    java.lang.String password, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.yourname.qrattendance.data.entities.User> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getUserByEmail(@org.jetbrains.annotations.NotNull()
    java.lang.String email, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.yourname.qrattendance.data.entities.User> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getUserById(int userId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.yourname.qrattendance.data.entities.User> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object insertClass(@org.jetbrains.annotations.NotNull()
    com.yourname.qrattendance.data.entities.ClassRoom classRoom, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object updateClass(@org.jetbrains.annotations.NotNull()
    com.yourname.qrattendance.data.entities.ClassRoom classRoom, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object deleteClass(@org.jetbrains.annotations.NotNull()
    com.yourname.qrattendance.data.entities.ClassRoom classRoom, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.util.List<com.yourname.qrattendance.data.entities.ClassRoom>> getClassesByTeacher(int id) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getClassByCode(@org.jetbrains.annotations.NotNull()
    java.lang.String code, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.yourname.qrattendance.data.entities.ClassRoom> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getClassById(int id, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.yourname.qrattendance.data.entities.ClassRoom> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object insertSession(@org.jetbrains.annotations.NotNull()
    com.yourname.qrattendance.data.entities.Session session, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Long> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object updateSession(@org.jetbrains.annotations.NotNull()
    com.yourname.qrattendance.data.entities.Session session, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.util.List<com.yourname.qrattendance.data.entities.Session>> getSessionsByClass(int id) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getSessionById(int id, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.yourname.qrattendance.data.entities.Session> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object endSession(int id, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object insertAttendance(@org.jetbrains.annotations.NotNull()
    com.yourname.qrattendance.data.entities.Attendance a, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.util.List<com.yourname.qrattendance.data.entities.Attendance>> getAttendanceBySession(int id) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.util.List<com.yourname.qrattendance.data.entities.Attendance>> getStudentAttendance(int sId, int cId) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.lang.Integer> getAttendanceCount(int id) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object checkAlreadyMarked(int sId, int stId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.yourname.qrattendance.data.entities.Attendance> $completion) {
        return null;
    }
}