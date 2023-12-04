package com.example.test2.ui

import android.content.Intent
import android.os.Bundle
import android.widget.Button

import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import com.example.test2.ui.theme.Test2Theme
import android.widget.EditText
import android.widget.Toast
import com.example.test2.R
import com.example.test2.ui.Database_Files.LocalDatabase

class Purchase: ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Test2Theme {

                Surface(color = MaterialTheme.colorScheme.background) {

                    setContentView(R.layout.purchase_activity)


                    val request = findViewById<Button>(R.id.request1)
                    val home = findViewById<Button>(R.id.home1)
                    val usage = findViewById<Button>(R.id.usage1)
                    val purchase = findViewById<Button>(R.id.button7)
                    val meter_number = findViewById<EditText>(R.id.Meter_number)
                    val quantity = findViewById<EditText>(R.id.token_amount)
                    val customerid = findViewById<EditText>(R.id.customerid_purchase)

                    home.setOnClickListener() {

                        val intent = Intent(this, Home::class.java)
                        startActivity(intent)

                    }

                    usage.setOnClickListener() {

                        val intent = Intent(this, Usage::class.java)
                        startActivity(intent)

                    }

                    request.setOnClickListener() {

                        val intent = Intent(this, Request::class.java)
                        startActivity(intent)

                    }

                    purchase.setOnClickListener() {

                        val tokensQuantity = quantity.text.toString().toIntOrNull()
                        val meterNumber = meter_number.text.toString().toIntOrNull()
                        val customerId = customerid.text.toString().toIntOrNull()

                        if (tokensQuantity != null && meterNumber != null && customerId != null) {
                            val pricePerToken = if (tokensQuantity > 10) 15.8 else 12.0 // Price per token based on quantity
                            val totalPrice = pricePerToken * tokensQuantity // Total price calculation

                            // Update token quantity in the Token table and associate it with the meter
                            val localDatabase = LocalDatabase(this)
                            localDatabase.purchaseTokens(tokensQuantity, meterNumber, customerId, pricePerToken)

                            Toast.makeText(this, "Tokens purchased and assigned to the meter", Toast.LENGTH_SHORT).show()
                        } else {
                            Toast.makeText(this, "Invalid input, please check your values", Toast.LENGTH_SHORT).show()
                        }


                    }
                }
            }
        }
    }
}