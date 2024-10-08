package com.example.assignment10.showdetails

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.assignment10.database.getDatabase
import com.example.assignment10.domain.Game
import com.example.assignment10.repository.GamesRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch

class ShowDetailViewModel(app: Application): AndroidViewModel(app) {

    private val viewModelJob = SupervisorJob()
    private val viewModelScope = CoroutineScope(viewModelJob + Dispatchers.Main)

    private val database = getDatabase(app)
    private val repository = GamesRepository(database)

    init{
        viewModelScope.launch {
            repository.refreshGames()
        }
    }

    val response = repository.games
}