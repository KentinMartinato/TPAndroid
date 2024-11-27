package com.example.thekapplication

import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface TmdbAPI {
    @GET("trending/movie/week")
    suspend fun lastmovies(@Query("api_key") apikey: String): TMDBMovieResult

    @GET("movie/{id}?append_to_response=credits")
    suspend fun detailfilm(
        @Path("id") id: String,
        @Query("api_key") apikey:String):FilmDetail

    @GET("trending/tv/week")
    suspend fun lastseries(@Query("api_key") apikey: String): TMDBSerieResult

    @GET("tv/{id}?append_to_response=credits")
    suspend fun detailserie(
        @Path("id") id: String,
        @Query("api_key") apikey: String): SerieDetail

    @GET("trending/person/week")
    suspend fun lastactor(@Query("api_key")apikey: String): TMDBActorResult

    @GET("search/movie")
    suspend fun searchmovie(
        @Query("api_key") apikey: String,
        @Query("query") name: String) : TMDBMovieResult

    @GET("search/tv")
    suspend fun searchserie(
        @Query("api_key") apikey: String,
        @Query("query") name: String) : TMDBSerieResult

    @GET("search/person")
    suspend fun searchactor(
        @Query("api_key") apikey: String,
        @Query("query") name: String) : TMDBActorResult
}