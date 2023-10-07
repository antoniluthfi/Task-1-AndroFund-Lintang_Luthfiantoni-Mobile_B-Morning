package com.example.tugasandroidfundamental.activity

import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.tugasandroidfundamental.R
import com.example.tugasandroidfundamental.model.User

class Home : AppCompatActivity() {
    private lateinit var usernameTextView: TextView
    private lateinit var emailTextView: TextView
    private lateinit var phoneNumberTextView: TextView
    private lateinit var passwordTextView: TextView

    private var username: String? = null
    private var email: String? = null
    private var phoneNumber: String? = null
    private var password: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        username = intent.getParcelableExtra<User>("User")?.username
        usernameTextView = findViewById(R.id.usernameTextView)
        usernameTextView.text = "Hello, $username"

        email = intent.getParcelableExtra<User>("User")?.email
        emailTextView = findViewById(R.id.emailTextView)
        emailTextView.text = "Your Email: $email"

        phoneNumber = intent.getParcelableExtra<User>("User")?.phoneNumber
        phoneNumberTextView = findViewById(R.id.phoneNumberTextView)
        phoneNumberTextView.text = "Your Phone Number: 0$phoneNumber"

        password = intent.getParcelableExtra<User>("User")?.password
        passwordTextView = findViewById(R.id.passwordTextView)
        passwordTextView.text = "Your Password: $password"
    }

    fun handleFragment(v: View?) {
        startActivity(Intent(this, Fragment::class.java))
    }

    fun handleImplicit(v: View?) {
        val phoneNumber = "6282148507278"
        val message = """
            Hello Antoni, I'm $username
            
            My Phone Number is $phoneNumber
            My Email is $email
            
            Have a nice day :D
        """.trimIndent()

        val intent = Intent(Intent.ACTION_VIEW)
        intent.data = Uri.parse("https://api.whatsapp.com/send?phone=$phoneNumber&text=$message")

        try {
            startActivity(intent)
        } catch (e: ActivityNotFoundException) {
            Toast.makeText(this, "WhatsApp is not installed in your device.", Toast.LENGTH_SHORT)
                .show()
        }
    }
}