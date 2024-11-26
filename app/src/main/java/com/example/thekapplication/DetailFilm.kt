package com.example.thekapplication

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import coil.compose.AsyncImage
@OptIn(ExperimentalMaterial3Api::class)
@Suppress
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
fun Detailing(id: String, modifier: Modifier = Modifier, viewModel: MainViewModel, navController: NavHostController) {

    val details by viewModel.detail.collectAsState()
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination
    var active by remember { mutableStateOf(false) }
    var searchText by remember { mutableStateOf("") }
    viewModel.getDetail(id)

    if (details == null) {
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
                item {
                    // Vérification de la nullité de 'details'
                    details!!.poster_path?.let { posterPath ->
                        AsyncImage(
                            model = "https://image.tmdb.org/t/p/original$posterPath",
                            contentDescription = null,
                        )
                    }

                    details!!.original_title?.let { title ->
                        Text(
                            text = title,
                            fontSize = 35.sp,
                            lineHeight = 40.sp,
                        )
                    }
                }
            }
        }
    }
}