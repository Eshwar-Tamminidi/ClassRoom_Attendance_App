package com.yourname.qrattendance.ui.teacher

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText
import com.yourname.qrattendance.MainActivity
import com.yourname.qrattendance.QRAttendanceApp
import com.yourname.qrattendance.R
import com.yourname.qrattendance.viewmodel.TeacherViewModel
import com.yourname.qrattendance.viewmodel.TeacherViewModelFactory

class TeacherDashboardActivity : AppCompatActivity() {

    private lateinit var teacherViewModel: TeacherViewModel
    private lateinit var classAdapter: ClassAdapter
    private lateinit var sharedPreferences: SharedPreferences
    private var teacherId = -1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_teacher_dashboard)

        sharedPreferences = getSharedPreferences("QRAttendancePrefs", MODE_PRIVATE)
        teacherId = sharedPreferences.getInt("user_id", -1)
        val teacherName = sharedPreferences.getString("user_name", "Teacher")

        val repository = (application as QRAttendanceApp).repository
        teacherViewModel = ViewModelProvider(
            this, TeacherViewModelFactory(repository)
        )[TeacherViewModel::class.java]

        findViewById<TextView>(R.id.tvWelcome).text = "Welcome, $teacherName!"

        classAdapter = ClassAdapter(
            onStartSession = { classRoom ->
                teacherViewModel.startSession(classRoom.id)
            },
            onDelete = { classRoom ->
                AlertDialog.Builder(this)
                    .setTitle("Delete Class")
                    .setMessage("Are you sure you want to delete ${classRoom.name}?")
                    .setPositiveButton("Delete") { _, _ ->
                        teacherViewModel.deleteClass(classRoom)
                    }
                    .setNegativeButton("Cancel", null)
                    .show()
            }
        )

        val rvClasses = findViewById<RecyclerView>(R.id.rvClasses)
        rvClasses.layoutManager = LinearLayoutManager(this)
        rvClasses.adapter = classAdapter

        teacherViewModel.getClassesByTeacher(teacherId).observe(this) { classes ->
            classAdapter.updateClasses(classes)
        }

        teacherViewModel.sessionCreated.observe(this) { session ->
            session?.let {
                val intent = Intent(this, QRDisplayActivity::class.java)
                intent.putExtra("session_id", it.id)
                intent.putExtra("qr_data", it.qrData)
                intent.putExtra("class_id", it.classId)
                startActivity(intent)
            }
        }

        teacherViewModel.successMessage.observe(this) { msg ->
            Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
        }

        teacherViewModel.errorMessage.observe(this) { msg ->
            Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
        }

        findViewById<MaterialButton>(R.id.btnCreateClass).setOnClickListener {
            showCreateClassDialog()
        }

        findViewById<TextView>(R.id.tvLogout).setOnClickListener {
            sharedPreferences.edit().clear().apply()
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }
    }

    private fun showCreateClassDialog() {
        val dialogView = layoutInflater.inflate(R.layout.dialog_create_class, null)
        AlertDialog.Builder(this)
            .setTitle("Create New Class")
            .setView(dialogView)
            .setPositiveButton("Create") { _, _ ->
                val name    = dialogView.findViewById<TextInputEditText>(R.id.etClassName).text.toString().trim()
                val subject = dialogView.findViewById<TextInputEditText>(R.id.etSubject).text.toString().trim()
                teacherViewModel.createClass(name, subject, teacherId)
            }
            .setNegativeButton("Cancel", null)
            .show()
    }
}
