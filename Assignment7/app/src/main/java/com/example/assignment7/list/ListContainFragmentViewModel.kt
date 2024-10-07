package com.example.assignment7.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.assignment7.database.ColorItem

class ListContainFragmentViewModel(colorList: List<ColorItem>): ViewModel() {

    private val _colors = MutableLiveData<List<ColorItem>>()
    val colors: LiveData<List<ColorItem>>
        get() = _colors

    init {
        _colors.value = colorList
    }

}