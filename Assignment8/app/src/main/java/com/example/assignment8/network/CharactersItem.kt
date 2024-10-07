package com.example.assignment8.network

import kotlinx.parcelize.Parcelize
import android.os.Parcelable


@Parcelize
data class CharactersItem(
    val birthdate: String,
    val children: List<String>,
    val fullName: String,
    val hogwartsHouse: String,
    val image: String,
    val index: Int,
    val interpretedBy: String,
    val nickname: String
): Parcelable