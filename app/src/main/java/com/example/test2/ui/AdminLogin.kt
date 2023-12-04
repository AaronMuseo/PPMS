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
import com.example.test2.ui.Database_Files.LocalDatabase
import com.example.test2.ui.ui.theme.Test2Theme



class AdminLogin : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Test2Theme {

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

                        val localDatabase = LocalDatabase(this)

                        val loginSuccessful = localDatabase.loginAdmin(username, password)

                        if (loginSuccessful) {
                            Toast.makeText(this, "Admin Login Successful", Toast.LENGTH_SHORT).show()
                            val intent = Intent(this, AdminHome::class.java)
                            startActivity(intent)
                        } else {
                            Toast.makeText(this, "Invalid Admin Credentials", Toast.LENGTH_SHORT).show()
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