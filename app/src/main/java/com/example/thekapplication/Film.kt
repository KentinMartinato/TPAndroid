package com.example.thekapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SearchBar
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavDestination.Companion.hasRoute
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import coil.compose.AsyncImage
import com.example.thekapplication.ui.theme.TheKApplicationTheme
import kotlinx.serialization.Serializable

@Composable
fun PageFilm(onClick: () -> Unit){

    Column (modifier = Modifier.fillMaxWidth()) {
        Spacer(
            modifier = Modifier.height(120.dp)
        )
        Button(onClick = onClick) {
            Text("<-")
        }
    }
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Greeting(name: String, modifier: Modifier = Modifier, viewModel: MainViewModel, navController: NavHostController) {

    val movies by viewModel.movies.collectAsState()
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination
    var active by remember { mutableStateOf(false) }
    var searchText by remember { mutableStateOf("") }

    if (movies.isEmpty()) viewModel.getFilmInitaux()

    Scaffold(modifier = Modifier.fillMaxSize(),
        bottomBar = {
            NavigationBar {
                NavigationBarItem(
                    icon = {
                        Image(
                            painterResource(id = R.drawable.film_icon_png_36_1323125910),
                            contentDescription = "Logo film",
                            modifier = Modifier.size(40.dp),
                        )
                    },
                    label = { Text("Films") },
                    selected = currentDestination?.hasRoute<Films>() == true,
                    onClick = { navController.navigate(Films()) })
                NavigationBarItem(
                    icon = {
                        Image(
                            painterResource(id = R.drawable.movie_stream_tv_series_512_1666241017),
                            contentDescription = "Logo series",
                            modifier = Modifier.size(30.dp),
                        )
                    },
                    label = { Text("Series") },
                    selected = currentDestination?.hasRoute<Series>() == true,
                    onClick = { navController.navigate(Series()) })
                NavigationBarItem(
                    icon = {
                        Image(
                            painterResource(id = R.drawable.actor_512_668263753),
                            contentDescription = "Logo Acteur",
                            modifier = Modifier.size(30.dp),
                        )
                    },
                    label = { Text("Acteurs") },
                    selected = currentDestination?.hasRoute<Acteurs>() == true,
                    onClick = { navController.navigate(Acteurs()) })
            }
        },
        topBar = {
            SearchBar(
                query = searchText,
                onQueryChange = { searchText = it },
                onSearch = { viewModel.getFilm(it) },
                active = active,
                onActiveChange = { active = false },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {}
        }) { innerPadding ->
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            modifier = modifier
                .fillMaxSize()
                .padding(innerPadding),
            contentPadding = PaddingValues(8.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            items(movies) { movie ->
                Column(modifier = Modifier.fillMaxWidth()) {
                   Button(onClick = {navController.navigate(DetailFilm())}) { AsyncImage(
                        model = "https://image.tmdb.org/t/p/original" + movie.poster_path,
                        contentDescription = null,
                    )}

                    Text(
                        text = movie.original_title,
                        fontSize = 35.sp,
                        lineHeight = 40.sp,
                        modifier = Modifier.align(Alignment.CenterHorizontally)
                    )

                    Text(
                        text = movie.release_date,
                        fontSize = 35.sp,
                        lineHeight = 40.sp,
                        modifier = Modifier.align(Alignment.CenterHorizontally)
                    )
                }
            }
        }
    }
}