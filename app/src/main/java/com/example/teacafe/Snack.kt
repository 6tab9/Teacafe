package com.example.teacafe

import java.io.File


class Snack (
    val name:String,
    val description:String,
    val image:String
){

    override fun toString():String{
        return name
    }
}