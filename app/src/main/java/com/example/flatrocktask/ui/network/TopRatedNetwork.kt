package com.example.flatrocktask.ui.network

import com.example.flatrocktask.ui.model.popular.PopularMovies
import com.example.flatrocktask.ui.model.toprated.TopRatedMovies
import com.example.flatrocktask.ui.model.upcoming.UpcomingMovies
import retrofit2.Response
import retrofit2.http.GET

interface TopRatedNetwork {

    @GET("movie/top_rated?api_key=7f39984135c9621c058c979457e46b42")
    suspend fun getAllTopRatedMovies(): Response<TopRatedMovies>

    @GET("movie/popular?api_key=7f39984135c9621c058c979457e46b42")
    suspend fun getPopular(): Response<PopularMovies>

    @GET("movie/upcoming?api_key=7f39984135c9621c058c979457e46b42")
    suspend fun getUpcoming(): Response<UpcomingMovies>

}