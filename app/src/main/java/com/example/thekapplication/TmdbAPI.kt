package com.example.thekapplication

import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface TmdbAPI {
    @GET("trending/movie/week")
    suspend fun lastmovies(@Query("api_key") apikey: String): TMDBMovieResult
    @GET("trending/tv/week")
    suspend fun lastseries(@Query("api_key") apikey: String): TMDBSerieResult
    @GET("trending/person/week")
    suspend fun lastactor(@Query("api_key")apikey: String): TMDBActorResult
    @GET("search/movie")
    suspend fun searchmovie(
        @Query("api_key") apikey: String,
        @Query("query") name: String) : TMDBMovieResult
}