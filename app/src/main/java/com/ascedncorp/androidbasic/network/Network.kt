package com.ascedncorp.androidbasic.network

import com.ascedncorp.androidbasic.model.UserListResponse
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

class Network {

    fun getUsers(): Call<UserListResponse> = getReqresRestApi().getUsers()

    private fun getReqresRestApi(): ReqresRestApi {
        val baseUrl = "https://reqres.in/api"
        return getRetrofit(baseUrl).create(ReqresRestApi::class.java)
    }

    private fun getRetrofit(baseUrl: String): Retrofit =
        Retrofit.Builder()
            .baseUrl(if (baseUrl.endsWith("/")) baseUrl else "$baseUrl/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
}

interface ReqresRestApi {
    @GET("users")
    fun getUsers(): Call<UserListResponse>
}
