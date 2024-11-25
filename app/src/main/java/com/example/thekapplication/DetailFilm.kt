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
import androidx.navigation.compose.currentBackStackEntryAsState
import coil.compose.AsyncImage
import com.example.thekapplication.ui.theme.TheKApplicationTheme
@Composable
fun PageDetail(onClick: () -> Unit){
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
fun Detailing(id: Int, modifier: Modifier = Modifier, viewModel: MainViewModel, navController: NavHostController) {

    val details by viewModel.details.collectAsState()
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination
    var active by remember { mutableStateOf(false) }
    var searchText by remember { mutableStateOf("") }
    viewModel.getDetail(id)

    if (details.isEmpty()) {
        Text(
            text = "Chargement...",
            fontSize = 35.sp,
            lineHeight = 80.sp,
        )
    } else {

        Scaffold(
            modifier = Modifier.fillMaxSize(),
        ) { innerPadding ->
            LazyColumn(
                modifier = modifier
                    .fillMaxSize()
                    .padding(innerPadding)
            ) {
                items(details) { detail ->
                    Column(modifier = Modifier.fillMaxWidth()) {
                        AsyncImage(
                            model = "https://image.tmdb.org/t/p/original" + detail.poster_path,
                            contentDescription = null,
                            modifier = Modifier.align(Alignment.CenterHorizontally)
                        )
                        Text(
                            text = detail.original_title,
                            fontSize = 35.sp,
                            lineHeight = 40.sp,
                            modifier = Modifier.align(Alignment.CenterHorizontally)
                        )
                    }
                }
            }
        }
    }
}