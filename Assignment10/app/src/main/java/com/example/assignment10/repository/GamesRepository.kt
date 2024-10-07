package com.example.assignment10.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.map
import com.example.assignment10.database.GameDatabase
import com.example.assignment10.database.asDomainModel
import com.example.assignment10.domain.Game
import com.example.assignment10.network.Network
import com.example.assignment10.network.asDatabaseModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class GamesRepository(private val database: GameDatabase){
    val games: LiveData<List<Game>> = database.gameDao.getGameDetails().map {
        it.asDomainModel()
    }

    suspend fun refreshGames(){
        withContext(Dispatchers.IO){
            try {
                val gameList = Network.games.getGameDetails().await()
                database.gameDao.insertAll(*gameList.asDatabaseModel())
            }catch (e: Exception){
                println("Server Error: $e")
            }
        }
    }
}