package com.example.taskmanager

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.taskmanager.model.Task
import org.w3c.dom.Text

class TaskAdapter(
    private val tasks: List<Task>,
    private val onItemClick: (Task) -> Unit
) : RecyclerView.Adapter<TaskAdapter.TaskViewHolder>()  {

    class TaskViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val taskName = itemView.findViewById<TextView>(R.id.taskName)
        val taskTitle = itemView.findViewById<TextView>(R.id.taskTitle)
        val taskPriority = itemView.findViewById<TextView>(R.id.taskPriority)
        val taskStatus = itemView.findViewById<TextView>(R.id.taskStatus)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.activity_data, parent, false)
        return TaskViewHolder(view)
    }

    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
        val task = tasks[position]
        holder.taskName.text = task.name
        holder.taskTitle.text = task.taskTitle
        holder.taskPriority.text = task.priority
        holder.taskStatus.text = task.status

        holder.itemView.setOnClickListener {
            onItemClick(task)
        }
    }

    override fun getItemCount(): Int = tasks.size
}