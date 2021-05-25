package com.example.orpilla_agoraph.data

import com.example.orpilla_agoraph.model.ProfileItem
import com.example.orpilla_agoraph.model.UserItem
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {

    @GET("users?since=0")
    fun getUsers(): Call<List<UserItem>>

    @GET("users/{login}")
    fun getUserProfile(@Path("login") login: String): Call<ProfileItem>

    companion object {
        private const val API_URL = "https://api.github.com/"

        fun create(): ApiService {

            val retrofit = Retrofit.Builder()
                .baseUrl(API_URL)
                .addConverterFactory(
                    MoshiConverterFactory.create(
                        Moshi.Builder()
                            .add(KotlinJsonAdapterFactory()).build()
                    )
                )
                .build()

            return retrofit.create<ApiService>(ApiService::class.java)
        }
    }
}