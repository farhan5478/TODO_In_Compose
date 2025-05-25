package com.appvibe.todo.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.LargeFloatingActionButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.appvibe.todo.R

enum class NavigationBarItem(val label: Int, val selectedIcon: Int, val unselectedIcon: Int) {
    Index(
        label = R.string.action_index,
        selectedIcon = R.drawable.baseline_home,
        unselectedIcon = R.drawable.outline_home
    ),
    CALENDAR(
        label = R.string.action_calender,
        selectedIcon = R.drawable.baseline_calendar,
        unselectedIcon = R.drawable.outline_calendar
    ),
    FOCUS(
        label = R.string.action_focus,
        selectedIcon = R.drawable.baseline_clock,
        unselectedIcon = R.drawable.outline_clock
    ),
    PROFILE(
        label = R.string.action_Profile,
        selectedIcon = R.drawable.baseline_person,
        unselectedIcon = R.drawable.outline_person
    )
}

@Composable
fun BottomAppBarWithCenterFab(
    onItemSelected: (NavigationBarItem) -> Unit, onFabClicked: () -> Unit
) {

    var selectedItem by remember {
        mutableStateOf(NavigationBarItem.Index)
    }

    Box(
        Modifier
            .fillMaxWidth()
            .height(88.dp)
            .background(MaterialTheme.colorScheme.background)
    ) {
        Row(
            Modifier
                .fillMaxWidth()
                .align(Alignment.BottomCenter),
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically
        ) {
            NavigationBarItem.entries.forEachIndexed { index, item ->
                if (index == 2) Spacer(Modifier.width(56.dp)) // Space for FAB
                val isSelected = selectedItem == item
                NavigationBarItem(
                    selected = isSelected, onClick = {
                        selectedItem = item
                        onItemSelected.invoke(item)
                    }, icon = {
                        Icon(
                            painter = painterResource(if (isSelected) item.selectedIcon else item.unselectedIcon),
                            contentDescription = stringResource(item.label),
                            tint = Color.LightGray
                        )
                    }, label = {
                        Text(
                            text = stringResource(item.label),
                            color = MaterialTheme.colorScheme.onBackground,
                            style = MaterialTheme.typography.labelSmall
                        )
                    }, alwaysShowLabel = true, colors = NavigationBarItemDefaults.colors(
                        selectedIconColor = Color.White,
                        selectedTextColor = Color.White,
                        indicatorColor = Color.Transparent,
                        unselectedIconColor = Color.LightGray,
                        unselectedTextColor = Color.LightGray
                    )
                )
            }
        }
        // Center FAB
        LargeFloatingActionButton(
            onClick = onFabClicked,
            containerColor = MaterialTheme.colorScheme.primary,
            contentColor = MaterialTheme.colorScheme.onBackground,
            modifier = Modifier
                .size(56.dp)
                .align(Alignment.TopCenter)
                .offset(y = (-25).dp), // Half of FAB size to overlap
            elevation = FloatingActionButtonDefaults.elevation(defaultElevation = 6.dp),
            shape = CircleShape
        ) {
            Icon(Icons.Default.Add, contentDescription = stringResource(R.string.action_add))
        }
    }

}

