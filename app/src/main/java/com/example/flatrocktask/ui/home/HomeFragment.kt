package com.example.flatrocktask.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResult
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.flatrocktask.R
import com.example.flatrocktask.databinding.FragmentHomeBinding
import com.example.flatrocktask.ui.callbackinterface.ClickListener
import com.example.flatrocktask.ui.model.toprated.MovieResult
import com.example.flatrocktask.ui.model.popular.PopularResult
import com.example.flatrocktask.ui.model.upcoming.UpcomingResult
import com.example.flatrocktask.ui.popular.PopularAdapter
import com.example.flatrocktask.ui.popular.PopularViewModel
import com.example.flatrocktask.ui.upcoming.UpcomingAdapter
import com.example.flatrocktask.ui.upcoming.UpcomingViewModel

class HomeFragment : Fragment() {
    private var binding:FragmentHomeBinding? = null
    private val viewModel:HomeViewModel by viewModels()
    private val popularViewModel:PopularViewModel by viewModels()
    private val upcomingViewModel:UpcomingViewModel by viewModels()
    private lateinit var adapter:HomeAdapter
    private lateinit var popularAdapter:PopularAdapter
    private lateinit var upcomingAdapter:UpcomingAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        if (binding == null){
            binding = FragmentHomeBinding.inflate(inflater,container,false)
            upcomingViewModel.load()
            viewModel.load()
            popularViewModel.load()
            bind()
        }
        return binding?.root
    }

    private fun bind(){
        adapter = HomeAdapter(object :ClickListener{
            override fun onClick(data: MovieResult) {

                setFragmentResult("requestKey", bundleOf("bundleKey" to data))

                findNavController().navigate(R.id.action_navigation_home_to_detailFragment)
            }
            override fun onButton(data: PopularResult) {
            }
            override fun onUpcoming(data: UpcomingResult) {
            }
        })
        popularAdapter = PopularAdapter(object :ClickListener{
            override fun onClick(data: MovieResult) {
            }

            override fun onButton(data: PopularResult) {
                setFragmentResult("requestKeys", bundleOf("bundleKeys" to data))
                findNavController().navigate(R.id.action_navigation_home_to_detailFragment)
            }

            override fun onUpcoming(data: UpcomingResult) {
            }

        })
        upcomingAdapter =  UpcomingAdapter(object :ClickListener{
            override fun onClick(data: MovieResult) {
            }
            override fun onButton(data: PopularResult) {
            }
            override fun onUpcoming(data: UpcomingResult) {
                    setFragmentResult("requestKeyUp", bundleOf("bundleKeyUp" to data))
                findNavController().navigate(R.id.action_navigation_home_to_detailFragment)
            }

        })


        binding?.recyclerview?.adapter = adapter
        binding?.recyclerview?.layoutManager = LinearLayoutManager(requireContext(),LinearLayoutManager.HORIZONTAL,false)
        //
        binding?.recyclerviewForPopular?.adapter = popularAdapter
        binding?.recyclerviewForPopular?.layoutManager = LinearLayoutManager(requireContext(),LinearLayoutManager.HORIZONTAL,false)
        //
        binding?.recyclerviewForUpcoming?.adapter = upcomingAdapter
        binding?.recyclerviewForUpcoming?.layoutManager = LinearLayoutManager(requireContext(),LinearLayoutManager.HORIZONTAL,false)
        //
        upcomingViewModel.upComing.observe(viewLifecycleOwner){
            upcomingAdapter.data = it
        }
        //
        popularViewModel.mostPopular.observe(viewLifecycleOwner){
            popularAdapter.data = it
        }
        //
        viewModel.topRatedMovies.observe(viewLifecycleOwner){
            adapter.data = it
        }
    }

}