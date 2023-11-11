package com.example.test2.ui

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.example.test2.R
import com.example.test2.ui.ui.theme.Test2Theme

class Usage : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Test2Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    setContentView(R.layout.usage_activity)

                    val home = findViewById<Button>(R.id.Home)
                    val request = findViewById<Button>(R.id.Request)
                    val purchase = findViewById<Button>(R.id.Purchase)


                    home.setOnClickListener(){
                        intent = Intent(this, Home::class.java)
                        startActivity(intent)
                    }

                    purchase.setOnClickListener(){
                        intent = Intent(this, Purchase::class.java)
                        startActivity(intent)
                    }

                    request.setOnClickListener(){
                        intent = Intent(this, Request::class.java)
                        startActivity(intent)
                    }
                }
            }
        }
    }
}

