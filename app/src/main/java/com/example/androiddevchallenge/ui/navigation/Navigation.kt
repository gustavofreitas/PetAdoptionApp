package com.example.androiddevchallenge.ui.navigation

import androidx.navigation.NavHostController
import androidx.navigation.compose.navigate
import com.example.androiddevchallenge.ui.navigation.Destinations.detail

object Destinations {
    const val home = "home"
    const val detail = "detail"

    object DetailArgs {
        const val taskId = "taskId"
    }
}

class Actions(navController: NavHostController) {
    val openDetail: (String) -> Unit = { message ->
        navController.navigate("$detail/$message")
    }
    val navigateBack: () -> Unit = {
        navController.popBackStack()
    }
}