package com.appvibe.todo.presentation.home

import android.widget.Toolbar
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.input.key.Key.Companion.Home
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import coil3.compose.AsyncImage
import coil3.request.ImageRequest
import coil3.request.crossfade
import com.appvibe.todo.R
import com.appvibe.todo.ui.theme.TODOTheme

/*@Composable
fun Home(navController: NavHostController) {

    Scaffold(modifier = Modifier.fillMaxSize(), topBar = {

    }, bottomBar = {
        BottomNavigationBar(navController = navController)
    }) {

    }


}*/

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
            AsyncImage(model = ImageRequest.Builder(LocalContext.current).data("").crossfade(true).build(),
                placeholder = painterResource(R.drawable.ic_launcher_foreground),
                contentDescription = "Profile",
                contentScale = ContentScale.Crop,
                modifier = Modifier.clip(CircleShape),

                )

        })
    }
    )
}


@Preview
@Composable
fun PreviewHome() {
    TODOTheme {
        Toolbar()
//        Home(navController = rememberNavController())
    }
}