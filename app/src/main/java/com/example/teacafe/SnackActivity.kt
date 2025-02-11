package com.example.teacafe

import android.graphics.Color
import android.os.Bundle
import android.util.Log
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

        val snackName = intent.getStringExtra("name")
        val snackDescr = intent.getStringExtra("description")
        val snackImage = intent.getStringExtra("image")

        Image = findViewById(R.id.Image)
        Title = findViewById(R.id.name)
        Descr = findViewById(R.id.descr)
        Log.d("test",snackImage.toString())
        Image.setImageResource(resources.getIdentifier(snackImage,"drawable",packageName))
        val RGBcolor = Color.rgb(
            Random.nextInt(256),
            Random.nextInt(256),
            Random.nextInt(256)
        )

        Image.setColorFilter(RGBcolor)
        Title.text = snackName
        Descr.text = snackDescr
    }
}