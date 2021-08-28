package com.example.flatrocktask.ui.model.popular

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class PopularResult(
    val adult:Boolean,
    val backdrop_path:String,
    val id:Int,
    val original_language:String,
    val original_title:String,
    val overview:String,
    val popularity:Double,
    val poster_path:String,
    val release_date:String,
    val title:String,
    val vote_average:Double,

): Parcelable {

}