package com.example.assignment8.screens.imagescreen

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.CreationExtras
import com.example.assignment8.network.CharactersItem
import kotlin.reflect.KClass

class ImageViewModelFactory(
    private val property: CharactersItem,
    private val app: Application
):ViewModelProvider.Factory {
    @Suppress("unchecked_cast")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ImageViewModel::class.java)) {
            return ImageViewModel(property, app) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}