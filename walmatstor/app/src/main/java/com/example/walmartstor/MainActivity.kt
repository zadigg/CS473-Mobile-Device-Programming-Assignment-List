package com.example.walmartstor

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    private val usersList = ArrayList<User>()
    fun onForgotPasswordClick(view: View) {
        val usernameEditText = findViewById<EditText>(R.id.emailEditText)
        val usernameOrEmail = usernameEditText.text.toString()

        val foundUser = usersList.find { it.username == usernameOrEmail || it.password == usernameOrEmail }

        if (foundUser != null) {
            val password = foundUser.password

            val emailIntent = Intent(Intent.ACTION_SEND)
            emailIntent.type = "text/plain"
            emailIntent.putExtra(Intent.EXTRA_TEXT, "Your password: $password")
            emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Password Recovery")

            if (emailIntent.resolveActivity(packageManager) != null) {
                startActivity(emailIntent)
            } else {
                Toast.makeText(this, "No email found", Toast.LENGTH_SHORT).show()
            }
        } else {
            Toast.makeText(this, "User not found. Please enter a valid username or email.", Toast.LENGTH_SHORT).show()
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        usersList.add(User("abc", "abc", "abc@abc.com", "abc"))
        usersList.add(User("a", "a", "a@a.a", "a"))
        usersList.add(User("Bob", "Johnson", "bob@example.com", "mySecretPwd"))
        usersList.add(User("Eve", "Adams", "eve@example.com", "123456"))
        usersList.add(User("Charlie", "Brown", "charlie@example.com", "brownie"))

        val usernameEditText = findViewById<EditText>(R.id.emailEditText)
        val passwordEditText = findViewById<EditText>(R.id.passwordEditText)
        val loginButton = findViewById<Button>(R.id.loginButton)




        loginButton.setOnClickListener(View.OnClickListener {
            val enteredUsername = usernameEditText.text.toString()
            val enteredPassword = passwordEditText.text.toString()

            val userFound = usersList.find { it.username == enteredUsername && it.password == enteredPassword }

            if (userFound != null) {
                val message = "Login successful. Welcome, ${userFound.firstname}!"

                Toast.makeText(this, message, Toast.LENGTH_SHORT).show()

                val intent = Intent(this, ShopActivity::class.java)
                intent.putExtra("username", userFound.username) // Add firstname as an extra
                startActivity(intent)
            } else {
                val message = "Login failed. Invalid username or password."
                Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
            }
        })
    }

    fun goToSignUpActivity(view: View) {
        val intent = Intent(this, SignUp::class.java)
        startActivity(intent)
    }
}