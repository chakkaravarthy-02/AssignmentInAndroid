package com.example.assignment10.network

import com.example.assignment10.database.DatabaseGame

fun List<GameDetailItem>.asDatabaseModel(): Array<DatabaseGame>{
    return map{
        DatabaseGame(id = it.id, genre = it.genre, thumbnail = it.thumbnail, developer = it.developer, title = it.title, short_description = it.short_description)
    }.toTypedArray()
}