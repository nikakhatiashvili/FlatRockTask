package com.example.flatrocktask.ui.upcoming

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.flatrocktask.databinding.TopRatedMoviesBinding
import com.example.flatrocktask.ui.callbackinterface.ClickListener
import com.example.flatrocktask.ui.model.popular.PopularResult
import com.example.flatrocktask.ui.model.upcoming.UpcomingResult

class UpcomingAdapter(private val clickListener: ClickListener):RecyclerView.Adapter<UpcomingAdapter.ViewHolder>() {
    var data:List<UpcomingResult> = emptyList()
        set(value) {
            field = value
            notifyDataSetChanged()
        }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UpcomingAdapter.ViewHolder {
        return ViewHolder(TopRatedMoviesBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }
    override fun onBindViewHolder(holder: UpcomingAdapter.ViewHolder, position: Int) {
        holder.bind()
    }
    override fun getItemCount()=data.size
    inner class ViewHolder(private val binding:TopRatedMoviesBinding):RecyclerView.ViewHolder(binding.root), View.OnClickListener {
        private lateinit var currentData:UpcomingResult
        fun bind(){
            currentData = data[adapterPosition]
            binding.root.setOnClickListener(this)
            binding.apply {
                characterTxt.text = currentData.title
                Glide.with(itemView.context).load("https://image.tmdb.org/t/p/w500/" + currentData.poster_path).into(binding.characterImg)
            }
        }
        override fun onClick(v: View?) {
           clickListener.onUpcoming(currentData)
        }
    }
}