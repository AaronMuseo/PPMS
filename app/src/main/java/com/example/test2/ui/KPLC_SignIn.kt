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

class KPLC_SignIn : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Test2Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {

                    setContentView(R.layout.kplc_signin_activity)

                    val usr = findViewById<EditText>(R.id.kplc_username)
                    val pwd = findViewById<EditText>(R.id.kplc_password)
                    val lgn = findViewById<Button>(R.id.kplc_login)
                    val back = findViewById<Button>(R.id.back_kplc)

                    lgn.setOnClickListener(){

                        val username = usr.text.toString()
                        val password = pwd.text.toString()

                        val localDatabase = LocalDatabase(this) // Create an instance of your Java LocalDatabase class

                        val loginSuccessful = localDatabase.loginKPLC(username, password)

                        if (loginSuccessful) {
                            Toast.makeText(this, "Login Successful", Toast.LENGTH_SHORT).show()
                            val intent = Intent(this, KPLC_Home::class.java)
                            startActivity(intent)
                        } else {
                            Toast.makeText(this, "Invalid Credentials", Toast.LENGTH_SHORT).show()
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
