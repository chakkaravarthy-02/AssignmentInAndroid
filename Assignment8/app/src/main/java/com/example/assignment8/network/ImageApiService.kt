package com.example.assignment8.network

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import kotlinx.coroutines.Deferred
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

enum class ImageApiStatus{
    LOADING,DONE,ERROR
}

private const val BASE_URL = "https://potterapi-fedeperin.vercel.app/en/"

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .addCallAdapterFactory(CoroutineCallAdapterFactory())
    .baseUrl(BASE_URL)
    .build()
interface ImageApiService {
    @GET("characters")
    fun getMeme(): Deferred<List<CharactersItem>>
}

object ImageApi{
    val retrofitService: ImageApiService by lazy {
        retrofit.create(ImageApiService::class.java)
    }
}