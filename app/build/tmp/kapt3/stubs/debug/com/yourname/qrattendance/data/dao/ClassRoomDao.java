package com.yourname.qrattendance.data.dao;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00a2\u0006\u0002\u0010\u0006J\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00052\u0006\u0010\b\u001a\u00020\tH\u00a7@\u00a2\u0006\u0002\u0010\nJ\u0018\u0010\u000b\u001a\u0004\u0018\u00010\u00052\u0006\u0010\f\u001a\u00020\rH\u00a7@\u00a2\u0006\u0002\u0010\u000eJ\u001c\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00110\u00102\u0006\u0010\u0012\u001a\u00020\rH\'J\u0016\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00a2\u0006\u0002\u0010\u0006J\u0016\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00a2\u0006\u0002\u0010\u0006\u00a8\u0006\u0015"}, d2 = {"Lcom/yourname/qrattendance/data/dao/ClassRoomDao;", "", "deleteClass", "", "classRoom", "Lcom/yourname/qrattendance/data/entities/ClassRoom;", "(Lcom/yourname/qrattendance/data/entities/ClassRoom;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getClassByCode", "code", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getClassById", "classId", "", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getClassesByTeacher", "Landroidx/lifecycle/LiveData;", "", "teacherId", "insertClass", "updateClass", "app_debug"})
@androidx.room.Dao()
public abstract interface ClassRoomDao {
    
    @androidx.room.Insert(onConflict = 1)
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object insertClass(@org.jetbrains.annotations.NotNull()
    com.yourname.qrattendance.data.entities.ClassRoom classRoom, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Update()
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object updateClass(@org.jetbrains.annotations.NotNull()
    com.yourname.qrattendance.data.entities.ClassRoom classRoom, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Delete()
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object deleteClass(@org.jetbrains.annotations.NotNull()
    com.yourname.qrattendance.data.entities.ClassRoom classRoom, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Query(value = "SELECT * FROM classes WHERE teacherId = :teacherId")
    @org.jetbrains.annotations.NotNull()
    public abstract androidx.lifecycle.LiveData<java.util.List<com.yourname.qrattendance.data.entities.ClassRoom>> getClassesByTeacher(int teacherId);
    
    @androidx.room.Query(value = "SELECT * FROM classes WHERE classCode = :code LIMIT 1")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getClassByCode(@org.jetbrains.annotations.NotNull()
    java.lang.String code, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.yourname.qrattendance.data.entities.ClassRoom> $completion);
    
    @androidx.room.Query(value = "SELECT * FROM classes WHERE id = :classId LIMIT 1")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getClassById(int classId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.yourname.qrattendance.data.entities.ClassRoom> $completion);
}