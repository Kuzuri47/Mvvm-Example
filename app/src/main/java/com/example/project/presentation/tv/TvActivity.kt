package com.example.project.presentation.tv

import android.media.tv.TvView
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.project.R
import com.example.project.databinding.ActivityTvBinding
import com.example.project.presentation.di.core.Injector
import com.example.project.presentation.movie.MovieAdapter
import javax.inject.Inject

class TvActivity : AppCompatActivity() {
    @Inject
    lateinit var factory: TvViewModelFactory
    private lateinit var tvViewModel: TvViewModel
    private lateinit var binding: ActivityTvBinding
    private lateinit var adapter: TvAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_tv)
        (application as Injector).createTvShowSubComponenet()
            .inject(this)
        tvViewModel = ViewModelProvider(this,factory)
            .get(TvViewModel::class.java)
        initRecyclerView()

    }
    private fun initRecyclerView(){
        binding.tvrecyclerview.layoutManager = LinearLayoutManager(this)
        adapter = TvAdapter()
        binding.tvrecyclerview.adapter = adapter
        displayPopularTvShows()
    }
    private fun displayPopularTvShows(){
        binding.tvprogressBar.visibility = View.VISIBLE
        val resposeLiveData = tvViewModel.getTv()
        resposeLiveData.observe(this, Observer {
            if(it!=null){
                adapter.setList(it)
                adapter.notifyDataSetChanged()
                binding.tvprogressBar.visibility = View.GONE
            }else{
                binding.tvprogressBar.visibility = View.GONE
                Toast.makeText(applicationContext,"Data not found", Toast.LENGTH_LONG).show()
            }

        })
    }
}