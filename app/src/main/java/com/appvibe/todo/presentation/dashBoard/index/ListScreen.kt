package com.appvibe.todo.presentation.dashBoard.index

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.appvibe.todo.data.Dummy
import com.appvibe.todo.domain.TodoItem
import com.appvibe.todo.presentation.components.DropDownMenuModal
import com.appvibe.todo.presentation.components.SearchTextField
import com.appvibe.todo.ui.theme.Dimens
import com.appvibe.todo.ui.theme.Gray21

@Composable
fun ListScreen(paddingValues: PaddingValues) {

    var searchTxt by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .padding(
                top = paddingValues.calculateTopPadding(),
                bottom = paddingValues.calculateBottomPadding(),
                start = Dimens.paddingMedium,
                end = Dimens.paddingMedium
            )
            .fillMaxSize(),
    ) {
        SearchTextField(value = searchTxt, onValueChange = { searchTxt = it })

        Spacer(modifier = Modifier.height(Dimens.marginMedium))

        DropDownMenuModal(onMenuItemSelected = {

        }, menuList = Dummy.menuItemList())

        Spacer(modifier = Modifier.height(Dimens.marginMedium))


    }


}


@Composable
private fun TodoListItem(item: TodoItem, onItemClick: (TodoItem) -> Unit) {
    Card(
        onClick = { onItemClick(item) },
        modifier = Modifier
            .fillMaxWidth()
            .height(72.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp),
        colors = CardDefaults.cardColors(containerColor = Gray21),
    ) {
        Row(modifier = Modifier.fillMaxSize(), verticalAlignment = Alignment.CenterVertically) {
            Icon()

        }
    }
}

@Preview
@Composable
fun ListScreenPreview() {
    ListScreen(paddingValues = PaddingValues())
}
