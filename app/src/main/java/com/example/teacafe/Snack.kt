package com.example.teacafe

import java.io.File


class Snack (
    val name:String,
    val description:String,
    val image:Int
){
    companion object{
        val file = File("../../../../../res/values/snacks.json")

        val json = file.readText()
//        val snacks =
    }
}