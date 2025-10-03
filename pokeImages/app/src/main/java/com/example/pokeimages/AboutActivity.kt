package com.example.pokeimages

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.pokeimages.adapter.PokemonAdapter
import com.example.pokeimages.fragment.AboutFragment
import com.example.pokeimages.fragment.PokemonFragment
import com.example.pokeimages.network.PokeApiClient
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class AboutActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.about_page)

        supportFragmentManager.beginTransaction()
            .replace(R.id.aboutFragment, AboutFragment())
            .addToBackStack("about")
            .commit()

    }

//    private lateinit var tvConnectionStatus: TextView
//    private lateinit var btnCheck: Button
//    private lateinit var ivLogo: ImageView
//    private lateinit var tvAbout: TextView
//
//    private lateinit var progress : ProgressBar


//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()
//        setContentView(R.layout.about_page)
//
//        tvConnectionStatus = findViewById(R.id.tvConnectionStatus)
//        btnCheck = findViewById(R.id.btnCheckConnection)
//        ivLogo = findViewById(R.id.ivLogo)
//        tvAbout = findViewById(R.id.tvAbout)
//        progress = findViewById(R.id.progressBarStatus)
//
//
//        btnCheck.setOnClickListener {
//            loadStatus()
//        }
//    }
//
//    private fun loadStatus() {
//        progress.visibility = View.VISIBLE
//        tvConnectionStatus.text = "" // reset previous status
//
//        CoroutineScope(Dispatchers.IO).launch {
//            try {
//                val response = PokeApiClient.api.getStatusAPI(1)
//                val isAvailable = response.results.isNotEmpty()
//
//                withContext(Dispatchers.Main) {
//                    progress.visibility = View.GONE
//                    if (isAvailable) {
//                        tvConnectionStatus.text = "✅ Connection OK — ${response.results.size} results found"
//                    } else {
//                        tvConnectionStatus.text = "❌ No results returned from API"
//                    }
//                }
//            } catch (e: Exception) {
//                withContext(Dispatchers.Main) {
//                    progress.visibility = View.GONE
//                    tvConnectionStatus.text = "❌ Error: ${e.message}"
//                    Toast.makeText(this@AboutActivity, "Error: ${e.message}", Toast.LENGTH_LONG).show()
//                }
//            }
//        }
//    }
}