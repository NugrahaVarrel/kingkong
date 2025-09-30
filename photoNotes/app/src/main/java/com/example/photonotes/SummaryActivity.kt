package com.example.photonotes

import android.os.Bundle
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class SummaryActivity : AppCompatActivity() {

    private lateinit var tvSummaryTitle: TextView
    private lateinit var tvSummaryPhoto: TextView
    private lateinit var btnBack: ImageButton
    private lateinit var ivSummaryPhoto: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_summary)

        tvSummaryTitle = findViewById(R.id.tvSummaryTitle)
        tvSummaryPhoto = findViewById(R.id.tvSummaryPhoto)
        btnBack = findViewById(R.id.btnBack)
        ivSummaryPhoto = findViewById(R.id.ivSummaryPhoto)

        btnBack.setOnClickListener { finish() }

        val title = intent.getStringExtra("note_title")
        val photoResId = intent.getIntExtra("photo_res_id", R.mipmap.ic_launcher_round)

        tvSummaryTitle.text = "Judul: $title"
        tvSummaryPhoto.text = "Foto: dummy_photo"

        ivSummaryPhoto.setImageResource(photoResId)
    }
}
