package com.example.tugasandroidfundamental.activity

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.tugasandroidfundamental.R
import com.example.tugasandroidfundamental.model.User
import com.google.android.material.textfield.TextInputEditText

class Login : AppCompatActivity() {
    private lateinit var emailInput: TextInputEditText
    private lateinit var passwordInput: TextInputEditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        emailInput = findViewById(R.id.emailInputEditText)
        passwordInput = findViewById(R.id.passwordInputEditText)

        val bundle = intent.extras
        bundle?.getString("email")?.let {
            emailInput.setText(it)
        }
    }

    fun handleSignIn(v: View?) {
        val bundle = intent.extras ?: return

        val password = bundle.getString("password", "")

        // Compare password
        if (password == passwordInput.text.toString()) {
            val username = bundle.getString("username", "")
            val email = bundle.getString("email", "")
            val phoneNumber = bundle.getString("phoneNumber", "")

            // We use parcelize here, just to show case :D
            val intent = Intent(this, Home::class.java).apply {
                putExtra("User", User(username, email, phoneNumber, password))
            }
            startActivity(intent)
        } else {
            Toast.makeText(this, "Password Incorrect", Toast.LENGTH_SHORT).show()
        }
    }
}