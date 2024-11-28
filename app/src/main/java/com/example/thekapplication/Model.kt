package com.example.thekapplication


import kotlin.time.Duration

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
    val results: List<FilmDetail>
)
data class FilmDetail(
    val adult: Boolean,
    val backdrop_path: String,
    val genres : List<Genre>,
    val homepage: String,
    val id: Int,
    val original_language: String,
    val original_title: String,
    val overview: String,
    val popularity: Double,
    val poster_path: String?,
    val release_date: String,
    val credits : credits
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

data class TMDBDetailSerieResult(
    val page : Int,
    val results: List<SerieDetail>
)

data class SerieDetail(
    val adult: Boolean,
    val backdrop_path: String,
    val created_by : List<Createur>,
    val first_air_date: String,
    val genre : List<Genre>,
    val homepage: String,
    val id: Int,
    val in_production: Boolean,
    val last_air_date: String,
    val name: String,
    val number_of_episode: Int,
    val number_of_season: Int,
    val overview: String,
    val popularity: Double,
    val poster_path: String,
    val credits: credits
)

data class Createur(
    val id: Int,
    val credit_id: String,
    val name: String,
    val original_name: String,
    val gender: Int,
    val profile_path: String

)
data class PlaylistResult(
    val page : Int,
    val results: List<Playlist>
)
data class Playlist(
    val checksum: String,
    val collaborative: Boolean,
    val cover: String,
    val creation_date: String,
    val creator: Creator,
    val description: String,
    val duration: Int,
    val fans: Int,
    val id: Int,
    val is_loved_track: Boolean,
    val link: String,
    val md5_image: String,
    val nb_tracks: Int,
    val picture_type: String,
    val `public`: Boolean,
    val share: String,
    val title: String,
    val tracklist: String,
    val tracks: Tracks,
    val type: String
)

data class Creator(
    val id: Int,
    val name: String,
    val tracklist: String,
    val type: String
)

data class Tracks(
    val checksum: String,
    val `data`: List<Data>
)

data class Data(
    val album: Album,
    val artist: Artist,
    val duration: Int,
    val explicit_content_cover: Int,
    val explicit_content_lyrics: Int,
    val explicit_lyrics: Boolean,
    val id: Long,
    val isrc: String,
    val link: String,
    val md5_image: String,
    val preview: String,
    val rank: Int,
    val readable: Boolean,
    val time_add: Int,
    val title: String,
    val title_short: String,
    val title_version: String,
    val type: String
)

data class Album(
    val cover: String,
    val id: Int,
    val md5_image: String,
    val title: String,
    val tracklist: String,
    val type: String,
    val upc: String
)

data class Artist(
    val id: Int,
    val link: String,
    val name: String,
    val tracklist: String,
    val type: String
)