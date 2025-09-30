package com.example.photonotes

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.appbar.MaterialToolbar
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {

    private lateinit var etTitle: EditText
    private lateinit var btnAddPhoto: Button
    private lateinit var toolbarMain: MaterialToolbar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        etTitle = findViewById(R.id.etTitle)
        btnAddPhoto = findViewById(R.id.btnAddPhoto)
        toolbarMain = findViewById(R.id.toolbarMain)

        // Set judul toolbar
        toolbarMain.title = getString(R.string.app_name)

        btnAddPhoto.setOnClickListener {
            val title = etTitle.text.toString().ifBlank { "Catatan Tanpa Judul" }
            val intent = Intent(this, PhotoPickerActivity::class.java)
            intent.putExtra("note_title", title)
            startActivity(intent)
        }
    }
}
