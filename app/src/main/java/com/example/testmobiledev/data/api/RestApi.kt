package com.example.testmobiledev.data.api

import com.example.testmobiledev.data.model.ProductResponse
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

object ApiClient {
    private val retrofit = Retrofit.Builder()
        .baseUrl("https://dummyjson.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val api: ProductApi = retrofit.create(ProductApi::class.java)
}

interface ProductApi {
    @GET("product")
    suspend fun getProducts(): ProductResponse
}