package com.example.thekapplication

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PagePlaylist(onClick: () -> Unit){
    Text(text = "")
}
@Composable
fun Playing(name: String, modifier: Modifier = Modifier, viewModel: MainViewModel){
    val plays by viewModel.plays.collectAsState()
    if (plays.isEmpty()) viewModel.getPlaylist()
}