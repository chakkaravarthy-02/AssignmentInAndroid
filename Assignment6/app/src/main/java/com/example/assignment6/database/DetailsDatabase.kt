package com.example.assignment6.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Details::class], version = 1, exportSchema = false)
abstract class DetailsDatabase : RoomDatabase() {
    abstract val detailsDatabaseDao: DetailsDatabaseDao

    companion object {

        @Volatile
        private var INSTANCE: DetailsDatabase? = null

        fun getInstance(context: Context): DetailsDatabase {
            synchronized(this) {
                var instance = INSTANCE

                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        DetailsDatabase::class.java,
                        "family_details"
                    )
                        .fallbackToDestructiveMigration()
                        .build()
                    INSTANCE = instance
                }

                return instance
            }
        }
    }
}