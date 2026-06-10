package com.yourname.qrattendance.viewmodel;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0003\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u001e\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\u0018J\u000e\u0010\u0019\u001a\u00020\u00142\u0006\u0010\u001a\u001a\u00020\u001bJ\u000e\u0010\u001c\u001a\u00020\u00142\u0006\u0010\u001d\u001a\u00020\u0018J\u0014\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00180\f2\u0006\u0010\u001d\u001a\u00020\u0018J\u001a\u0010\u001f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001b0 0\f2\u0006\u0010\u0017\u001a\u00020\u0018J\u000e\u0010!\u001a\u00020\u00142\u0006\u0010\"\u001a\u00020\u0018R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00070\f\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0019\u0010\u000f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000eR\u0017\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00070\f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000e\u00a8\u0006#"}, d2 = {"Lcom/yourname/qrattendance/viewmodel/TeacherViewModel;", "Landroidx/lifecycle/ViewModel;", "repository", "Lcom/yourname/qrattendance/data/repository/AppRepository;", "(Lcom/yourname/qrattendance/data/repository/AppRepository;)V", "_errorMessage", "Landroidx/lifecycle/MutableLiveData;", "", "_sessionCreated", "Lcom/yourname/qrattendance/data/entities/Session;", "_successMessage", "errorMessage", "Landroidx/lifecycle/LiveData;", "getErrorMessage", "()Landroidx/lifecycle/LiveData;", "sessionCreated", "getSessionCreated", "successMessage", "getSuccessMessage", "createClass", "", "name", "subject", "teacherId", "", "deleteClass", "classRoom", "Lcom/yourname/qrattendance/data/entities/ClassRoom;", "endSession", "sessionId", "getAttendanceCount", "getClassesByTeacher", "", "startSession", "classId", "app_debug"})
public final class TeacherViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull()
    private final com.yourname.qrattendance.data.repository.AppRepository repository = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<com.yourname.qrattendance.data.entities.Session> _sessionCreated = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<com.yourname.qrattendance.data.entities.Session> sessionCreated = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<java.lang.String> _errorMessage = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<java.lang.String> errorMessage = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<java.lang.String> _successMessage = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<java.lang.String> successMessage = null;
    
    public TeacherViewModel(@org.jetbrains.annotations.NotNull()
    com.yourname.qrattendance.data.repository.AppRepository repository) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<com.yourname.qrattendance.data.entities.Session> getSessionCreated() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.lang.String> getErrorMessage() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.lang.String> getSuccessMessage() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.util.List<com.yourname.qrattendance.data.entities.ClassRoom>> getClassesByTeacher(int teacherId) {
        return null;
    }
    
    public final void createClass(@org.jetbrains.annotations.NotNull()
    java.lang.String name, @org.jetbrains.annotations.NotNull()
    java.lang.String subject, int teacherId) {
    }
    
    public final void deleteClass(@org.jetbrains.annotations.NotNull()
    com.yourname.qrattendance.data.entities.ClassRoom classRoom) {
    }
    
    public final void startSession(int classId) {
    }
    
    public final void endSession(int sessionId) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.lang.Integer> getAttendanceCount(int sessionId) {
        return null;
    }
}