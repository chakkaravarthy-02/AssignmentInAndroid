package com.example.assignment10.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query


@Dao
interface GameDetailDao {
    @Query("select * from databasegame")
    fun getGameDetails():LiveData<List<DatabaseGame>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(vararg game: DatabaseGame)
}
