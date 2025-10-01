package com.example.taskmanager.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.taskmanager.R
import com.example.taskmanager.entity.Task

class TaskAdapter(
    private val tasks: MutableList<Task>,
//    private val onTaskDone: (Task)->Unit,
    private val onItemClick : (Task) -> Unit
) : RecyclerView.Adapter<TaskAdapter.VH>() {
    class VH(v: View) : RecyclerView.ViewHolder(v){
        val tvTaskTile: TextView = v.findViewById(R.id.tvTitle)
        val tvPriority : TextView = v.findViewById(R.id.tvPriority)
        val tvCreatedAt : TextView = v.findViewById(R.id.tvCreatedAt)

        val tvStatus : TextView = v.findViewById(R.id.tvStatus)

//        val doneBtn : Button = v.findViewById(R.id.doneBtn)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_task, parent, false)
        return VH(view)
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        val task =tasks[position]
        holder.tvTaskTile.text = task.taskTitle
        holder.tvPriority.text = when (task.taskPriority) {
            1 -> "LOW"
            2 -> "MEDIUM"
            3 -> "HIGH"
            else -> "UNKNOWN"
        }
        holder.tvStatus.text = when(task.done){
            true -> "DONE"
            else -> "IN_PROGRESS"
        }
        holder.tvCreatedAt.text = task.createdAt.toString()


        holder.itemView.setOnClickListener {
            holder.itemView.setOnClickListener {
                onItemClick(task)
            }
        }
    }

    override fun getItemCount(): Int = tasks.size

    fun setData(newItems: List<Task>) {
        tasks.clear()
        tasks.addAll(newItems)
        notifyDataSetChanged()
    }

}