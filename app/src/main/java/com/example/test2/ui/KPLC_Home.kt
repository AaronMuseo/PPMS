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
import com.example.test2.ui.ui.theme.Test2Theme

class KPLC_Home : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Test2Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {

                    setContentView(R.layout.kplc_home_activity)

                    val usage = findViewById<Button>(R.id.kplc_usage)
                    val logout = findViewById<Button>(R.id.kplc_logout1)


                    usage.setOnClickListener(){
                        val intent = Intent(this, KPLC_Usage::class.java)
                        startActivity(intent)
                    }

                    logout.setOnClickListener(){

                        val intent = Intent(this,MainActivity::class.java)
                        startActivity(intent)

                    }

                }
            }
        }
    }
}

