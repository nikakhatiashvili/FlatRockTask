package com.example.flatrocktask.ui.model.popular

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class PopularMovies(
    val page: Int,
    val results: List<PopularResult>
): Parcelable {

}