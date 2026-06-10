package com.yourname.qrattendance.ui.teacher

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.button.MaterialButton
import com.yourname.qrattendance.R
import com.yourname.qrattendance.data.entities.ClassRoom

class ClassAdapter(
    private var classes: List<ClassRoom> = emptyList(),
    private val onStartSession: (ClassRoom) -> Unit,
    private val onDelete: (ClassRoom) -> Unit
) : RecyclerView.Adapter<ClassAdapter.ClassViewHolder>() {

    inner class ClassViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tvClassName: TextView       = view.findViewById(R.id.tvClassName)
        val tvSubject: TextView         = view.findViewById(R.id.tvSubject)
        val tvClassCode: TextView       = view.findViewById(R.id.tvClassCode)
        val btnStartSession: MaterialButton = view.findViewById(R.id.btnStartSession)
        val btnDelete: MaterialButton   = view.findViewById(R.id.btnDeleteClass)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ClassViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_class, parent, false)
        return ClassViewHolder(view)
    }

    override fun onBindViewHolder(holder: ClassViewHolder, position: Int) {
        val classRoom = classes[position]
        holder.tvClassName.text  = classRoom.name
        holder.tvSubject.text    = classRoom.subject
        holder.tvClassCode.text  = classRoom.classCode
        holder.btnStartSession.setOnClickListener { onStartSession(classRoom) }
        holder.btnDelete.setOnClickListener { onDelete(classRoom) }
    }

    override fun getItemCount() = classes.size

    fun updateClasses(newClasses: List<ClassRoom>) {
        classes = newClasses
        notifyDataSetChanged()
    }
}
