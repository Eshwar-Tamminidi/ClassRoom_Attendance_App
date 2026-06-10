package com.yourname.qrattendance

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText
import com.yourname.qrattendance.ui.auth.RegisterActivity
import com.yourname.qrattendance.ui.teacher.TeacherDashboardActivity
import com.yourname.qrattendance.ui.student.StudentDashboardActivity
import com.yourname.qrattendance.viewmodel.AuthViewModel
import com.yourname.qrattendance.viewmodel.AuthViewModelFactory

class MainActivity : AppCompatActivity() {

    private lateinit var authViewModel: AuthViewModel
    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        sharedPreferences = getSharedPreferences("QRAttendancePrefs", MODE_PRIVATE)

        // If already logged in, skip login screen
        val userId = sharedPreferences.getInt("user_id", -1)
        val userRole = sharedPreferences.getString("user_role", "")
        if (userId != -1 && !userRole.isNullOrEmpty()) {
            navigateToDashboard(userRole)
            return
        }

        setContentView(R.layout.activity_main)

        val repository = (application as QRAttendanceApp).repository
        authViewModel = ViewModelProvider(
            this, AuthViewModelFactory(repository)
        )[AuthViewModel::class.java]

        val etEmail = findViewById<TextInputEditText>(R.id.etEmail)
        val etPassword = findViewById<TextInputEditText>(R.id.etPassword)
        val btnLogin = findViewById<MaterialButton>(R.id.btnLogin)
        val tvRegister = findViewById<android.widget.TextView>(R.id.tvRegister)

        btnLogin.setOnClickListener {
            val email = etEmail.text.toString().trim()
            val password = etPassword.text.toString().trim()
            authViewModel.login(email, password)
        }

        tvRegister.setOnClickListener {
            startActivity(Intent(this, RegisterActivity::class.java))
        }

        authViewModel.loginResult.observe(this) { user ->
            user?.let {
                sharedPreferences.edit()
                    .putInt("user_id", it.id)
                    .putString("user_role", it.role)
                    .putString("user_name", it.name)
                    .apply()
                navigateToDashboard(it.role)
            }
        }

        authViewModel.errorMessage.observe(this) { message ->
            Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
        }
    }

    private fun navigateToDashboard(role: String) {
        val intent = if (role == "teacher") {
            Intent(this, TeacherDashboardActivity::class.java)
        } else {
            Intent(this, StudentDashboardActivity::class.java)
        }
        startActivity(intent)
        finish()
    }
}
