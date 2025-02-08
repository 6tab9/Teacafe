package com.example.teacafe

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import org.w3c.dom.Text

class DrinkActivity : AppCompatActivity() {
    private lateinit var Image: ImageView
    private lateinit var Title: TextView
    private lateinit var Descr: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_drink)

        val drinkId = intent.getIntExtra("drinkId",-1)
        val drink = Drink.drinks[drinkId]
        Image = findViewById(R.id.Image)
        Title = findViewById(R.id.name)
        Descr = findViewById(R.id.descr)

        Image.setImageResource(drink.image)
        Title.setText(drink.name)
        Descr.setText(drink.description)
    }
}