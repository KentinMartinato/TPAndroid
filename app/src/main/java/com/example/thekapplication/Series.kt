package com.example.thekapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.thekapplication.ui.theme.TheKApplicationTheme
@Composable
fun PageSerie(onClick: () -> Unit){
    Column (modifier = Modifier.fillMaxWidth()){
        Spacer(
            modifier = Modifier.height(120.dp)
        )
        Button(onClick = onClick) {
            Text("<-")
        }
    }
}
@Composable
fun Sering(name:String, modifier: Modifier = Modifier, viewModel: MainViewModel) {

    val series by viewModel.series.collectAsState()

    if (series.isEmpty()) viewModel.getSerieInitiaux()

    LazyColumn(modifier=modifier) {
        items(series){
            serie ->
        Column(modifier=Modifier.fillMaxWidth()) {
            AsyncImage(
                model = "https://image.tmdb.org/t/p/original" + serie.poster_path,
                contentDescription = null,
                modifier=Modifier.align(Alignment.CenterHorizontally)
            )
            Text(text=serie.original_name,
                fontSize = 35.sp,
                lineHeight = 40.sp,
                modifier=Modifier.align(Alignment.CenterHorizontally)
            )
            Text(text = serie.first_air_date,
                fontSize = 35.sp,
                lineHeight = 40.sp,
                modifier=Modifier.align(Alignment.CenterHorizontally))
        }
        }
    }
}