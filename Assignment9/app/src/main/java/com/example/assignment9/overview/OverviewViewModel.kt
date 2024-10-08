package com.example.assignment9.overview

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.assignment9.network.FlagApi
import com.example.assignment9.network.FlagItem
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

enum class FlagStatus {
    LOADING, DONE, ERROR
}

class OverviewViewModel : ViewModel() {

    private val _properties = MutableLiveData<List<FlagItem>>()
    val properties: LiveData<List<FlagItem>>
        get() = _properties

    private val _status = MutableLiveData<FlagStatus>()
    val status: LiveData<FlagStatus>
        get() = _status

    private val job = Job()
    private val coroutineScope = CoroutineScope(Dispatchers.Main + job)

    init {
        getFlagProperties()
    }

    private fun getFlagProperties() {
        coroutineScope.launch {
            val getFlagPropertiesDeferred = FlagApi.retrofitService.getFlagDetails()
            _status.value = FlagStatus.LOADING
            try {
                val response = getFlagPropertiesDeferred.await()
                _properties.value = response
                _status.value = FlagStatus.DONE
            } catch (t: Throwable) {
                _properties.value = ArrayList()
                _status.value = FlagStatus.ERROR
            }
        }
    }
}