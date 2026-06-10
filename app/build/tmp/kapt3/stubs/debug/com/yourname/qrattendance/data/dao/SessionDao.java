package com.yourname.qrattendance.data.dao;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00a2\u0006\u0002\u0010\u0006J\u0018\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00a2\u0006\u0002\u0010\u0006J\u001c\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u000b0\n2\u0006\u0010\f\u001a\u00020\u0005H\'J\u0016\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\bH\u00a7@\u00a2\u0006\u0002\u0010\u0010J\u0016\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\bH\u00a7@\u00a2\u0006\u0002\u0010\u0010\u00a8\u0006\u0012"}, d2 = {"Lcom/yourname/qrattendance/data/dao/SessionDao;", "", "endSession", "", "sessionId", "", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getSessionById", "Lcom/yourname/qrattendance/data/entities/Session;", "getSessionsByClass", "Landroidx/lifecycle/LiveData;", "", "classId", "insertSession", "", "session", "(Lcom/yourname/qrattendance/data/entities/Session;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateSession", "app_debug"})
@androidx.room.Dao()
public abstract interface SessionDao {
    
    @androidx.room.Insert(onConflict = 1)
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object insertSession(@org.jetbrains.annotations.NotNull()
    com.yourname.qrattendance.data.entities.Session session, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Long> $completion);
    
    @androidx.room.Update()
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object updateSession(@org.jetbrains.annotations.NotNull()
    com.yourname.qrattendance.data.entities.Session session, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Query(value = "SELECT * FROM sessions WHERE classId = :classId ORDER BY generatedAt DESC")
    @org.jetbrains.annotations.NotNull()
    public abstract androidx.lifecycle.LiveData<java.util.List<com.yourname.qrattendance.data.entities.Session>> getSessionsByClass(int classId);
    
    @androidx.room.Query(value = "SELECT * FROM sessions WHERE id = :sessionId LIMIT 1")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getSessionById(int sessionId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.yourname.qrattendance.data.entities.Session> $completion);
    
    @androidx.room.Query(value = "UPDATE sessions SET isActive = 0 WHERE id = :sessionId")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object endSession(int sessionId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
}