package com.example.test2.ui

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.example.test2.MainActivity
import com.example.test2.R
import com.example.test2.ui.ui.theme.Test2Theme



class AdminLogin : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Test2Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {

                    setContentView(R.layout.admin_login_activity)

                    val usr = findViewById<EditText>(R.id.admin_username1)
                    val pwd = findViewById<EditText>(R.id.admin_password1)

                    val login = findViewById<Button>(R.id.admin_login_button)
                    val back = findViewById<Button>(R.id.back)

                    login.setOnClickListener() {
                        val username = usr.text.toString()
                        val password = pwd.text.toString()

                        // Add your validation logic here
                        if (username == "Admin" && password == "admin") {

                            val intent = Intent(this, Admin_Create::class.java)
                            startActivity(intent)

                        } else {
                            Toast.makeText(this, "Invalid credentials", Toast.LENGTH_SHORT).show()
                            // Invalid credentials, show a message or handle it as needed
                        }

                    }

                    back.setOnClickListener(){
                        val intent = Intent(this, MainActivity::class.java)
                        startActivity(intent)
                    }


                }
            }
        }
    }
}