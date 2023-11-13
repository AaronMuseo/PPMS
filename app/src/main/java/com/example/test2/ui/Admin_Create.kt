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
import com.example.test2.R
import com.example.test2.ui.ui.theme.Test2Theme
import com.example.test2.ui.Database_Files.LocalDatabase

class Admin_Create : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Test2Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {

                            setContentView(R.layout.admin_create_activity)

                        val home = findViewById<Button>(R.id.admin_home2)
                        val change = findViewById<Button>(R.id.change)
                        val suspend = findViewById<Button>(R.id.suspend)
                        val create_acc = findViewById<Button>(R.id.create_acc)

                        val username = findViewById<EditText>(R.id.admin_username)
                        val password = findViewById<EditText>(R.id.admin_password)


                        home.setOnClickListener(){
                            //add create function

                        }

                        suspend.setOnClickListener(){
                            val intent = Intent(this, AdminSuspend::class.java)
                            startActivity(intent)
                        }



                        change.setOnClickListener(){
                            val intent = Intent(this, Admin_Change::class.java)
                            startActivity(intent)
                        }

                        create_acc.setOnClickListener(){

                            val DB = LocalDatabase(this)
                            DB.addConsumer(username.text.toString(), password.text.toString())

                        }
                }
            }
        }
    }
}
