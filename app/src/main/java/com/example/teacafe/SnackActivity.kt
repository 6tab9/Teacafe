package com.example.teacafe

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import kotlin.random.Random

class SnackActivity : AppCompatActivity() {
    private lateinit var Image: ImageView
    private lateinit var Title: TextView
    private lateinit var Descr: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_snack)

        val SnackId = intent.getIntExtra("snackID",-1)
        val Snack = Snack.snacks[SnackId]

        Image = findViewById(R.id.Image)
        Title = findViewById(R.id.name)
        Descr = findViewById(R.id.descr)
        Image.setImageResource(Snack.image)
        Image.setColorFilter(Random.nextInt()*1000)
        Title.text = Snack.name
        Descr.text = Snack.description
    }
}