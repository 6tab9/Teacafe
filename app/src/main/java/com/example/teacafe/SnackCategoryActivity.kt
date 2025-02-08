package com.example.teacafe

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class SnackCategoryActivity : AppCompatActivity() {
    private lateinit var snackListView: ListView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_snack_category)
        snackListView = findViewById(R.id.snackListView)

        val drinkArrayAdapter = ArrayAdapter(
            this,android.R.layout.simple_list_item_1,Snack.snacks
        )

        snackListView.adapter = drinkArrayAdapter

        snackListView.setOnItemClickListener{_,_,position,_->
            startActivity(
                Intent(this,SnackActivity::class.java).putExtra("snackID",position)
            )
        }
    }
}