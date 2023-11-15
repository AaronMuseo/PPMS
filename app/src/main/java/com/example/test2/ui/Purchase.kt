package com.example.test2.ui

import android.content.Intent
import android.os.Bundle
import android.widget.Button

import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import com.example.test2.ui.theme.Test2Theme
import android.content.Context
import com.example.test2.R

class Purchase: ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Test2Theme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colorScheme.background) {

                setContentView(R.layout.purchase_activity)

                    val sharedPreferences = getSharedPreferences("login_pref", Context.MODE_PRIVATE)

                    val isLoggedIn = sharedPreferences.getBoolean("isLoggedIn", false)

                    val request = findViewById<Button>(R.id.request1)
                    val home = findViewById<Button>(R.id.home1)
                    val usage = findViewById<Button>(R.id.usage1)

                    home.setOnClickListener(){

                        intent = Intent(this, Home::class.java)
                        startActivity(intent)

                    }

                    usage.setOnClickListener(){

                        intent = Intent(this, Usage::class.java)
                        startActivity(intent)

                    }

                    request.setOnClickListener(){

                        intent = Intent(this, Request::class.java)
                        startActivity(intent)

                    }


                    //make a function that allows purchase of tokens and updates the tokens in the database in all the tabels invlolved


                }
            }
        }
    }
}