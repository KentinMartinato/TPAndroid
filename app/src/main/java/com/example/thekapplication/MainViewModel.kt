package com.example.thekapplication

import android.util.Log
import android.util.Log.v
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class MainViewModel : ViewModel(){
    val movies = MutableStateFlow<List<Movie>>(listOf())

    val series = MutableStateFlow<List<Serie>>(listOf())

    val actors = MutableStateFlow<List<Actor>>(listOf())

    val details = MutableStateFlow<List<Detail>>(listOf())

    val apikey = "8696f09c5f82a2e663ba12dd2f4321c5"

    val append = "credits"

    val retrofit = Retrofit.Builder()
        .baseUrl("https://api.themoviedb.org/3/")
        .addConverterFactory(MoshiConverterFactory.create())
        .build()
        .create(TmdbAPI::class.java)

    fun getFilmInitaux(){
        viewModelScope.launch{
            movies.value = retrofit.lastmovies(apikey).results
        }
    }
    fun getSerieInitiaux(){
        viewModelScope.launch {
            series.value = retrofit.lastseries(apikey).results
        }
    }
    fun getActeurInitiaux(){
        viewModelScope.launch {
            actors.value = retrofit.lastactor(apikey).results
        }
    }
    fun getFilm(name : String){
        viewModelScope.launch {
            movies.value = retrofit.searchmovie(apikey,name).results
        }
    }
    fun getDetail(id : Int){
        viewModelScope.launch {
            details.value = retrofit.detaillee(id,apikey,append).results
            Log.v("test", details.value.toString())
        }
    }
    fun getSerie(name : String){
        viewModelScope.launch {
            series.value = retrofit.searchserie(apikey,name).results
        }
    }
    fun getActor(name: String){
        viewModelScope.launch {
            actors.value = retrofit.searchactor(apikey,name).results
        }
    }
}