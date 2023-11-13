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
import com.example.test2.ui.ui.theme.Test2Theme

class KPLC_SignIn : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Test2Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {

                    setContentView(R.layout.kplc_signin_activity)

                    val usr = findViewById<EditText>(R.id.kplc_username)
                    val pwd = findViewById<EditText>(R.id.kplc_password)
                    val lgn = findViewById<Button>(R.id.kplc_login)
                    val back = findViewById<Button>(R.id.button3)

                    lgn.setOnClickListener(){

                        val username = usr.text.toString()
                        val password = pwd.text.toString()


                        if(username == "kplc" && password== "kplc"){

                            Toast.makeText(this, "Login Successful", Toast.LENGTH_SHORT).show()
                            val intent = Intent(this, KPLC_Home::class.java)
                            startActivity(intent)
                        }else{

                            Toast.makeText(this, "Invalid Credentials", Toast.LENGTH_SHORT).show()

                        }

                    }


                }
            }
        }
    }
}
