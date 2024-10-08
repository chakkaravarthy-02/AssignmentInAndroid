package com.example.assignment10.database

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.assignment10.domain.Game


@Entity(tableName = "databasegame")
data class DatabaseGame(
    @PrimaryKey
    val id: Int,
    val genre: String,
    val thumbnail: String,
    val developer: String,
    val title: String,
    val short_description:String
)

fun List<DatabaseGame>.asDomainModel(): List<Game>{
    return map {
        Game(id = it.id, genre = it.genre, thumbnail = it.thumbnail, developer = it.developer, title = it.title, short_description = it.short_description)
    }
}