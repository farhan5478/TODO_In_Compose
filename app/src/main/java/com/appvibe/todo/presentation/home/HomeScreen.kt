package com.appvibe.todo.presentation.home

import android.widget.Toolbar
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import coil3.compose.AsyncImage
import com.appvibe.todo.R
import com.appvibe.todo.ui.theme.TODOTheme

@Composable
fun Home(navController: NavHostController) {

    Scaffold(modifier = Modifier.fillMaxSize(), topBar = {

    }, bottomBar = {
        BottomNavigationBar(navController = navController)
    }) {

    }


}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Toolbar() {
    TopAppBar(title = {
        Text(text = stringResource(R.string.txt_index))
    }, modifier = Modifier.fillMaxWidth(), navigationIcon = {
        IconButton(onClick = { /*TODO*/ }, content = {
            Icon(
                painter = painterResource(id = R.drawable.sort),
                contentDescription = "Navigation Drawer"
            )
        })
    }, actions = {
        IconButton(onClick = { /*TODO*/ }, content = {
            AsyncImage()
        })
    }
    )
}


@Preview
@Composable
fun PreviewHome() {
    TODOTheme {
        Home(navController = rememberNavController())
    }
}