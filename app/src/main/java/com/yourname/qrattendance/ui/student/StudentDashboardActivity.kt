package com.yourname.qrattendance.ui.student

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText
import com.journeyapps.barcodescanner.ScanContract
import com.journeyapps.barcodescanner.ScanIntentResult
import com.journeyapps.barcodescanner.ScanOptions
import com.yourname.qrattendance.MainActivity
import com.yourname.qrattendance.QRAttendanceApp
import com.yourname.qrattendance.R
import com.yourname.qrattendance.viewmodel.StudentViewModel
import com.yourname.qrattendance.viewmodel.StudentViewModelFactory

class StudentDashboardActivity : AppCompatActivity() {

    private lateinit var studentViewModel: StudentViewModel
    private lateinit var sharedPreferences: SharedPreferences
    private lateinit var tvScanResult: TextView
    private var studentId = -1

    // QR Scanner launcher
    private val scanLauncher = registerForActivityResult(ScanContract()) { result: ScanIntentResult ->
        if (result.contents != null) {
            tvScanResult.text = "Processing..."
            studentViewModel.markAttendance(result.contents, studentId)
        } else {
            tvScanResult.text = "Scan cancelled."
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_student_dashboard)

        sharedPreferences = getSharedPreferences("QRAttendancePrefs", MODE_PRIVATE)
        studentId = sharedPreferences.getInt("user_id", -1)
        val studentName = sharedPreferences.getString("user_name", "Student")

        val repository = (application as QRAttendanceApp).repository
        studentViewModel = ViewModelProvider(
            this, StudentViewModelFactory(repository)
        )[StudentViewModel::class.java]

        tvScanResult = findViewById(R.id.tvScanResult)

        findViewById<TextView>(R.id.tvWelcome).text = "Welcome, $studentName!"

        findViewById<MaterialButton>(R.id.btnScanQR).setOnClickListener {
            launchQRScanner()
        }

        findViewById<MaterialButton>(R.id.btnEnrollClass).setOnClickListener {
            showEnrollDialog()
        }

        findViewById<TextView>(R.id.tvLogout).setOnClickListener {
            sharedPreferences.edit().clear().apply()
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }

        studentViewModel.attendanceResult.observe(this) { message ->
            tvScanResult.setTextColor(getColor(R.color.accent_green))
            tvScanResult.text = message
            Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
        }

        studentViewModel.errorMessage.observe(this) { message ->
            tvScanResult.setTextColor(getColor(R.color.accent_red))
            tvScanResult.text = message
            Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
        }
    }

    private fun launchQRScanner() {
        val options = ScanOptions().apply {
            setPrompt("Point camera at teacher's QR code")
            setBeepEnabled(true)
            setOrientationLocked(false)
            setBarcodeImageEnabled(false)
        }
        scanLauncher.launch(options)
    }

    private fun showEnrollDialog() {
        val dialogView = layoutInflater.inflate(R.layout.dialog_enroll_class, null)
        AlertDialog.Builder(this)
            .setTitle("Join a Class")
            .setView(dialogView)
            .setPositiveButton("Join") { _, _ ->
                val code = dialogView
                    .findViewById<TextInputEditText>(R.id.etClassCode)
                    .text.toString().trim()
                studentViewModel.enrollInClass(code, studentId)
            }
            .setNegativeButton("Cancel", null)
            .show()
    }
}
