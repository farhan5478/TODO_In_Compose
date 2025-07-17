package com.appvibe.todo.presentation.dashBoard.index

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet
import androidx.constraintlayout.compose.Dimension
import com.appvibe.todo.R
import com.appvibe.todo.domain.Category
import com.appvibe.todo.data.Dummy
import com.appvibe.todo.domain.TodoItem
import com.appvibe.todo.presentation.components.DropDownMenuModal
import com.appvibe.todo.presentation.components.SearchTextField
import com.appvibe.todo.ui.theme.Dimens
import com.appvibe.todo.ui.theme.Gray21
import com.appvibe.todo.ui.theme.Gray91
import com.appvibe.todo.ui.theme.TODOTheme
import com.appvibe.todo.ui.theme.Violet
import com.appvibe.todo.ui.theme.White
import com.appvibe.todo.ui.theme.White80
import com.appvibe.todo.utils.withAlpha


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

        val activeList = Dummy.todoList().filter { !it.isCompleted }
        val completedList = Dummy.todoList().filter { it.isCompleted }

        LazyColumn(modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight(),) {
            items(activeList) { item ->
                TodoListItem(item = item, onItemClick = {})
                Spacer(modifier = Modifier.height(12.dp))
            }
        }

        if (completedList.isNotEmpty()) {
            DropDownMenuModal(onMenuItemSelected = {

            }, menuList = Dummy.menuItemList())

            Spacer(modifier = Modifier.height(Dimens.marginMedium))

            LazyColumn(modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight(),) {
                items(completedList) { item ->
                    TodoListItem(item = item, onItemClick = {})
                    Spacer(modifier = Modifier.height(12.dp))
                }
            }
        }


    }


}


@Composable
fun TodoListItem(item: TodoItem, onItemClick: (TodoItem) -> Unit) {
    Card(
        onClick = { onItemClick(item) },
        modifier = Modifier
            .fillMaxWidth()
            .height(80.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp),
        colors = CardDefaults.cardColors(containerColor = Gray21),
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(Dimens.marginMedium),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                painter = painterResource(R.drawable.ic_ellipse),
                contentDescription = "",
                modifier = Modifier
                    .fillMaxHeight()
                    .fillMaxWidth(0.06f),
                tint = Color.Unspecified
            )

            Column(
                modifier = Modifier
                    .fillMaxHeight()
                    .weight(1f)
                    .padding(start = 10.dp),
                verticalArrangement = Arrangement.SpaceBetween
            ) {

                val constraints = ConstraintSet {
                    val todoDate = createRefFor("todoDate")
                    val category = createRefFor("category")
                    val priority = createRefFor("priority")

                    constrain(todoDate) {
                        start.linkTo(parent.start)
                        top.linkTo(parent.top)
                        bottom.linkTo(parent.bottom)
                        width = Dimension.percent(0.5f)
                    }

                    constrain(priority) {
                        end.linkTo(parent.end)
                        top.linkTo(parent.top)
                        bottom.linkTo(parent.bottom)
                        width = Dimension.value(50.dp)
                        height = Dimension.value(35.dp)
                    }

                    constrain(category) {
                        end.linkTo(priority.start, margin = 5.dp)
                        top.linkTo(parent.top)
                        bottom.linkTo(parent.bottom)
                        width = Dimension.wrapContent
                        height = Dimension.value(35.dp)
                    }


                }

                Text(
                    text = item.taskDescription,
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f),
                    color = White80,
                    style = MaterialTheme.typography.titleMedium,
                    textAlign = TextAlign.Start,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )

                ConstraintLayout(
                    constraintSet = constraints,
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f)
                ) {
                    Text(
                        text = item.todoDate.toString(),
                        modifier = Modifier.layoutId("todoDate"),
                        color = Color.LightGray,
                        style = MaterialTheme.typography.titleSmall,
                        textAlign = TextAlign.Start,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )

                    Surface(
                        modifier = Modifier.layoutId("priority"),
                        shape = RoundedCornerShape(5.dp),
                        color = Color.Transparent,
                        contentColor = White80,
                        border = BorderStroke(1.dp, color = Violet)
                    ) {
                        Row(
                            modifier = Modifier.fillMaxSize(),
                            horizontalArrangement = Arrangement.SpaceEvenly,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Icon(
                                painter = painterResource(R.drawable.ic_flag),
                                contentDescription = "Timer",
                                modifier = Modifier.height(30.dp)
                            )

                            Text(
                                text = item.priority.toString(),
                                color = Gray91,
                                style = MaterialTheme.typography.titleSmall
                            )

                        }
                    }

                    Surface(
                        modifier = Modifier.layoutId("category"),
                        shape = RoundedCornerShape(5.dp),
                        color = Color(item.category.color),
                    ) {
                        Row(
                            modifier = Modifier
                                .wrapContentWidth()
                                .padding(horizontal = 8.dp),
                            horizontalArrangement = Arrangement.SpaceAround,
                            verticalAlignment = Alignment.CenterVertically,
                        ) {

                            Icon(
                                painter = painterResource(item.category.icon),
                                contentDescription = "Category Icon",
                                modifier = Modifier.size(20.dp),
                                tint = Color(item.category.color).withAlpha(0x99)
                            )

                            Spacer(modifier = Modifier.width(5.dp))

                            Text(
                                text = item.category.name,
                                color = MaterialTheme.colorScheme.onBackground,
                                style = MaterialTheme.typography.titleSmall
                            )

                        }
                    }


                }


            }


        }
    }
}

@Preview
@Composable
fun TodoListItemPreview() {
    TODOTheme {
        val item = TodoItem(
            id = 1,
            taskDescription = "Sample Task",
            priority = 1,
            category = Category(
                id = 1,
                name = "Work",
                color = 0xFFFFCC80.toInt(),
                icon = R.drawable.baseline_clock
            ),
            createdDate = java.sql.Date(System.currentTimeMillis()),
            isCompleted = false,
            todoDate = java.sql.Date(System.currentTimeMillis())
        )
        TodoListItem(item = item, onItemClick = {})
    }

}


@Preview
@Composable
fun ListScreenPreview() {
    ListScreen(paddingValues = PaddingValues())
}
