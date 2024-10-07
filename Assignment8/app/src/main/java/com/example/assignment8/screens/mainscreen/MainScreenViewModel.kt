package com.example.assignment8.screens.mainscreen

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.assignment8.network.CharactersItem
import com.example.assignment8.network.ImageApi.retrofitService
import com.example.assignment8.network.ImageApiStatus
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch

class MainScreenViewModel: ViewModel() {
    private val _status = MutableLiveData<ImageApiStatus>()
    val status: LiveData<ImageApiStatus>
        get() = _status

    private val _response = MutableLiveData<List<CharactersItem>?>()
    val response: LiveData<List<CharactersItem>?>
        get() = _response

    private val _navigateToImage = MutableLiveData<Boolean>()
    val navigateToImage: LiveData<Boolean>
        get() = _navigateToImage

    lateinit var characterBundle: List<CharactersItem>

    private val job = Job()

    private val coroutineScope = CoroutineScope(Dispatchers.Main + job)

    fun startNavigating(){
        _navigateToImage.value = true
    }

    fun doneNavigating(){
        _navigateToImage.value = false
    }

    fun getImageProperties(){
        coroutineScope.launch {
            val getImageProperty = retrofitService.getMeme()
            try{
                _status.value = ImageApiStatus.LOADING
                var listResult = getImageProperty.await()
                if(listResult.isNotEmpty()){
                    _status.value = ImageApiStatus.DONE
                    _response.value = listResult
                }
            }catch (t: Throwable){
                _status.value = ImageApiStatus.ERROR
                _response.value = ArrayList()
            }
        }
    }

    override fun onCleared() {
        super.onCleared()
        job.cancel()
    }

    fun setCharacterDetail(character: List<CharactersItem>) {
        characterBundle = character
    }
}