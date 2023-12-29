package fr.dev.majdi.boxotop.core.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import fr.dev.majdi.boxotop.feature_movie_cards.presentation.MovieCardsScreen
import fr.dev.majdi.boxotop.feature_movie_detail.presentation.MovieDetailScreen
import fr.dev.majdi.boxotop.feature_splash.presentation.SplashScreen

/**
 * Created by Majdi RABEH on 28/12/2023.
 * Email m.rabeh.majdi@gmail.com
 */
@Composable
fun NavGraph(navController: NavHostController) {
    NavHost(
        navController = navController, startDestination = NavRoute.SplashScreen.path
    ) {
        addSplashScreen(navController, this)
        addMovieCardsScreen(navController, this)
        addMovieDetailScreen(navController, this)
    }
}

private fun addSplashScreen(
    navController: NavHostController, navGraphBuilder: NavGraphBuilder
) {
    navGraphBuilder.composable(route = NavRoute.SplashScreen.path) {
        SplashScreen(navigateToMovieCardsScreen = {
            navController.navigate(NavRoute.MovieCards.path)
        })
    }
}

private fun addMovieCardsScreen(
    navController: NavHostController, navGraphBuilder: NavGraphBuilder
) {
    navGraphBuilder.composable(route = NavRoute.MovieCards.path) {
        MovieCardsScreen(navigateToMovieDetailScreen = {
            navController.navigate(NavRoute.MovieDetail.withArgs(it))
        })
    }
}

private fun addMovieDetailScreen(
    navController: NavHostController, navGraphBuilder: NavGraphBuilder
) {
    navGraphBuilder.composable(
        route = NavRoute.MovieDetail.withArgsFormat(
            NavRoute.MovieDetail.id
        ), arguments = listOf(navArgument(NavRoute.MovieDetail.id) {
            type = NavType.StringType
        })
    ) { navBackStackEntry ->
        val args = navBackStackEntry.arguments
        val id = args?.getString(NavRoute.MovieDetail.id).toString()
        MovieDetailScreen(id = id, popBackStack = { navController.popBackStack() })
    }
}