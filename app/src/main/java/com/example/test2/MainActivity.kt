package com.example.test2

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import com.example.test2.ui.theme.Test2Theme
import com.example.test2.ui.Home
import android.content.Context
import android.content.SharedPreferences
import com.example.test2.ui.AdminLogin
import com.example.test2.ui.Register

class MainActivity : ComponentActivity() {




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Test2Theme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colorScheme.background) {


                    setContentView(R.layout.main_activity)






                    val inputText = findViewById<EditText>(R.id.username)
                    val inputText2 = findViewById<EditText>(R.id.password)

                    val showButton = findViewById<Button>(R.id.login)
                    val register = findViewById<Button>(R.id.register1)
                    val admin = findViewById<Button>(R.id.admin_login)

                    register.setOnClickListener() {
                        val intent = Intent(this, Register::class.java)
                        startActivity(intent)
                    }

                    admin.setOnClickListener() {
                        val intent = Intent(this, AdminLogin::class.java)
                        startActivity(intent)


                    }

                    showButton.setOnClickListener {

                        val username = inputText.text.toString()
                        val password = inputText2.text.toString()

                        if (username == "Aaron" && password == "Aaron") {
                            println("Login Success")

                            val intent = Intent(this, Home::class.java)
                            startActivity(intent)

                        } else {
                            println("Login Failed")
                            Toast.makeText(this, inputText.text, Toast.LENGTH_SHORT).show()
                        }



                   }

                }
            }
        }
    }
}

