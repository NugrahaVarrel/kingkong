package com.example.pokeimages

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.pokeimages.data_class.LoginRequest
import com.example.pokeimages.network.CredentialApiClient
import com.example.pokeimages.ui.theme.PokeimagesTheme
import com.example.pokeimages.util.TokenManager
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class LoginActivity : AppCompatActivity() {
    private lateinit var progress: ProgressBar

    private lateinit var resText: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val etEmail = findViewById<EditText>(R.id.etEmail)
        val etPassword = findViewById<EditText>(R.id.etPassword)
        val btnLogin = findViewById<Button>(R.id.btnLogin)
        val btnAbout = findViewById<Button>(R.id.btnAbout)
        resText = findViewById(R.id.tvLoginResponse)
        progress = findViewById(R.id.progressBar)

        btnLogin.setOnClickListener {
            val email = etEmail.text.toString()
            val password = etPassword.text.toString()

            if (email.isEmpty() || password.isEmpty()) {
                resText.text = "All Fields Must be Filled!"
                return@setOnClickListener
            }


            LoginUser(email, password) { token ->
                Log.d("MainActivity", "Received token: $token")
                TokenManager.saveToken(this, token)

            }

            val intent = Intent(this, PokemonActivity::class.java)
            startActivity(intent)

        }

        btnAbout.setOnClickListener {
            val intent = Intent(this, AboutActivity::class.java)
            startActivity(intent)
        }
    }

    private fun LoginUser(email: String, password: String, onSuccess: (String) -> Unit) {
        progress.visibility = View.VISIBLE
        val reqLogin = LoginRequest(email = email, password = password)
        CoroutineScope(Dispatchers.IO).launch {
            try {
                val response = CredentialApiClient.api.loginUser(reqLogin)

                withContext(Dispatchers.Main) {
                    progress.visibility = View.GONE
                    if (response.error != null) {
                        resText.text = "Error: ${response.error}"
                        Toast.makeText(this@LoginActivity, "Error: ${response.error}", Toast.LENGTH_LONG).show()
                    } else {
                        val token = response.token ?: ""
                        resText.text = "Token: $token"
                        onSuccess(token)
                    }
                }
            } catch (e: Exception) {
                withContext(Dispatchers.Main) {
                    progress.visibility = View.GONE
                    Toast.makeText(this@LoginActivity, "Error: ${e.message}", Toast.LENGTH_LONG).show()
                }
            }
        }
    }

}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    PokeimagesTheme {
        Greeting("Android")
    }
}