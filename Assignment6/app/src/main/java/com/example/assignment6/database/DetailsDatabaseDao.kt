package com.example.assignment6.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query


@Dao
interface DetailsDatabaseDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(detail: Details)

    @Query("SELECT * FROM family_details ORDER BY personId DESC LIMIT 1")
    fun getDetails(): LiveData<Details?>

}