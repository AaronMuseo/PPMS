package com.example.test2.ui

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.example.test2.R
import com.example.test2.ui.Database_Files.LocalDatabase
import com.example.test2.ui.ui.theme.Test2Theme

class Usage : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Test2Theme {

                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    setContentView(R.layout.usage_activity)



                    val home = findViewById<Button>(R.id.Home)
                    val request = findViewById<Button>(R.id.Request)
                    val purchase = findViewById<Button>(R.id.Purchase)
                    val search = findViewById<Button>(R.id.search)
                    val meter_number = findViewById<EditText>(R.id.meter_num)


                    home.setOnClickListener(){
                        intent = Intent(this, Home::class.java)
                        startActivity(intent)
                    }

                    purchase.setOnClickListener(){
                        intent = Intent(this, Purchase::class.java)
                        startActivity(intent)
                    }

                    request.setOnClickListener(){
                        intent = Intent(this, Request::class.java)
                        startActivity(intent)
                    }

                    search.setOnClickListener(){

                        val meterNumber = meter_number.text.toString().toIntOrNull()
                        if (meterNumber != null) {
                            val localDatabase = LocalDatabase(this)
                            val usage = localDatabase.getUsageByMeterNumber(meterNumber)

                            val resultTextView = findViewById<TextView>(R.id.result)
                            if (usage != -1) {
                                resultTextView.text = "Usage: $usage" // Set the usage value in the TextView
                            } else {
                                resultTextView.text = "No usage found for this meter number"
                            }
                        } else {
                            Toast.makeText(this, "Please enter a valid meter number", Toast.LENGTH_SHORT).show()
                        }

                    }



                }
            }
        }
    }
}

