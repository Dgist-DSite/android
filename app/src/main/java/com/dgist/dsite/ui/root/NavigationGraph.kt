package com.dgist.dsite.ui.root

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.dgist.dsite.ui.feature.post.PostScreen

@Composable
fun NavigationGraph(
    navController: NavHostController
) {
    NavHost(navController = navController, startDestination = NavGroup.Post.POST) {
        composable(
            route = NavGroup.Post.POST
        ) {
            PostScreen(
                navController = navController
            )
        }
    }

}