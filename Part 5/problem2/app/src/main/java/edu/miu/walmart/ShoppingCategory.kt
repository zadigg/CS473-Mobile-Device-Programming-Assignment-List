package edu.miu.walmart

import android.content.Intent
import android.os.Bundle
import android.widget.AdapterView
import android.widget.GridView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import edu.miu.walmart.adapters.CatAdapter
import edu.miu.walmart.models.Category
import edu.miu.walmart.models.Product

class ShoppingCategory : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shopping_category)

        val extras = intent.extras
        if (extras != null) {
            val value = extras.getString("email")
            val welcomeTxt: TextView = findViewById(R.id.txtWelcome)
            welcomeTxt.text = "Welcome $value";
            //The key argument here must match that used in the other activity
        }

        val grView: GridView = findViewById(R.id.grLayout)
        val cateList = arrayListOf(
            Category(R.drawable.monitor, "Electronics"),
            Category(R.drawable.clothing, "Clothing"),
            Category(R.drawable.beauty, "Beauty"),
            Category(R.drawable.food, "Food"),
        );

        val adapter = CatAdapter(this, cateList)
        grView.adapter = adapter

        grView.onItemClickListener =
            AdapterView.OnItemClickListener { parent, view, position, id ->
                val intent = Intent(this, ProductList::class.java)
                startActivity(intent)
            }
    }
}

