package com.example.test2.ui

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.test2.MainActivity
import com.example.test2.R
import com.example.test2.ui.ui.theme.Test2Theme

class Register : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Test2Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    setContentView(R.layout.register_activity)

                    val username = findViewById<EditText>(R.id.usernamer)
                    val password = findViewById<EditText>(R.id.pwd)
                    val confirm = findViewById<EditText>(R.id.pwdc)
                    val phone = findViewById<EditText>(R.id.number)

                    val register = findViewById<Button>(R.id.register)
                    val login = findViewById<Button>(R.id.login1)

                    login.setOnClickListener(){
                        val intent = Intent(this, MainActivity::class.java)
                        startActivity(intent)
                    }

                    register.setOnClickListener(){
                        val intent = Intent(this, Home::class.java)
                        startActivity(intent)
                    }

                }
            }
        }
    }
}

