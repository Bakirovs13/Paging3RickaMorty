package com.example.paging3rickamorty.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import com.example.paging3rickamorty.network.ApiService
import com.example.paging3rickamorty.paging.RickAndMortyPagingSource
import dagger.hilt.android.lifecycle.HiltViewModel
import java.security.PrivateKey
import javax.inject.Inject

@HiltViewModel
class MainViewModel
    @Inject constructor(private val apiService:ApiService):ViewModel(){

        val listData = Pager(PagingConfig(pageSize = 1)){
            RickAndMortyPagingSource(apiService)
        }.flow.cachedIn(viewModelScope)

    }
