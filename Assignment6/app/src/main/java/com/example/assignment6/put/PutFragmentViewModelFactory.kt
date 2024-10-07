package com.example.assignment6.put

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.assignment6.database.DetailsDatabaseDao

class PutFragmentViewModelFactory(
    private val dataSource: DetailsDatabaseDao
) : ViewModelProvider.Factory {
    @Suppress("unchecked_cast")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(PutFragmentViewModel::class.java)) {
            return PutFragmentViewModel(dataSource) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")

    }
}