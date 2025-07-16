package com.appvibe.todo.presentation.components

import androidx.annotation.StringRes
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet
import androidx.constraintlayout.compose.Dimension
import com.appvibe.todo.R
import com.appvibe.todo.ui.theme.Black90
import com.appvibe.todo.ui.theme.Gray60
import com.appvibe.todo.ui.theme.TODOTheme
import com.appvibe.todo.ui.theme.White80


@Composable
fun SearchTextField(
    value: String,
    onValueChange: (String) -> Unit
) {
    val constraints = ConstraintSet {
        val searchIcon = createRefFor("searchIcon")
        val searchBar = createRefFor("searchBar")
        val placeHolder = createRefFor("placeHolder")

        constrain(searchIcon) {
            top.linkTo(parent.top)
            bottom.linkTo(parent.bottom)
            start.linkTo(parent.start)
            width = Dimension.value(34.dp)
        }

        constrain(placeHolder) {
            top.linkTo(searchBar.top)
            bottom.linkTo(searchBar.bottom)
            start.linkTo(searchIcon.end, margin = 8.dp)
            end.linkTo(searchBar.end)
            width = Dimension.fillToConstraints
        }

        constrain(searchBar) {
            top.linkTo(parent.top)
            bottom.linkTo(parent.bottom)
            start.linkTo(searchIcon.end, margin = 8.dp)
            end.linkTo(parent.end)
            width = Dimension.fillToConstraints
        }

    }

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(50.dp)
            .background(color = Black90)
            .border(width = 1.dp, color = Gray60)
            .padding(horizontal = 12.dp),
        contentAlignment = Alignment.Center
    ) {

        ConstraintLayout(constraintSet = constraints, modifier = Modifier.fillMaxSize()) {

            if (value.isEmpty()) {
                Text(
                    text = stringResource(R.string.txt_search_task),
                    modifier = Modifier.layoutId("placeHolder"),
                    color = MaterialTheme.colorScheme.onBackground,
                    style = MaterialTheme.typography.bodySmall
                )
            }

            Icon(
                imageVector = Icons.Default.Search,
                contentDescription = "Search Bar",
                modifier = Modifier.layoutId("searchIcon"),
                tint = White80
            )
            BasicTextField(
                value = value,
                onValueChange = onValueChange,
                singleLine = true,
                textStyle = MaterialTheme.typography.bodySmall.copy(
                    color = MaterialTheme.colorScheme.onBackground,
                    textAlign = TextAlign.Start
                ),
                modifier = Modifier.layoutId("searchBar"),
                maxLines = 1,
                keyboardOptions = KeyboardOptions.Default.copy(
                    keyboardType = KeyboardType.Text,
                    imeAction = ImeAction.Search,
                    showKeyboardOnFocus = true
                )
            )
        }
    }
}

@Preview
@Composable
fun SearchTextFieldPreview() {
    TODOTheme {
        var text by remember { mutableStateOf("") }
        Column(modifier = Modifier.fillMaxSize()) {
            Spacer(modifier = Modifier.height(220.dp))
            SearchTextField(
                value = text,
                onValueChange = {
                    text = it
                }
            )
        }
    }


}

