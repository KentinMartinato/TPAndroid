package com.example.thekapplication

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SearchBar
import androidx.compose.material3.SearchBarDefaults

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
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.thekapplication.ui.theme.TheKApplicationTheme
import kotlinx.serialization.Serializable
import androidx.navigation.NavDestination.Companion.hasRoute
import androidx.navigation.toRoute
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.combine

@Serializable class Profile
@Serializable class Films
@Serializable class Series
@Serializable class Acteurs
@Serializable data class DetailFilm(val id : String)
@Serializable data class DetailSerie(val id: String)
@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       // enableEdgeToEdge()
        val viewmodel : MainViewModel by viewModels()
        setContent {
            TheKApplicationTheme {

                val navController = rememberNavController()
                val navBackStackEntry by navController.currentBackStackEntryAsState()
                val currentDestination = navBackStackEntry?.destination
                var active by remember { mutableStateOf(false) }
                var searchText by remember {  mutableStateOf("") }

                Scaffold(modifier = Modifier.fillMaxSize())
                { innerPadding ->
                    NavHost(navController = navController, startDestination = Profile()
                    ){
                        composable<Profile> {
                            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                                Pdp(
                                    name = "Android",
                                    modifier = Modifier.padding(innerPadding)
                                )
                                Sociaux(
                                    name = "Android",
                                    modifier = Modifier.padding(innerPadding)
                                )
                                DemarrerButton(onClick = {navController.navigate(Films())})
                            }
                        }
                        composable<Films> {
                            Greeting(
                            name = "",
                            modifier = Modifier.padding(innerPadding),
                            viewmodel,
                            navController
                            )
                            PageFilm(onClick = { navController.navigate(Profile()) })
                        }
                        composable<Series> {
                            Sering(
                                name = "",
                                modifier = Modifier.padding(innerPadding),
                                viewmodel,
                                navController
                            )
                            PageSerie(onClick = { navController.navigate(Profile()) })
                        }
                        composable<Acteurs> {
                            Acting(
                                name = "",
                                modifier = Modifier.padding(innerPadding),
                                viewmodel,
                                navController
                            )
                            PageActeur(onClick = { navController.navigate(Profile()) })
                        }
                        composable<DetailFilm> {backStackEntry ->
                            val moviedetail: DetailFilm = backStackEntry.toRoute()
                            DetailingF(
                                id = moviedetail.id,
                                modifier = Modifier.padding(innerPadding),
                                viewmodel,
                                navController
                            )
                            PageDetailFilm(onClick = {navController.navigate(Films())})
                        }
                        composable<DetailSerie> {backStackEntry ->
                            val seriedetail: DetailSerie = backStackEntry.toRoute()
                            DetailingS(
                                id = seriedetail.id,
                                modifier = Modifier.padding(innerPadding),
                                viewmodel,
                                navController
                            )
                            PageDetailSerie(onClick = {navController.navigate(Series())})
                        }
                        }
                    }
            }
        }
    }
}

@Composable
fun Pdp(name: String, modifier: Modifier = Modifier) {
    Column(modifier = Modifier.fillMaxWidth())
    {
        Spacer(
            modifier = Modifier.height(80.dp)
        )
        Image(
            painterResource(id = R.drawable.photo_de_profil),
            contentDescription = "Photo de profil",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(200.dp)
                .align(Alignment.CenterHorizontally)
                .clip(CircleShape),
            )
        Text(
            text = "Kentin Martinato",
            fontSize = 35.sp,
            lineHeight = 80.sp,
            modifier = Modifier.align(Alignment.CenterHorizontally),
        )
        Text(
            text = "Alternant en informatique appliqué à la santé",
            fontSize = 15.sp,
            lineHeight = 1.sp,
            modifier = Modifier.align(Alignment.CenterHorizontally),
        )
        Text(
            text = "Ecole d'ingénieur ISIS - INU Champolion",
            fontSize = 15.sp,
            lineHeight = 20.sp,
            modifier = Modifier.align(Alignment.CenterHorizontally),
        )
        Spacer(
            modifier = Modifier.height(80.dp)
        )
    }
}

@Composable
fun Sociaux(name: String, modifier: Modifier = Modifier) {
    Column(modifier = Modifier.fillMaxWidth()) {
        Row(modifier = Modifier.align(Alignment.CenterHorizontally)) {
            Image(
                painterResource(id = R.drawable.envelope_mail_icon_vector_illustration_2867715824),
                contentDescription = "Logo mail",
                modifier = Modifier
                    .size(40.dp),
            )
            Text(
                text = " kentin.martinato@etud.univ-jfc.fr",
                fontSize = 15.sp,
                lineHeight = 40.sp,
            )
        }
        Row(modifier = Modifier.align(Alignment.CenterHorizontally)) {
            Image(
                painterResource(id = R.drawable.logo_linkedin_icon_1536_3964382085),
                contentDescription = "Logo linkedin",
                modifier = Modifier
                    .size(20.dp),
            )
            Text(
                text = " https://www.linkedin.com/in/kentin-martinato",
                fontSize = 15.sp,
                lineHeight = 20.sp,
            )
        }
        Spacer(
            modifier = Modifier.height(80.dp)
        )
    }

}

@Composable
fun DemarrerButton(onClick: () -> Unit) {
    Button(onClick = onClick){
        Text("Démarrer")
    }
}



