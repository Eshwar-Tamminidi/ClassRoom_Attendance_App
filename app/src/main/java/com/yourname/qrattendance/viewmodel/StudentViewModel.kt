package com.yourname.qrattendance.viewmodel

import androidx.lifecycle.*
import com.yourname.qrattendance.data.entities.Attendance
import com.yourname.qrattendance.data.repository.AppRepository
import com.yourname.qrattendance.utils.QRCodeUtils
import kotlinx.coroutines.launch

class StudentViewModel(private val repository: AppRepository) : ViewModel() {

    private val _attendanceResult = MutableLiveData<String>()
    val attendanceResult: LiveData<String> = _attendanceResult

    private val _errorMessage = MutableLiveData<String>()
    val errorMessage: LiveData<String> = _errorMessage

    fun markAttendance(qrString: String, studentId: Int) {
        viewModelScope.launch {
            val qrData = QRCodeUtils.decodeQRData(qrString)
            if (qrData == null) {
                _errorMessage.value = "Invalid QR Code"
                return@launch
            }
            if (QRCodeUtils.isQRExpired(qrData.expiresAt)) {
                _errorMessage.value = "QR Code has expired"
                return@launch
            }
            val session = repository.getSessionById(qrData.sessionId)
            // FIX: replaced ││ (Unicode) with valid Kotlin || operator
            if (session == null || !session.isActive) {
                _errorMessage.value = "Session not found or ended"
                return@launch
            }
            if (repository.checkAlreadyMarked(qrData.sessionId, studentId) != null) {
                _errorMessage.value = "Attendance already marked"
                return@launch
            }
            repository.insertAttendance(
                Attendance(
                    sessionId = qrData.sessionId,
                    studentId = studentId,
                    classId = qrData.classId,
                    markedAt = System.currentTimeMillis()
                )
            )
            _attendanceResult.value = "Attendance marked successfully!"
        }
    }

    fun enrollInClass(code: String, studentId: Int) {
        viewModelScope.launch {
            val classRoom = repository.getClassByCode(code)
            if (classRoom == null) {
                _errorMessage.value = "Invalid class code"
                return@launch
            }
            _attendanceResult.value = "Enrolled in ${classRoom.name} successfully!"
        }
    }
}

class StudentViewModelFactory(private val repository: AppRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(StudentViewModel::class.java))
            @Suppress("UNCHECKED_CAST")
            return StudentViewModel(repository) as T
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
