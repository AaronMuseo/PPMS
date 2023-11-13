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
import com.example.test2.R
import com.example.test2.ui.ui.theme.Test2Theme

class KPLC_Request : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Test2Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {

                    setContentView(R.layout.kplc_request_activity)

                    val info =findViewById<Button>(R.id.kplc_info4)
                    val home = findViewById<Button>(R.id.kplc_home3)
                    val usage = findViewById<Button>(R.id.kplc_usage4)

                    info.setOnClickListener(){
                        val intent = Intent(this,KPLC_Info::class.java)
                        startActivity(intent)
                    }

                    home.setOnClickListener(){
                        val intent = Intent(this,KPLC_Home::class.java)
                        startActivity(intent)
                    }

                    usage.setOnClickListener(){
                        val intent = Intent(this, KPLC_Usage::class.java)
                        startActivity(intent)
                    }

                    //create funtion to view details abt requests made by Consumer

                }
            }
        }
    }
}