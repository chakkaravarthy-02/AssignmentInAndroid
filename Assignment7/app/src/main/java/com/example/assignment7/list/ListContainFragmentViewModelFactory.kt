package com.example.assignment7.list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.assignment7.database.ColorItem

class ListContainFragmentViewModelFactory(private val colorList: List<ColorItem>) :ViewModelProvider.Factory{
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(ListContainFragmentViewModel::class.java)){
            return ListContainFragmentViewModel(colorList) as T
        }else{
            throw IllegalArgumentException("Unknown class")
        }
    }
}