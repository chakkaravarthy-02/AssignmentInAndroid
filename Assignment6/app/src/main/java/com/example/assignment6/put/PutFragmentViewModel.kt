package com.example.assignment6.put

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.assignment6.database.Details
import com.example.assignment6.database.DetailsDatabaseDao

class PutFragmentViewModel(private val detailsDao: DetailsDatabaseDao) : ViewModel() {
    val lastDetails: LiveData<Details?> = detailsDao.getDetails()
}