package com.example.flatrocktask.ui.network

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.create

object ApiService {

    val topRatedService by lazy { createTopRatedService() }

    private val loggingInterceptor = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY }



    private fun createTopRatedService():TopRatedNetwork {
        val retrofitBuilder = Retrofit.Builder()
        retrofitBuilder.baseUrl("https://api.themoviedb.org/3/")
        retrofitBuilder.client(
            OkHttpClient().newBuilder()
                .addInterceptor(loggingInterceptor)
                .build()
        )
        retrofitBuilder.addConverterFactory(moshiConvertor())
        return retrofitBuilder.build().create(TopRatedNetwork::class.java)
    }

    private fun moshiConvertor()=
        MoshiConverterFactory.create(
            Moshi.Builder().addLast(KotlinJsonAdapterFactory())
                .build()
        )
}