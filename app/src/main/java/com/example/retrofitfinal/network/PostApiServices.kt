package com.example.retrofitfinal.network


import com.example.retrofitfinal.model.Posts
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET


private const val BASE_URL = "https://jsonplaceholder.typicode.com/"
private val retrofit = Retrofit.Builder()
    .addConverterFactory(GsonConverterFactory.create())
    .baseUrl(BASE_URL)
    .build()

interface PostApiServices {
    @GET("posts")
    suspend fun getPosts(): List<Posts>
}


object PostApi {
    val retrofitService: PostApiServices by lazy {
        retrofit.create(PostApiServices::class.java)
    }
}
