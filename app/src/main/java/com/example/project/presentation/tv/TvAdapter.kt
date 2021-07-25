package com.example.project.presentation.tv

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.project.R
import com.example.project.databinding.ListItemBinding
import com.example.project.model.Movie
import com.example.project.model.Tv
import com.example.project.presentation.movie.MyViewHolder

class TvAdapter:RecyclerView.Adapter<MytvViewHolder>() {
    private val tvlist = ArrayList<Tv>()
    fun setList(tv:List<Tv>){
        tvlist.clear()
        tvlist.addAll(tv)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MytvViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding:ListItemBinding = DataBindingUtil.inflate(layoutInflater,R.layout.list_item,parent,false)
        return MytvViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MytvViewHolder, position: Int) {
       // holder.bind()
        holder.bind(tvlist[position])
    }

    override fun getItemCount(): Int {
        return tvlist.size
    }


}
class MytvViewHolder(val binding: ListItemBinding):RecyclerView.ViewHolder(binding.root){
    fun bind(tv: Tv){
        binding.titleTextView.text = tv.originalName
        binding.descriptionTextView.text = tv.overview
        val posterUrl = "https://image.tmdb.org/t/p/w500"+tv.posterPath
        Glide.with(binding.imageView.context)
            .load(posterUrl)
            .into(binding.imageView)
    }
}