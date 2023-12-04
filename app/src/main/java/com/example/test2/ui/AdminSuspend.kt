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

                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {

                        setContentView(R.layout.admin_suspend_activity)

                        val usr = findViewById<EditText>(R.id.usr)
                        val ID = findViewById<EditText>(R.id.ID)
                        val home = findViewById<Button>(R.id.Home1)
                        val create = findViewById<Button>(R.id.Create)
                        val change = findViewById<Button>(R.id.Change)
                        val delete = findViewById<Button>(R.id.suspen1)

                    change.setOnClickListener(){

                        val intent = Intent(this, Admin_Change::class.java)
                        startActivity(intent)
                    }

                    create.setOnClickListener(){
                        val intent = Intent(this, Admin_Create::class.java)
                        startActivity(intent)
                    }

                    home.setOnClickListener {
                        val intent = Intent(this, AdminHome::class.java)
                        startActivity(intent)

                    }

                    delete.setOnClickListener(){

                        val DB = LocalDatabase(this)
                        val usernameToDelete = usr.text.toString()
                        val customerIdToDelete = ID.text.toString().toIntOrNull()

                        if (customerIdToDelete != null) {
                            DB.deleteUser(usernameToDelete, customerIdToDelete)
                        } else {

                            Toast.makeText(this, "Invalid Customer ID", Toast.LENGTH_SHORT).show()
                        }

                    }




                }
            }
        }
    }
}