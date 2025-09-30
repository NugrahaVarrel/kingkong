package com.example.taskmanager

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import androidx.activity.ComponentActivity
import androidx.activity.enableEdgeToEdge
import com.example.taskmanager.model.Task

class FormActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContentView(R.layout.activity_form)

        val nameInput = findViewById<EditText>(R.id.nameInput)
        val titleInput = findViewById<EditText>(R.id.titleInput)
        val actionButton = findViewById<Button>(R.id.actionButton)
        val resultText = findViewById<TextView>(R.id.resultText)
        val priorityGroup = findViewById<RadioGroup>(R.id.priorityGroup)



        actionButton.setOnClickListener {

            val selectedId = priorityGroup.checkedRadioButtonId.toString()
            val selectedRadioButton = findViewById<RadioButton>(selectedId.toInt())

            val name = nameInput.text.toString().trim().uppercase()
            val title = titleInput.text.toString().trim().uppercase()
            val priority = selectedRadioButton.text.toString().uppercase()
            val defaultStatus = "IN_PROGRESS".uppercase()

            if (name.isEmpty() || title.isEmpty() || priority.isEmpty()){
                resultText.text = "Please fill out all fields!"
                return@setOnClickListener
            }


            if (selectedId == "-1"){
                resultText.text = "Choose your Priority!"
                return@setOnClickListener
            }


            val intent = Intent(this, MainActivity::class.java).apply {
                putExtra("NAME", name)
                putExtra("TITLE_TASK", title)
                putExtra("PRIORITY", priority)
                putExtra("STATUS", defaultStatus)
            }

            startActivity(intent)
            finish()
        }
    }
}
