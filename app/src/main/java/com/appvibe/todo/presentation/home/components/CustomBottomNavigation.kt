package com.appvibe.todo.presentation.home.components

import android.R.attr.label
import android.R.id.selectedIcon
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardDefaults.cardElevation
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LargeFloatingActionButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.appvibe.todo.R
import com.appvibe.todo.presentation.home.navigation.OnBottomNavigationRoute

data class BottomItemModel(
    val route: String, val selectedIcon: Int, val unselectedIcon: Int, val label: Int
)

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


@Composable
fun BottomBarItem(itemModel: BottomItemModel) {
    Column(
        modifier = Modifier.size(48.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        val isSelected = remember {
            mutableStateOf(false)
        }

        val painterResource = if (isSelected.value) {
            painterResource(id = itemModel.selectedIcon)
        } else {
            painterResource(id = itemModel.unselectedIcon)
        }

        Icon(
            painter = painterResource,
            contentDescription = stringResource(R.string.action_index),
            modifier = Modifier.size(24.dp)
        )
        Spacer(modifier = Modifier.height(5.dp))
        Text(text = stringResource(itemModel.label), modifier = Modifier.wrapContentWidth())
    }
}

@Composable
fun BottomBar() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(60.dp + 64.dp / 2)
    ) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .height(60.dp)
                .align(Alignment.BottomCenter),
            colors = CardDefaults.cardColors(containerColor = Color.White),
            elevation = CardDefaults.cardElevation(defaultElevation = 8.dp),
            shape = RoundedCornerShape(
                topStart = 24.dp,
                topEnd = 24.dp,
                bottomEnd = 0.dp,
                bottomStart = 0.dp
            )
        ) {
            Row(
                modifier = Modifier.fillMaxSize(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceAround
            )
            {
                BottomBarItem(BottomNavItemsList[0])
                BottomBarItem(BottomNavItemsList[1])
                Spacer(modifier = Modifier.size(64.dp))
                BottomBarItem(BottomNavItemsList[2])
                BottomBarItem(BottomNavItemsList[3])
            }
        }
        LargeFloatingActionButton(
            modifier = Modifier
                .size(64.dp)
                .align(Alignment.TopCenter),
            onClick = {  },
            shape = CircleShape,
            containerColor = Color(0xFF7980FF),
            elevation = FloatingActionButtonDefaults.bottomAppBarFabElevation(defaultElevation = 0.dp)
        ) {
            Icon(
                imageVector = ImageVector.vectorResource(id = R.drawable.ic_back),
                contentDescription = null,
                tint = Color.White,
                modifier = Modifier.size(32.dp)
            )
        }
    }
}


@Composable
@Preview
fun PreviewBottomItem(){
   /*val item = BottomItemModel(
        route = OnBottomNavigationRoute.HOME,
        selectedIcon = R.drawable.baseline_home,
        unselectedIcon = R.drawable.outline_home,
        label = R.string.action_index
    )
    BottomBarItem(itemModel = item)*/
    BottomBar()
}