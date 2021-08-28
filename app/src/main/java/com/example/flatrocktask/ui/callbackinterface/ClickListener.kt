package com.example.flatrocktask.ui.callbackinterface

import com.example.flatrocktask.ui.model.toprated.MovieResult
import com.example.flatrocktask.ui.model.popular.PopularResult
import com.example.flatrocktask.ui.model.upcoming.UpcomingResult

interface ClickListener {
    fun onClick(data: MovieResult)
    fun onButton(data: PopularResult)
    fun onUpcoming(data:UpcomingResult)
}