package com.example.teacafe

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class DrinkCategoryActivity : AppCompatActivity() {
    private lateinit var listViewDrinks: ListView
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_drink_category)
        listViewDrinks = findViewById(R.id.listViewDrinks)

        val drinkArrayAdapter = ArrayAdapter(
            this,android.R.layout.simple_list_item_1,Drink.drinks
        )

        listViewDrinks.adapter = drinkArrayAdapter

        listViewDrinks.setOnItemClickListener{_,_,position,_->
            startActivity(
                Intent(this,DrinkActivity::class.java).putExtra("drinkId",position)
            )
        }
    }
}