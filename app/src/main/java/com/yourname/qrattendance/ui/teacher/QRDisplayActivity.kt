package com.yourname.qrattendance.ui.teacher

import android.os.Bundle
import android.os.CountDownTimer
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.button.MaterialButton
import com.yourname.qrattendance.QRAttendanceApp
import com.yourname.qrattendance.R
import com.yourname.qrattendance.utils.QRCodeUtils
import com.yourname.qrattendance.viewmodel.TeacherViewModel
import com.yourname.qrattendance.viewmodel.TeacherViewModelFactory

class QRDisplayActivity : AppCompatActivity() {

    private lateinit var teacherViewModel: TeacherViewModel
    private var countDownTimer: CountDownTimer? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_qr_display)

        val sessionId = intent.getIntExtra("session_id", -1)
        val qrData    = intent.getStringExtra("qr_data") ?: ""
        val classId   = intent.getIntExtra("class_id", -1)

        val repository = (application as QRAttendanceApp).repository
        teacherViewModel = ViewModelProvider(
            this, TeacherViewModelFactory(repository)
        )[TeacherViewModel::class.java]

        val ivQRCode          = findViewById<ImageView>(R.id.ivQRCode)
        val tvAttendanceCount = findViewById<TextView>(R.id.tvAttendanceCount)
        val tvTimer           = findViewById<TextView>(R.id.tvTimer)
        val btnEndSession     = findViewById<MaterialButton>(R.id.btnEndSession)
        val tvBack            = findViewById<TextView>(R.id.tvBack)

        // Generate and display QR bitmap from the stored session data
        if (qrData.isNotEmpty() && sessionId != -1) {
            val (bitmap, _) = QRCodeUtils.generateQRCode(sessionId, classId)
            ivQRCode.setImageBitmap(bitmap)
        }

        // Observe live attendance count
        if (sessionId != -1) {
            teacherViewModel.getAttendanceCount(sessionId).observe(this) { count ->
                tvAttendanceCount.text = count.toString()
            }
        }

        // Countdown timer — 5 minutes
        countDownTimer = object : CountDownTimer(300000, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                val minutes = millisUntilFinished / 60000
                val seconds = (millisUntilFinished % 60000) / 1000
                tvTimer.text = "Time remaining: %d:%02d".format(minutes, seconds)
            }

            override fun onFinish() {
                tvTimer.text = "Session expired!"
                Toast.makeText(
                    this@QRDisplayActivity,
                    "QR Code expired. End session.",
                    Toast.LENGTH_LONG
                ).show()
            }
        }.start()

        btnEndSession.setOnClickListener {
            countDownTimer?.cancel()
            teacherViewModel.endSession(sessionId)
            Toast.makeText(this, "Session ended successfully!", Toast.LENGTH_SHORT).show()
            finish()
        }

        tvBack.setOnClickListener {
            countDownTimer?.cancel()
            finish()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        countDownTimer?.cancel()
    }
}
