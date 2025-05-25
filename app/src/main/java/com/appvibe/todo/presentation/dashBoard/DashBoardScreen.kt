package com.appvibe.todo.presentation.dashBoard

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.appvibe.todo.R
import com.appvibe.todo.presentation.components.BottomAppBarWithCenterFab
import com.appvibe.todo.presentation.components.ChangeStatusBarIconsColor
import com.appvibe.todo.presentation.dashBoard.index.EmptyCheckListScreen
import com.appvibe.todo.ui.theme.TODOTheme

@Composable
fun Home(navController: NavHostController) {

    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    Scaffold(
        modifier = Modifier
            .fillMaxWidth()
            .background(color = MaterialTheme.colorScheme.background),
        bottomBar = {
            BottomAppBarWithCenterFab(onItemSelected = { navigationItem ->

            }, onFabClicked = {

            })

        }, topBar = {
            Toolbar()
        }) { innerPadding ->
        EmptyCheckListScreen(paddingValues = innerPadding)

    }


}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Toolbar() {
    TopAppBar(
        title = {
            Text(
                text = stringResource(R.string.txt_index),
                modifier = Modifier
                    .fillMaxWidth(),
                textAlign = TextAlign.Center, style = MaterialTheme.typography.titleLarge
            )
        },
        modifier = Modifier
            .fillMaxWidth(),
        navigationIcon = {
            IconButton(onClick = { /*TODO*/ }, content = {
                Icon(
                    painter = painterResource(id = R.drawable.sort),
                    contentDescription = "Navigation Drawer"
                )
            })
        },
        actions = {
            IconButton(onClick = { /*TODO*/ }, content = {
                Image(
                    painter = painterResource(id = R.drawable.profile_img),
                    contentDescription = "Need to Upgrade",
                    modifier = Modifier.size(45.dp),
                    contentScale = ContentScale.Crop
                )

            })
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = MaterialTheme.colorScheme.background,
            titleContentColor = MaterialTheme.colorScheme.onBackground,
            actionIconContentColor = MaterialTheme.colorScheme.onBackground,
            navigationIconContentColor = MaterialTheme.colorScheme.onBackground
        )
    )
}


@Preview
@Composable
fun PreviewHome() {
    TODOTheme {
        ChangeStatusBarIconsColor(darkIcons = false)
        Home(navController = rememberNavController())
    }
}