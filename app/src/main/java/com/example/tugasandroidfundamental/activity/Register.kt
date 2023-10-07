package com.example.tugasandroidfundamental.activity

import android.content.Intent
import android.os.Bundle
import android.util.Patterns
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.tugasandroidfundamental.R
import com.google.android.material.textfield.TextInputEditText

class Register : AppCompatActivity() {
    private lateinit var usernameInput: TextInputEditText
    private lateinit var emailInput: TextInputEditText
    private lateinit var phoneNumberInput: TextInputEditText
    private lateinit var passwordInput: TextInputEditText
    private lateinit var retypePasswordInput: TextInputEditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        usernameInput = findViewById(R.id.usernameInputEditText)
        emailInput = findViewById(R.id.emailInputEditText)
        phoneNumberInput =
            findViewById(R.id.phoneNumberInputEditText)
        passwordInput = findViewById(R.id.passwordInputEditText)
        retypePasswordInput =
            findViewById(R.id.retypePasswordInputEditText)
    }

    fun handleSignUp(v: View?) {
        val username = usernameInput.text.toString()
        val email = emailInput.text.toString()
        val phoneNumber = phoneNumberInput.text.toString()
        val password = passwordInput.text.toString()
        val retypePassword = retypePasswordInput.text.toString()

        // Validate username
        if (username.isEmpty()) {
            usernameInput.error = "Username is required!"
            return
        }

        // Validate email
        if (email.isEmpty()) {
            emailInput.error = "Email is required"
            return
        }

        // Validate email
        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            emailInput.error = "Email is not valid"
            return
        }

        // Validate phone number
        if (!Patterns.PHONE.matcher(phoneNumber).matches()) {
            phoneNumberInput.error = "Phone number is not valid"
            return
        }

        // Validate phone number
        if (phoneNumber.isEmpty()) {
            phoneNumberInput.error = "Phone number is required"
            return
        }

        // Validate password
        if (password.isEmpty()) {
            passwordInput.error = "Password is required"
            return
        }

        // Validate password confirmation
        if (retypePassword.isEmpty()) {
            retypePasswordInput.error = "Password confirmation is required"
            return
        }

        // Compare password
        if (password == retypePassword) {
            // We don't use parcelize here, just to show case :D
            val bundle = Bundle().apply {
                putString("username", username)
                putString("email", email)
                putString("phoneNumber", phoneNumber)
                putString("password", password)
            }

            val intent = Intent(this, Login::class.java).apply {
                putExtras(bundle)
            }
            startActivity(intent)
        } else {
            Toast.makeText(this, "Password Incorrect", Toast.LENGTH_SHORT).show()
        }
    }
}