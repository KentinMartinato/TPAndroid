package com.example.thekapplication

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
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
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavDestination.Companion.hasRoute
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import coil.compose.AsyncImage

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PagePlaylist(onClick: () -> Unit){
    Text(text = "")
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Playing(name: String, modifier: Modifier = Modifier, viewModel: MainViewModel, navController: NavHostController){

    val plays by viewModel.plays.collectAsState()
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination
    var active by remember { mutableStateOf(false) }
    var searchText by remember { mutableStateOf("") }

    if (plays.isEmpty()) viewModel.getPlaylist()

    val configuration = LocalConfiguration.current
    val portrait = configuration.orientation == Configuration.ORIENTATION_PORTRAIT

    Scaffold(modifier = Modifier.fillMaxSize(),
        bottomBar = {
            if (portrait) {
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
                    NavigationBarItem(
                        icon = {},
                        label = { Text("PlaylistPage") },
                        selected = currentDestination?.hasRoute<PlaylistPage>() == true,
                        onClick = { navController.navigate(PlaylistPage()) })
                }
            }
        },
        topBar = {
            if (portrait) {
                SearchBar(
                    query = searchText,
                    onQueryChange = { searchText = it },
                    onSearch = { viewModel.getActor(it) },
                    active = active,
                    onActiveChange = { active = false },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                ) {}
            }
        }) { innerPadding ->
        LazyVerticalGrid(
            columns = GridCells.Fixed(if (portrait)2 else 3),
            modifier = modifier
                .fillMaxSize()
                .padding(innerPadding),
            contentPadding = PaddingValues(8.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
        }
    }
}