package com.appvibe.todo.presentation.home.navigation

import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import com.appvibe.todo.R
import com.appvibe.todo.presentation.home.components.BottomItemModel

object OnBottomNavigationRoute {
    const val HOME = "home"
    const val CALENDER = "calender"
    const val FOCUS = "focus"
    const val PROFILE = "profile"
}



class BottomItemNavigationActions(private val navController: NavHostController) {

    fun navigateTo(bottomItemModel: BottomItemModel) {
        navController.navigate(route = bottomItemModel.route) {
            popUpTo(navController.graph.findStartDestination().id) {
                saveState = true
            }
            launchSingleTop = true
            restoreState = true

        }
    }

}

