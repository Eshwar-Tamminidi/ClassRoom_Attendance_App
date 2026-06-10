package com.yourname.qrattendance.viewmodel

import androidx.lifecycle.*
import com.yourname.qrattendance.data.entities.User
import com.yourname.qrattendance.data.repository.AppRepository
import kotlinx.coroutines.launch

class AuthViewModel(private val repository: AppRepository) : ViewModel() {

    private val _loginResult = MutableLiveData<User?>()
    val loginResult: LiveData<User?> = _loginResult

    private val _registerResult = MutableLiveData<Boolean>()
    val registerResult: LiveData<Boolean> = _registerResult

    private val _errorMessage = MutableLiveData<String>()
    val errorMessage: LiveData<String> = _errorMessage

    fun login(email: String, password: String) {
        // FIX: replaced ││ (Unicode) with valid Kotlin || operator
        if (email.isBlank() || password.isBlank()) {
            _errorMessage.value = "Please fill in all fields"
            return
        }
        viewModelScope.launch {
            val user = repository.login(email, password)
            if (user != null) _loginResult.value = user
            else _errorMessage.value = "Invalid email or password"
        }
    }

    fun register(name: String, email: String, password: String, role: String) {
        // FIX: replaced ││ (Unicode) with valid Kotlin || operator
        if (name.isBlank() || email.isBlank() || password.isBlank()) {
            _errorMessage.value = "Please fill in all fields"
            return
        }
        if (password.length < 6) {
            _errorMessage.value = "Password must be at least 6 characters"
            return
        }
        viewModelScope.launch {
            if (repository.getUserByEmail(email) != null) {
                _errorMessage.value = "Email already registered"
                return@launch
            }
            repository.registerUser(User(name = name, email = email, password = password, role = role))
            _registerResult.value = true
        }
    }
}

class AuthViewModelFactory(private val repository: AppRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(AuthViewModel::class.java))
            @Suppress("UNCHECKED_CAST")
            return AuthViewModel(repository) as T
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
