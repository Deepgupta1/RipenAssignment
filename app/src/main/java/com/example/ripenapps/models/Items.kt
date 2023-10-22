package com.example.ripenapps.models

data class Items(
    val id:Int,
    val img:Int, val price:Int,
    val rating: Double,
    val desrciption:String,
    val type:String,
    val location:String,
    val owner:String,
    val host:String,
    val phone:String)
