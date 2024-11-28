package com.example.thekapplication

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplicationtest.playlistjson
import com.squareup.moshi.Moshi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import kotlin.jvm.internal.Intrinsics.Kotlin

class MainViewModel : ViewModel() {
    val movies = MutableStateFlow<List<Movie>>(listOf())

    val series = MutableStateFlow<List<Serie>>(listOf())

    val actors = MutableStateFlow<List<Actor>>(listOf())

    val detailF = MutableStateFlow<FilmDetail?>(null)

    val detailS = MutableStateFlow<SerieDetail?>(null)

    val apikey = "8696f09c5f82a2e663ba12dd2f4321c5"

    val plays = MutableStateFlow<List<Playlist>>(listOf())


    val retrofit = Retrofit.Builder()
        .baseUrl("https://api.themoviedb.org/3/")
        .addConverterFactory(MoshiConverterFactory.create())
        .build()
        .create(TmdbAPI::class.java)

    fun getFilmInitaux() {
        viewModelScope.launch {
            movies.value = retrofit.lastmovies(apikey).results
        }
    }

    fun getSerieInitiaux() {
        viewModelScope.launch {
            series.value = retrofit.lastseries(apikey).results
        }
    }

    fun getActeurInitiaux() {
        viewModelScope.launch {
            actors.value = retrofit.lastactor(apikey).results
        }
    }

    fun getFilm(name: String) {
        viewModelScope.launch {
            movies.value = retrofit.searchmovie(apikey, name).results
        }
    }

    fun getDetailFilm(id: String) {
        viewModelScope.launch {
            detailF.value = retrofit.detailfilm(id, apikey)
        }
    }

    fun getSerie(name: String) {
        viewModelScope.launch {
            series.value = retrofit.searchserie(apikey, name).results
        }
    }

    fun getDetailSerie(id: String) {
        viewModelScope.launch {
            detailS.value = retrofit.detailserie(id, apikey)
        }
    }

    fun getActor(name: String) {
        viewModelScope.launch {
            actors.value = retrofit.searchactor(apikey, name).results
        }
    }

    fun fetchPlaylist(): Playlist {
        val moshi = Moshi.Builder().build()
        return moshi.adapter(Playlist::class.java).fromJson(playlistjson)!!
    }

    fun getPlaylist() {
        viewModelScope.launch {

        }
    }
}
