package com.example.flatrocktask.ui.model.upcoming

import android.os.Parcelable
import com.example.flatrocktask.ui.model.popular.PopularResult
import kotlinx.parcelize.Parcelize

@Parcelize
data class UpcomingMovies(
    val page: Int,
    val results: List<UpcomingResult>
): Parcelable {

}