package com.dgist.dsite.ui.root

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.dgist.dsite.ui.feature.post.PostScreen
import com.dgist.dsite.ui.feature.post.info.PostInfoScreen
import com.dgist.dsite.ui.feature.post.insert.PostInsertScreen

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
        composable(
            route =  NavGroup.Post.POST_INFO
        ) { backStackEntry ->
            PostInfoScreen(
                navController = navController,
                id = backStackEntry.arguments?.getString("id")?.toInt()!!
            )
        }

        composable(
            route = NavGroup.Post.POST_INSERT
        ) {
            PostInsertScreen(
                navController = navController
            )
        }
    }

}