package com.example.flatrocktask.ui.model.toprated

import android.os.Parcelable
import com.example.flatrocktask.ui.model.toprated.MovieResult
import kotlinx.parcelize.Parcelize

@Parcelize
data class TopRatedMovies(
    val page: Int,
    val results: List<MovieResult>
):Parcelable{

}