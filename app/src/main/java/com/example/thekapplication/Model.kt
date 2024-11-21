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

data class TMDBSerieResult(
    val page: Int,
    val results: List<Serie>
)

data class Serie(
    val backdrop_path: String,
    val id: Int,
    val name: String,
    val original_name: String,
    val overview: String,
    val poster_path: String,
    val media_type: String,
    val adult: Boolean,
    val original_language: String,
    val genre_ids: List<Int>,
    val popularity : Double,
    val first_air_date: String,
    val vote_average: Float,
    val vote_count: Int,
    val origin_country : List<String>
)

data class TMDBActorResult(
    val page : Int,
    val results: List<Actor>
)

data class Actor(
    val id: Int,
    val name : String,
    val original_name: String,
    val media_type: String,
    val adult: Boolean,
    val popularity: Double,
    val gender : Int,
    val know_for_department : String,
    val profile_path : String
)



