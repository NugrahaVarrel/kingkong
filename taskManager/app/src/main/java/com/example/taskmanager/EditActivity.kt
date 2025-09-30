package com.example.taskmanager

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.taskmanager.model.Task

class EditActivity : AppCompatActivity() {
    private lateinit var statusRadioGroup: RadioGroup
    private lateinit var saveButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit)

        val taskId = intent.getIntExtra("taskId", -1)
        val taskName = intent.getStringExtra("taskName")
        val taskStatus = intent.getStringExtra("taskStatus")

        statusRadioGroup = findViewById(R.id.statusRadioGroup)
        saveButton = findViewById(R.id.saveButton)

        // Set current status
        if (taskStatus == "DONE") {
            findViewById<RadioButton>(R.id.radioDone).isChecked = true
        } else {
            findViewById<RadioButton>(R.id.radioInProgress).isChecked = true
        }

        saveButton.setOnClickListener {
            val selectedStatusId = statusRadioGroup.checkedRadioButtonId
            val selectedStatus = findViewById<RadioButton>(selectedStatusId).text.toString()
            val resultIntent = Intent().apply {
                putExtra("updatedId", taskId)
                putExtra("updatedName", taskName)
                putExtra("updatedStatus", selectedStatus)
            }
            setResult(RESULT_OK, resultIntent)

            Toast.makeText(this, "Status updated to $selectedStatus", Toast.LENGTH_SHORT).show()
            finish()
        }
    }
}