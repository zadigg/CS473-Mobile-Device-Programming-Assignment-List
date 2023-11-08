package com.example.walmartstor

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

class ShopActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shop)


        val email = intent.getStringExtra("username")
                val welcomeMessage = "Welcome, $email!"


         val welcomeTextView = findViewById<TextView>(R.id.welcomeTextView)
         welcomeTextView.text = welcomeMessage

        val clothingImageView = findViewById<ImageView>(R.id.aa)
        val electronicsImageView = findViewById<ImageView>(R.id.a)
        val booksImageView = findViewById<ImageView>(R.id.cc)
        val toyImageView = findViewById<ImageView>(R.id.c)


        clothingImageView.setOnClickListener(View.OnClickListener {
            val message = "You have chosen the Clothing category of shopping"
            Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
        })
        toyImageView.setOnClickListener(View.OnClickListener {
            val message = "You have chosen the Toy category of shopping"
            Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
        })

        electronicsImageView.setOnClickListener(View.OnClickListener {
            val message = "You have chosen the Electronics category of shopping"
            Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
        })

        booksImageView.setOnClickListener(View.OnClickListener {
            val message = "You have chosen the Books category of shopping"
            Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
        })
    }
}