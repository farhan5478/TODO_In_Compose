package com.appvibe.todo.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowDropDown
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MenuDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.appvibe.todo.presentation.model.DropDown
import com.appvibe.todo.ui.theme.Gray21
import com.appvibe.todo.ui.theme.White

@Composable
fun DropDownMenuModal(
    onMenuItemSelected: (DropDown) -> Unit,
    menuList: List<DropDown>
) {
    var expand by remember { mutableStateOf(false) }
    Box(
        modifier = Modifier
            .wrapContentSize()
            .background(color = Gray21, shape = RoundedCornerShape(8.dp))
            .clickable { expand = true },
        contentAlignment = Alignment.Center,
    ) {
        Row(modifier = Modifier.padding(16.dp), verticalAlignment = Alignment.CenterVertically) {
            val selectedMenuName = menuList.filter { it.isSelected }[0].itemName
            Text(
                text = selectedMenuName,
                color = MaterialTheme.colorScheme.onBackground,
                style = MaterialTheme.typography.labelLarge
            )
            Spacer(modifier = Modifier.width(12.dp))
            Icon(
                imageVector = Icons.Outlined.ArrowDropDown,
                contentDescription = "Dropdown",
                tint = White
            )
        }
        DropdownMenu(
            expanded = expand,
            onDismissRequest = {
                expand = false
            },
            containerColor = Gray21,
            shape = RoundedCornerShape(8.dp)
        ) {
            menuList.filter { !it.isSelected }.forEach { label ->
                DropdownMenuItem(
                    text = { Text(text = label.itemName) },
                    onClick = {
                        onMenuItemSelected(label)
                        expand = false
                    },
                    colors = MenuDefaults.itemColors(textColor = MaterialTheme.colorScheme.onBackground),
                )
            }
        }
    }

}