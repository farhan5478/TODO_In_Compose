package com.appvibe.todo.presentation.home.navigation

import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import com.appvibe.todo.R

object OnBottomNavigationRoute {
    const val HOME = "home"
    const val CALENDER = "calender"
    const val FOCUS = "focus"
    const val PROFILE = "profile"
}

data class BottomItemModel(
    val route: String, val selectedIcon: Int, val unselectedIcon: Int, val label: Int
)

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

val BottomNavItemsList = listOf(
    BottomItemModel(
        route = OnBottomNavigationRoute.HOME,
        selectedIcon = R.drawable.baseline_home,
        unselectedIcon = R.drawable.outline_home,
        label = R.string.action_index
    ), BottomItemModel(
        route = OnBottomNavigationRoute.CALENDER,
        selectedIcon = R.drawable.baseline_calendar,
        unselectedIcon = R.drawable.outline_calendar,
        label = R.string.action_calender
    ), BottomItemModel(
        route = OnBottomNavigationRoute.FOCUS,
        selectedIcon = R.drawable.baseline_clock,
        unselectedIcon = R.drawable.outline_clock,
        label = R.string.action_focus
    ), BottomItemModel(
        route = OnBottomNavigationRoute.PROFILE,
        selectedIcon = R.drawable.baseline_person,
        unselectedIcon = R.drawable.outline_person,
        label = R.string.action_Profile
    )
)