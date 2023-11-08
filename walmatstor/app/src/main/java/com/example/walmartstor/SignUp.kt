package com.example.walmartstor

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class SignUp : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        val firstNameEditText = findViewById<EditText>(R.id.firstNameEditText)
        val lastNameEditText = findViewById<EditText>(R.id.lastNameEditText)
        val emailEditText = findViewById<EditText>(R.id.emailEditText)
        val passwordEditText = findViewById<EditText>(R.id.passwordEditText)
        val registerButton = findViewById<Button>(R.id.registerButton)

        registerButton.setOnClickListener {
            val username = firstNameEditText.text.toString()
            val email = emailEditText.text.toString()
            val password = passwordEditText.text.toString()
            val phoneNumber = lastNameEditText.text.toString()

            if (username.isNotBlank() && email.isNotBlank() && password.isNotBlank() && phoneNumber.isNotBlank()) {
                val user = User(username, email, password, phoneNumber)

                Toast.makeText(this, "Account created successfully", Toast.LENGTH_SHORT).show()
                userDatabase.add(user)
            } else {
                Toast.makeText(this, "Please fill in all fields", Toast.LENGTH_SHORT).show()
            }
        }




    }
    companion object {
        val userDatabase = ArrayList<User>()
    }
}