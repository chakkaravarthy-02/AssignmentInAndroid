package com.example.assignment6.get

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.assignment6.database.Details
import com.example.assignment6.database.DetailsDatabaseDao
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class GetFragmentViewModel(
    private val database: DetailsDatabaseDao
) : ViewModel() {
    private val viewModelJob = Job()

    private val uiScope = CoroutineScope(Dispatchers.Main + viewModelJob)

    private val _navigateToPutFragment = MutableLiveData<Boolean?>()
    val navigateToPutFragment: LiveData<Boolean?>
        get() = _navigateToPutFragment

    fun doneNavigating() {
        _navigateToPutFragment.value = null
    }

    fun insertDetails(details: Details) {
        uiScope.launch {
            withContext(Dispatchers.IO) {
                database.insert(details)
            }
            _navigateToPutFragment.postValue(true)
        }
    }
}