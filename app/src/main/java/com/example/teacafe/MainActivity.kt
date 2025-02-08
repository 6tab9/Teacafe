package com.example.teacafe

import android.content.Intent
import android.os.Bundle
import android.widget.ListView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    private lateinit var listoptions: ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        listoptions = findViewById(R.id.listCategory)

        listoptions.setOnItemClickListener { _, _, position, _ ->

            when (position) {
                0 -> startNewActivity(DrinkCategoryActivity::class.java)
                1 -> startNewActivity(LocalCategoryActivity::class.java)
                else -> startNewActivity(SnackCategoryActivity::class.java)
            }

        }


    }

    private fun startNewActivity(activityClass: Class<out AppCompatActivity>){
        val intent = Intent(this,activityClass)
        startActivity(intent)
    }
}