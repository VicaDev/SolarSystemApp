package com.vicadev.solarsystemapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.vicadev.solarsystemapp.ui.model.MoonsScreen
import com.vicadev.solarsystemapp.ui.model.PlanetsScreen
import com.vicadev.solarsystemapp.ui.model.SolarSystemScreen
import com.vicadev.solarsystemapp.ui.theme.SolarSystemAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SolarSystemAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    val navigationController = rememberNavController()
                    NavHost(navController = navigationController, startDestination = "solarSystem") {
                        composable("solarSystem") { SolarSystemScreen(navigationController) }
                        composable("planets") { PlanetsScreen(navigationController) }
                        composable("moons") { MoonsScreen(navigationController)}
                    }
                }
            }
        }
    }
}