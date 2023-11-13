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

class KPLC_Usage : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Test2Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {

                    setContentView(R.layout.kplc_usage_activity)

                    val usage_text = findViewById<EditText>(R.id.kplc_usage_search)
                    val search = findViewById<Button>(R.id.kplc_search1)
                    val home = findViewById<Button>(R.id.kplc_home1)
                    val info = findViewById<Button>(R.id.kplc_info1)

                    search.setOnClickListener(){

                        //create function to read data from database

                    }

                    home.setOnClickListener(){

                        val intent = Intent(this, KPLC_Home::class.java)
                        startActivity(intent)

                    }

                    info.setOnClickListener(){

                        val intent = Intent(this, KPLC_Info::class.java)
                        startActivity(intent)

                    }

                }
            }
        }
    }
}