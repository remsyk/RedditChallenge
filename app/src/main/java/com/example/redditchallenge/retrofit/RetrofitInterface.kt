package com.example.krakg.retrofit

import com.example.redditchallenge.models.RickMortyModel
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query


interface RetrofitInterface {

    //@Headers("API-Key: Bar", "API-Sign: Pong")
    @GET("character")
    fun getCharacters(): Observable<RickMortyModel>


    //@Headers("API-Key: Bar", "API-Sign: Pong")
    @GET("character")
    fun getGenderCharacters(@Query("gender") request:String): Observable<RickMortyModel>
}