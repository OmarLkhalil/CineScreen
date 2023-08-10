package com.mobilebreakero.moviesapp

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.lifecycle.LifecycleOwner
import androidx.navigation.NavType
import androidx.navigation.navArgument
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.google.accompanist.navigation.animation.composable
import com.google.accompanist.navigation.animation.rememberAnimatedNavController
import com.mobilebreakero.common.domain.model.VideoItemModel
import com.mobilebreakero.details.DetailsScreen
import com.mobilebreakero.home.screens.HomeScreen
import com.mobilebreakero.search.SearchScreen

@Composable
fun MainScreen(lifecycleOwner: LifecycleOwner) {
    Scaffold() { contentPadding ->
        MainNavHost(Modifier.padding(contentPadding), lifecycleOwner)
    }
}

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun MainNavHost(modifier: Modifier, lifecycleOwner: LifecycleOwner) {

    val navController = rememberAnimatedNavController()

    AnimatedNavHost(navController = navController, startDestination = Screen.Home.route) {

        composable(route = Screen.Home.route) {
            HomeScreen(navController = navController)
        }

        composable(route = Screen.Search.route) {
            SearchScreen(navController = navController)
        }

        composable(
            route = "DetailsScreen?movieId={movieId}",
            arguments = listOf(
                navArgument("movieId") {
                    type = NavType.StringType
                }
            )
        ) { backStackEntry ->
            val arguments = requireNotNull(backStackEntry.arguments)
            DetailsScreen(
                navController = navController,
                movieId = arguments.getString("movieId") ?: "",
                lifecycle = lifecycleOwner
            )
        }
    }
}

sealed class Screen(val route: String, val Icon: ImageVector? = null) {
    data object Home : Screen("HomeScreen", Icon = Icons.Filled.Home)
    data object Search : Screen("SearchScreen", Icon = Icons.Filled.Search)
    data object Details : Screen("DetailsScreen")
}