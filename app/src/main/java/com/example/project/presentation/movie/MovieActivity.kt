package com.example.project.presentation.movie

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
import com.example.project.databinding.ActivityMovieBinding
import com.example.project.presentation.di.core.Injector
import javax.inject.Inject

class MovieActivity : AppCompatActivity() {
    @Inject
    lateinit var factory: MovieViewModelFactory
    private lateinit var movieViewModel: MovieViewModel
    private lateinit var binding: ActivityMovieBinding
    private lateinit var adapter: MovieAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_movie)
        (application as Injector).createMoviesSubComponenet()
            .inject(this)
        movieViewModel = ViewModelProvider(this,factory)
            .get(MovieViewModel::class.java)
       initRecyclerView()
    }
    //two function
    private fun initRecyclerView(){
        binding.movierecyclerview.layoutManager = LinearLayoutManager(this)
        adapter = MovieAdapter()
        binding.movierecyclerview.adapter = adapter
        displayPopularMovies()
    }
    private fun displayPopularMovies(){
        binding.movieprogressBar.visibility = View.VISIBLE
        val resposeLiveData = movieViewModel.getMovies()
        resposeLiveData.observe(this, Observer {
            if(it!=null){
                adapter.setList(it)
                adapter.notifyDataSetChanged()
                binding.movieprogressBar.visibility = View.GONE
            }else{
                binding.movieprogressBar.visibility = View.GONE
                Toast.makeText(applicationContext,"Data not found",Toast.LENGTH_LONG).show()
            }

        })
    }
}