package com.example.paging3rickamorty.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.paging3rickamorty.databinding.ItemLitBinding
import com.example.paging3rickamorty.models.ResponseApi

class RickMortyPagedAdapter: PagingDataAdapter<ResponseApi.Result, RickMortyPagedAdapter.ViewHolder>(diffCallback) {


    inner class ViewHolder(val binding:ItemLitBinding):
    RecyclerView.ViewHolder(binding.root){

    }

    companion object{
        val diffCallback = object : DiffUtil.ItemCallback<ResponseApi.Result>(){

            override fun areItemsTheSame(
                oldItem: ResponseApi.Result,
                newItem: ResponseApi.Result
            ): Boolean {
               return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(
                oldItem: ResponseApi.Result,
                newItem: ResponseApi.Result
            ): Boolean {
               return  oldItem== newItem

            }

        }
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentItem = getItem(position)
       with(holder.binding){
        characterName.text = currentItem!!.name
          val imageLink = currentItem.image

           //coroutine image loader - coil
           characterImage.load(imageLink){
               crossfade(true)
               crossfade(1000)
           }
       }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var binding = ItemLitBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(binding)
    }
}