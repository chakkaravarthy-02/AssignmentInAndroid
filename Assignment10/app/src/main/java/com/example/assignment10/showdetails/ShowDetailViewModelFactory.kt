package com.example.assignment10.showdetails

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class ShowDetailViewModelFactory(private val app:Application): ViewModelProvider.Factory {
    @Suppress("unchecked_cast")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(ShowDetailViewModel::class.java)){
            return ShowDetailViewModel(app) as T
        }else{
            throw IllegalArgumentException("Unknown class")
        }
    }
}