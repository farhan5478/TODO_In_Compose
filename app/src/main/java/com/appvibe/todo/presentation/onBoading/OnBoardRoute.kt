package com.appvibe.todo.presentation.onBoading

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

object OnBoardDestination {
    const val INTRO = "intro"
    const val STEP_1 = "step_1"
    const val STEP_2 = "step_2"
    const val STEP_3 = "step_3"
    const val START_SCREEN = "start_screen"

}

@Composable
fun OnBoardNavGraph(navController: NavHostController) {
    NavHost(navController = navController, startDestination = OnBoardDestination.INTRO) {
        composable(route = OnBoardDestination.INTRO) {
            IntroScreen(navController)
        }
        composable(route = OnBoardDestination.STEP_1) {
            OnBoardScreenOne(navController)
        }
        composable(route = OnBoardDestination.STEP_2) {
            OnBoardScreenTwo(navController)
        }
        composable(route = OnBoardDestination.STEP_3) {
            OnBoardScreenThree(navController)
        }
    }


}