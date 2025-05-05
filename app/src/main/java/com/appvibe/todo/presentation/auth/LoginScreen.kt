package com.appvibe.todo.presentation.auth

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.appvibe.todo.R
import com.appvibe.todo.presentation.UserInputField
import com.appvibe.todo.ui.theme.TODOTheme

@Composable
fun LoginScreen(navController: NavController) {
    Column(modifier = Modifier.fillMaxSize().padding(16.dp)){
        UserInputField(R.string.txt_user_name,"Farhan") { txt ->
            println(txt)
        }
    }



}


@Composable
@Preview
fun PreviewLoginScreen() {
    TODOTheme {
        LoginScreen(navController = rememberNavController())
    }
}