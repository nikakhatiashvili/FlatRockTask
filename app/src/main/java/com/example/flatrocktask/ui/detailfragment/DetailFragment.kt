package com.example.flatrocktask.ui.detailfragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResultListener
import com.bumptech.glide.Glide
import com.example.flatrocktask.databinding.DetailFragmentBinding
import com.example.flatrocktask.ui.model.toprated.MovieResult
import com.example.flatrocktask.ui.model.popular.PopularResult
import com.example.flatrocktask.ui.model.upcoming.UpcomingResult

class DetailFragment:Fragment() {
    private lateinit var viewModel: DetailViewModel
    private var binding:DetailFragmentBinding? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setFragmentResultListener("requestKey"){ requestKey, bundle ->
            val data = bundle.getParcelable<MovieResult>("bundleKey")
            binding?.apply {
                titleTxt.text = data?.title
                adultTXt.text = data?.adult.toString()
                releaseDateTXT.text = data?.release_date
                popularityTxt.text = data?.overview
                Glide.with(requireContext()).load("https://image.tmdb.org/t/p/w500/" + data?.poster_path).into(binding!!.characterImg)
            }
        }
        setFragmentResultListener("requestKeys"){ requestKey, bundle ->
            val data = bundle.getParcelable<PopularResult>("bundleKeys")
            binding?.apply {
                titleTxt.text = data?.title
                adultTXt.text = data?.adult.toString()
                releaseDateTXT.text = data?.release_date
                popularityTxt.text = data?.overview
                Glide.with(requireContext()).load("https://image.tmdb.org/t/p/w500/" + data?.poster_path).into(binding!!.characterImg)
            }
        }

        setFragmentResultListener("requestKeyUp"){ requestKey, bundle ->
            val data = bundle.getParcelable<UpcomingResult>("bundleKeyUp")
            binding?.apply {
                titleTxt.text = data?.title
                adultTXt.text = data?.adult.toString()
                releaseDateTXT.text = data?.release_date
                popularityTxt.text = data?.overview
                Glide.with(requireContext()).load("https://image.tmdb.org/t/p/w500/" + data?.poster_path).into(binding!!.characterImg)
            }
        }

    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        if (binding == null){
            binding = DetailFragmentBinding.inflate(inflater,container,false)
        }
        return binding?.root
    }
}