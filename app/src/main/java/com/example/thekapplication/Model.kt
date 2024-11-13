package com.example.thekapplication

data class TMDBMovieResult(
    val page: Int,
    val results: List<Movie>
)

data class Movie(
    val backdrop_path: String,
    val id: Int,
    val title: String,
    val original_title: String,
    val overview: String,
    val poster_path: String,
    val media_type: String,
    val adult: Boolean,
    val original_language: String,
    val genre_ids: List<Int>,
    val popularity : Double,
    val release_date: String,
    val video: Boolean,
    val vote_average: Float,
    val vote_count: Int
)



