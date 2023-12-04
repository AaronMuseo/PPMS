
package com.example.test2.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.example.test2.ui.ui.theme.Test2Theme
import android.widget.Button
import com.example.test2.R
import android.content.Intent
import com.example.test2.MainActivity


class Home : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        setContent {
            Test2Theme {

                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                        setContentView(R.layout.home_activity)


                    val usage1 = findViewById<Button>(R.id.usage1)
                    val request = findViewById<Button>(R.id.request)
                    val purchase = findViewById<Button>(R.id.purchase)

                    val logout = findViewById<Button>(R.id.logout)

                    logout.setOnClickListener(){

                        val sharedPreferences = getSharedPreferences("login_pref", MODE_PRIVATE)
                        val editor = sharedPreferences.edit()
                        editor.putBoolean("isLoggedIn", false)
                        editor.apply()


                        val intent = Intent(this, MainActivity::class.java)
                        startActivity(intent)


                    }

                    purchase.setOnClickListener(){

                                val intent = Intent(this, Purchase::class.java)
                                startActivity(intent)
                    }

                    usage1.setOnClickListener(){

                                val intent = Intent(this, Usage::class.java)
                                startActivity(intent)
                    }

                    request.setOnClickListener(){

                                val intent = Intent(this, Request::class.java)
                                startActivity(intent)
                    }


                }
            }
        }
    }
}


