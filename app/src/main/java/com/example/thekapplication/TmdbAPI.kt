package com.example.thekapplication

import retrofit2.http.GET
import retrofit2.http.Query

interface TmdbAPI {
    @GET("trending/movie/week")
    suspend fun lastmovies(@Query("api_key") apikey: String): TMDBMovieResult
}