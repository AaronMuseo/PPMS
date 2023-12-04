package com.example.test2.ui

import android.content.Intent
import android.os.Bundle
import android.widget.Button
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
import com.example.test2.ui.ui.theme.ui.theme.Test2Theme

class AdminHome : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Test2Theme {

                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {

                    setContentView(R.layout.admin_home_activity)

                    val create = findViewById<Button>(R.id.admin_create)
                    val change = findViewById<Button>(R.id.admin_change)
                    val delete = findViewById<Button>(R.id.button11)
                    val logout = findViewById<Button>(R.id.admin_logout)

                    create.setOnClickListener(){
                        val intent = Intent(this, Admin_Create::class.java)
                        startActivity(intent)
                    }

                    change.setOnClickListener(){
                        val intent = Intent(this, Admin_Change::class.java)
                        startActivity(intent)
                    }

                    delete.setOnClickListener() {
                        val intent = Intent(this, AdminSuspend::class.java)
                        startActivity(intent)
                    }

                    logout.setOnClickListener(){
                        val intent = Intent(this, MainActivity::class.java)
                        startActivity(intent)
                    }
                }
            }
        }
    }
}