package com.example.androiddevchallenge.ui.navigation

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigate
import com.example.androiddevchallenge.domain.entity.Pet
import com.example.androiddevchallenge.ui.detail.DetailScreen
import com.example.androiddevchallenge.ui.home.HomeScreen
import com.example.androiddevchallenge.ui.navigation.Destinations.DetailArgs.pet
import com.example.androiddevchallenge.ui.navigation.Destinations.detail

object Destinations {
    const val home = "home"
    const val detail = "detail"

    object DetailArgs {
        const val pet = "pet_model"
    }
}

class Actions(navController: NavHostController) {
    val openDetail: (Pet) -> Unit = { data ->
        with(navController) {
            currentBackStackEntry?.arguments?.putParcelable(pet, data)
            navigate(detail)
        }
    }
    val navigateBack: () -> Unit = {
        navController.popBackStack()
    }
}

@ExperimentalFoundationApi
@Composable
fun DefineNavigation(navController: NavHostController, actions: Actions) {
    NavHost(navController = navController, startDestination = Destinations.home) {
        composable(Destinations.home) { HomeScreen(openDetails = actions.openDetail) }
        composable(
            route = detail,
        ) {
            navController.previousBackStackEntry?.arguments?.getParcelable<Pet>(pet)?.let {
                DetailScreen(
                    data = it,
                    navigateBack = actions.navigateBack
                )
            }
        }
    }
}