package com.example.paging3rickamorty.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.paging3rickamorty.models.ResponseApi
import com.example.paging3rickamorty.network.ApiService

class RickAndMortyPagingSource (private val api:ApiService):
    PagingSource<Int, ResponseApi.Result>() {

    override fun getRefreshKey(state: PagingState<Int, ResponseApi.Result>): Int? {
      return null
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, ResponseApi.Result> {
       return try {

           val currentPage = params.key?:1
           val response =api.getCharacterList(currentPage)
           val data = response.body()?.results?: emptyList()
           val responseData = mutableListOf<ResponseApi.Result>()
           responseData.addAll(data)

           LoadResult.Page(
               data = responseData,
               prevKey = if(currentPage==1) null else -1,
               nextKey = currentPage.plus(1)

           )




       }catch (e:Exception){
          LoadResult.Error(e)
       }
    }


}