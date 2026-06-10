package com.yourname.qrattendance.viewmodel

import androidx.lifecycle.*
import com.yourname.qrattendance.data.entities.*
import com.yourname.qrattendance.data.repository.AppRepository
import com.yourname.qrattendance.utils.QRCodeUtils
import kotlinx.coroutines.launch
import java.util.UUID

class TeacherViewModel(private val repository: AppRepository) : ViewModel() {

    private val _sessionCreated = MutableLiveData<Session?>()
    val sessionCreated: LiveData<Session?> = _sessionCreated

    private val _errorMessage = MutableLiveData<String>()
    val errorMessage: LiveData<String> = _errorMessage

    private val _successMessage = MutableLiveData<String>()
    val successMessage: LiveData<String> = _successMessage

    fun getClassesByTeacher(teacherId: Int) = repository.getClassesByTeacher(teacherId)

    fun createClass(name: String, subject: String, teacherId: Int) {
        // FIX: replaced ││ (Unicode) with valid Kotlin || operator
        if (name.isBlank() || subject.isBlank()) {
            _errorMessage.value = "Please fill in all fields"
            return
        }
        viewModelScope.launch {
            val code = UUID.randomUUID().toString().take(6).uppercase()
            repository.insertClass(
                ClassRoom(name = name, subject = subject, teacherId = teacherId, classCode = code)
            )
            _successMessage.value = "Class created! Code: $code"
        }
    }

    fun deleteClass(classRoom: ClassRoom) {
        viewModelScope.launch {
            repository.deleteClass(classRoom)
            _successMessage.value = "Class deleted"
        }
    }

    fun startSession(classId: Int) {
        viewModelScope.launch {
            val placeholder = Session(
                classId = classId,
                qrData = "",
                generatedAt = System.currentTimeMillis(),
                expiresAt = System.currentTimeMillis() + 300000
            )
            val sessionId = repository.insertSession(placeholder).toInt()
            val (_, qrData) = QRCodeUtils.generateQRCode(sessionId, classId)
            val updated = placeholder.copy(id = sessionId, qrData = qrData)
            repository.updateSession(updated)
            _sessionCreated.value = updated
        }
    }

    fun endSession(sessionId: Int) {
        viewModelScope.launch {
            repository.endSession(sessionId)
            _successMessage.value = "Session ended"
        }
    }

    fun getAttendanceCount(sessionId: Int) = repository.getAttendanceCount(sessionId)
}

class TeacherViewModelFactory(private val repository: AppRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(TeacherViewModel::class.java))
            @Suppress("UNCHECKED_CAST")
            return TeacherViewModel(repository) as T
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
