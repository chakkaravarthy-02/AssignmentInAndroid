package com.example.assignment10.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


@Database(entities = [DatabaseGame::class], version = 1, exportSchema = false)
abstract class GameDatabase : RoomDatabase(){
    abstract val gameDao: GameDetailDao
}

private lateinit var INSTANCE : GameDatabase

fun getDatabase(context: Context): GameDatabase{
    synchronized(GameDatabase::class.java){
        if(!::INSTANCE.isInitialized){
            INSTANCE = Room.databaseBuilder(context.applicationContext,
                GameDatabase::class.java,
                "games").build()
        }
    }
    return INSTANCE
}