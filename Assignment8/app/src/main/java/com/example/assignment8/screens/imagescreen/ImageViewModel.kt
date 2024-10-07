package com.example.assignment8.screens.imagescreen

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.assignment8.network.CharactersItem

class ImageViewModel(
    val property: CharactersItem,
    val app: Application
): ViewModel() {
    private val _navigateToMain = MutableLiveData<Boolean>()
    val navigateToMain: LiveData<Boolean>
        get() = _navigateToMain

    fun startNavigating(){
        _navigateToMain.value = true
    }

    fun doneNavigating(){
        _navigateToMain.value = false
    }
}