package com.yourname.qrattendance.ui.auth

import android.content.Intent
import android.os.Bundle
import android.widget.RadioGroup
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText
import com.yourname.qrattendance.MainActivity
import com.yourname.qrattendance.QRAttendanceApp
import com.yourname.qrattendance.R
import com.yourname.qrattendance.viewmodel.AuthViewModel
import com.yourname.qrattendance.viewmodel.AuthViewModelFactory

class RegisterActivity : AppCompatActivity() {

    private lateinit var authViewModel: AuthViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        val repository = (application as QRAttendanceApp).repository
        authViewModel = ViewModelProvider(
            this, AuthViewModelFactory(repository)
        )[AuthViewModel::class.java]

        val etName     = findViewById<TextInputEditText>(R.id.etName)
        val etEmail    = findViewById<TextInputEditText>(R.id.etEmail)
        val etPassword = findViewById<TextInputEditText>(R.id.etPassword)
        val rgRole     = findViewById<RadioGroup>(R.id.rgRole)
        val btnRegister = findViewById<MaterialButton>(R.id.btnRegister)
        val tvBack     = findViewById<TextView>(R.id.tvBack)
        val tvLogin    = findViewById<TextView>(R.id.tvLogin)

        btnRegister.setOnClickListener {
            val name     = etName.text.toString().trim()
            val email    = etEmail.text.toString().trim()
            val password = etPassword.text.toString().trim()
            val role     = if (rgRole.checkedRadioButtonId == R.id.rbTeacher) "teacher" else "student"
            authViewModel.register(name, email, password, role)
        }

        tvBack.setOnClickListener { finish() }

        tvLogin.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }

        authViewModel.registerResult.observe(this) { success ->
            if (success) {
                Toast.makeText(this, "Account created! Please login.", Toast.LENGTH_SHORT).show()
                startActivity(Intent(this, MainActivity::class.java))
                finish()
            }
        }

        authViewModel.errorMessage.observe(this) { message ->
            Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
        }
    }
}
