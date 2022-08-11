package com.example.paging3rickamorty.network

import com.example.paging3rickamorty.models.ResponseApi
import com.example.paging3rickamorty.utils.Constant.END_POINT
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET(END_POINT)
    suspend fun getCharacterList(
        @Query("page")page:Int, ):Response<ResponseApi>
}