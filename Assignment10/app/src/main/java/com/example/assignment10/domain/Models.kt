package com.example.assignment10.domain

import androidx.room.PrimaryKey

data class Game(
    val id: Int,
    val genre: String,
    val thumbnail: String,
    val developer: String,
    val title: String,
    val short_description:String
)