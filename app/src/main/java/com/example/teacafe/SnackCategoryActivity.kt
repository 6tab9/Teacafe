package com.example.teacafe

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import org.json.JSONArray

class SnackCategoryActivity : AppCompatActivity() {
    private lateinit var snackListView: ListView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_snack_category)
        snackListView = findViewById(R.id.snackListView)

        val json = assets.open("snacks.json").bufferedReader().use { it.readText() }
        val jsonArray = JSONArray(json)
        val listSnacks = mutableListOf<Snack>()

        for (item in 0..jsonArray.length()-1){
            val snackObject=jsonArray.getJSONObject(item)
            listSnacks.add(Snack(
                snackObject.getString("name"),
                snackObject.getString("description"),
                snackObject.getString("image")))
        }

        val snackNames = listSnacks.map{it.name}

        val drinkArrayAdapter = ArrayAdapter(
            this,android.R.layout.simple_list_item_1,snackNames
        )

        snackListView.adapter = drinkArrayAdapter

        snackListView.setOnItemClickListener{_,_,position,_->
            val snack = listSnacks[position]
            Log.d("test",snack.name)

            startActivity(
                Intent(this,SnackActivity::class.java)
                    .putExtra("name",snack.name)
                    .putExtra("description",snack.description)
                    .putExtra("image",snack.image)
            )
        }
    }
}