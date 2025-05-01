package com.appvibe.todo.presentation.onBoading

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.appvibe.todo.R
import kotlinx.coroutines.delay

@Composable
fun IntroScreen(navController: NavHostController = rememberNavController()) {

    LaunchedEffect(Unit) {
        delay(2500)
        navController.navigate(OnBoardDestination.STEP_1)
    }

    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Image(painter = painterResource(R.drawable.ic_todo), contentDescription = null)
    }
}


@Preview
@Composable
fun PreviewIntroScreen() {
    IntroScreen()
}