package com.example.thekapplication

import android.content.res.Configuration
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
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavDestination.Companion.hasRoute
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import coil.compose.AsyncImage
import com.example.thekapplication.ui.theme.TheKApplicationTheme
@Composable
fun PageActeur(onClick: () -> Unit){
    Column (modifier = Modifier.fillMaxWidth()){
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
fun Acting(name:String, modifier: Modifier = Modifier, viewModel: MainViewModel, navController: NavHostController) {

    val actors by viewModel.actors.collectAsState()
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination
    var active by remember { mutableStateOf(false) }
    var searchText by remember { mutableStateOf("") }

    if (actors.isEmpty()) viewModel.getActeurInitiaux()

    val configuration = LocalConfiguration.current
    val portrait = configuration.orientation == Configuration.ORIENTATION_PORTRAIT

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
                onSearch = { viewModel.getActor(it) },
                active = active,
                onActiveChange = { active = false },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {}
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
            items(actors) { actor ->
                Column(modifier = Modifier.fillMaxWidth()) {
                    AsyncImage(
                        model = "https://image.tmdb.org/t/p/original" + actor.profile_path,
                        contentDescription = null,
                        modifier = Modifier.fillMaxWidth()
                            .height(if (portrait)250.dp else 180.dp)
                            .clip(shape = androidx.compose.foundation.shape.RoundedCornerShape(12.dp)),
                        contentScale = ContentScale.Crop
                    )
                    Text(
                        text = actor.original_name,
                        fontSize = if (portrait) 18.sp else 16.sp,
                        lineHeight = 24.sp,
                        modifier = Modifier.align(Alignment.CenterHorizontally)
                            .padding(top = 8.dp)
                    )
                }
            }
        }
    }
}