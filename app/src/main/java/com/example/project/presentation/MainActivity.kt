package com.example.project.presentation

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.project.R
import com.example.project.databinding.ActivityMainBinding
import com.example.project.presentation.movie.MovieActivity
import com.example.project.presentation.tv.TvActivity

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)

        binding.movieButton.setOnClickListener {
            val intent = Intent(this,MovieActivity::class.java)
            startActivity(intent)
        }
        binding.tvButton.setOnClickListener {
            val intent = Intent(this,TvActivity::class.java)
            startActivity(intent)
        }
    }
}
//In clean architecture we always use public interface to communicate between components.