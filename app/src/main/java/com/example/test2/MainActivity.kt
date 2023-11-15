package com.example.test2

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import com.example.test2.ui.theme.Test2Theme
import com.example.test2.ui.Home
import android.content.Context
import android.content.SharedPreferences
import com.example.test2.ui.AdminLogin
import com.example.test2.ui.Database_Files.LocalDatabase
import com.example.test2.ui.KPLC_Home
import com.example.test2.ui.KPLC_SignIn
import com.example.test2.ui.Register
import com.example.test2.ui.Request

class MainActivity : ComponentActivity() {

    private val PREFS_NAME = "MyPrefs"
    private val CUSTOMER_ID_KEY = "customer_id"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Test2Theme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colorScheme.background) {


                    setContentView(R.layout.main_activity)






                    val inputText = findViewById<EditText>(R.id.username)
                    val inputText2 = findViewById<EditText>(R.id.password)

                    val login = findViewById<Button>(R.id.login)
                    val register = findViewById<Button>(R.id.register1)
                    val admin = findViewById<Button>(R.id.admin_login)
                    val kplc = findViewById<Button>(R.id.kplc_login2)

                    register.setOnClickListener() {
                        val intent = Intent(this, Register::class.java)
                        startActivity(intent)
                    }

                    admin.setOnClickListener() {
                        val intent = Intent(this, AdminLogin::class.java)
                        startActivity(intent)


                    }

                    login.setOnClickListener {

                        val username = inputText.text.toString()
                        val password = inputText2.text.toString()

                        val DB = LocalDatabase(this)
                        val loginSuccessful = DB.loginUser(username, password)

                        if (loginSuccessful) {

                            val customerID = DB.getCustomerIdByUsername(username)

                            val sharedPref = getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)

                            val editor = sharedPref.edit()

                            editor.putInt(CUSTOMER_ID_KEY, customerID)
                            editor.apply()

                            Toast.makeText(this, "Logged in Successfully", Toast.LENGTH_SHORT).show()

                            val intent = Intent(this, Request::class.java)
                            intent.putExtra("USERNAME", username)
                            intent.putExtra("CUSTOMER_ID_KEY", CUSTOMER_ID_KEY)
                            startActivity(intent)
                        } else {
                            Toast.makeText(this, "Invalid Credentials", Toast.LENGTH_SHORT).show()
                        }

                   }

                    kplc.setOnClickListener(){
                        val intent = Intent(this, KPLC_SignIn::class.java)
                        startActivity(intent)



                    }



                }
            }
        }
    }
}

