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
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.test2.R
import com.example.test2.ui.Database_Files.LocalDatabase
import com.example.test2.ui.ui.theme.Test2Theme

class AdminSuspend : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Test2Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {

                        setContentView(R.layout.admin_suspend_activity)

                        val usr = findViewById<EditText>(R.id.usr)
                        val ID = findViewById<EditText>(R.id.ID)
                        val suspend = findViewById<Button>(R.id.Home1)
                        val create = findViewById<Button>(R.id.Create)
                        val change = findViewById<Button>(R.id.Change)


                        create.setOnClickListener(){
                            val intent = Intent(this, Admin_Create::class.java)
                            startActivity(intent)
                        }

                    suspend.setOnClickListener(){
                        val intent = Intent(this, AdminSuspend::class.java)
                        startActivity(intent)
                    }

                    change.setOnClickListener(){

                        val DB = LocalDatabase(this)
                        val usernameToDelete = usr.text.toString()
                        val customerIdToDelete = ID.text.toString().toIntOrNull()

                        if (customerIdToDelete != null) {
                            DB.deleteConsumer(usernameToDelete, customerIdToDelete)
                        } else {
                            // Handle the case where the entered customer ID is not a valid integer
                            Toast.makeText(this, "Invalid Customer ID", Toast.LENGTH_SHORT).show()
                        }

                    }




                }
            }
        }
    }
}