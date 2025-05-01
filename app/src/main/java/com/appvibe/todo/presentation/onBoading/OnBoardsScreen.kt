package com.appvibe.todo.presentation.onBoading

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.NavController

@Composable
fun BaseScreen(navController: NavController, content: @Composable () -> Unit){
    ConstraintLayout(modifier = Modifier.fillMaxSize()) {
        val (header, footer) = createRefs()

    }

}


@Composable
fun Header(navController: NavController){


}

@Composable
fun Footer(navController: NavController){

}

@Composable
fun OnBoardScreenOne(navController: NavController){

}

@Composable
fun OnBoardScreenTwo(navController: NavController){

}

@Composable
fun OnBoardScreenThree(navController: NavController){

}