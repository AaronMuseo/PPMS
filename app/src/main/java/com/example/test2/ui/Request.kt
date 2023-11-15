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
import com.example.test2.ui.theme.Test2Theme

class Request : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Test2Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    setContentView(R.layout.request_activity)

                    val home = findViewById<Button>(R.id.home_r)
                    val Purchase = findViewById<Button>(R.id.purchase_r)
                    val Usage = findViewById<Button>(R.id.usage_r)
                    val request = findViewById<Button>(R.id.request_button)

                    home.setOnClickListener(){
                        intent = Intent(this, Home::class.java)
                        startActivity(intent)
                    }

                    Purchase.setOnClickListener(){
                        intent = Intent(this, Purchase::class.java)
                        startActivity(intent)
                    }

                    Usage.setOnClickListener(){
                        intent = Intent(this, Usage::class.java)
                        startActivity(intent)
                    }

                    request.setOnClickListener() {

                    //make a function to request using the customer ID and password for that customer id and send it to the database so that if they match a Meter is assigned to the user and the meter has the customer id entered assigned to it and the meter is added to the database

                    }
                }
            }
        }
    }
}
