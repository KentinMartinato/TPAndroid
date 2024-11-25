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

data class TMDBDetailFilmResult(
    val page : Int,
    val results: List<Detail>
)
data class Detail(
    val adult: Boolean,
    val backdrop_path: String,
    val genres : List<Genre>,
    val homepage: String,
    val id: Int,
    val original_language: String,
    val original_title: String,
    val overview: String,
    val popularity: Double,
    val poster_path: String,
    val release_date: String,
    val credits : List<credits>
)

data class Genre(
    val id: Int,
    val name: String
)

data class credits(
    val cast: List<cast>,
    val crew: List<crew>
)


data class cast(
    val adult: Boolean,
    val gender: Int,
    val id: Int,
    val know_for_department: String,
    val name: String,
    val original_name: String,
    val popularity: Double,
    val profile_path: String,
    val cast_id: Int,
    val character: String,
    val credit_id: String,
    val order: Int
)

data class crew(
    val adult: Boolean,
    val gender: Int,
    val id: Int,
    val know_for_department: String,
    val name: String,
    val original_name: String,
    val popularity: Double,
    val profile_path: String,
    val credit_id: String,
    val department: String,
    val job: String
)
