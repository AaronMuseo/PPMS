package com.example.test2.ui

import android.content.Context
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
import com.example.test2.R
import com.example.test2.ui.Database_Files.LocalDatabase
import com.example.test2.ui.theme.Test2Theme

class Request : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Test2Theme {

                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {




                    setContentView(R.layout.request_activity)

                    val Location = findViewById<EditText>(R.id.Location)


                    val home = findViewById<Button>(R.id.home_r)
                    val purchase = findViewById<Button>(R.id.purchase_r)
                    val usage = findViewById<Button>(R.id.usage_r)
                    val request = findViewById<Button>(R.id.request_button)
                    val customerid = findViewById<EditText>(R.id.cust_ID)


                    home.setOnClickListener {
                        val intent = Intent(this, Home::class.java)
                        startActivity(intent)
                    }
                    purchase.setOnClickListener {
                        val intent = Intent(this, Purchase::class.java)
                        startActivity(intent)
                    }
                    usage.setOnClickListener {
                        val intent = Intent(this, Usage::class.java)
                        startActivity(intent)
                    }


                    request.setOnClickListener() {

                        val location = Location.text.toString()
                        val customerId = customerid.text.toString().toIntOrNull()

                        val localDatabase = LocalDatabase(this)

                        if (customerId != null) {
                            localDatabase.updateMeterLocation(customerId, location)
                            localDatabase.updateConsumerLocation(customerId, location)
                            Toast.makeText(this, "Meter assigned", Toast.LENGTH_SHORT).show()
                        } else {
                            Toast.makeText(this, "System Error", Toast.LENGTH_SHORT).show()
                        }
                    }

                    }
                }
            }
        }
    }

