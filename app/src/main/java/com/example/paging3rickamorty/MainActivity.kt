package com.example.paging3rickamorty

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.paging3rickamorty.adapter.RickMortyPagedAdapter
import com.example.paging3rickamorty.databinding.ActivityMainBinding
import com.example.paging3rickamorty.viewModel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    private val listAdapter by lazy {RickMortyPagedAdapter()}
    private val viewModel:MainViewModel by lazy{ ViewModelProvider(this)[MainViewModel::class.java]
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupRV()
        loadingData()

    }

    private fun loadingData() {
        lifecycleScope.launch{
            viewModel.listData.collect {
                listAdapter.submitData(it)
            }
        }
    }

    private fun setupRV() {
        binding.mainRV.apply {
            layoutManager = StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL)
            adapter = listAdapter
            setHasFixedSize(true)
        }
    }
}