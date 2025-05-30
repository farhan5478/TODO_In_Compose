package com.appvibe.todo.presentation.dashBoard.index.addTask

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.appvibe.todo.R
import com.appvibe.todo.presentation.components.EditTaskField
import com.appvibe.todo.ui.theme.TODOTheme

@Composable
fun AddTaskDialog(onDismiss: () -> Unit, onConfirm: () -> Unit) {

    val focusManager = LocalFocusManager.current

    Dialog(
        onDismissRequest = onDismiss,
        properties = DialogProperties(
            usePlatformDefaultWidth = false,
            dismissOnBackPress = true,
            dismissOnClickOutside = true
        )
    ) {
        Surface(
            modifier = Modifier
                .fillMaxWidth()
                .height(228.dp),
            shape = RoundedCornerShape(15.dp),
            color = MaterialTheme.colorScheme.background,
            contentColor = MaterialTheme.colorScheme.onBackground,
            tonalElevation = 8.dp,
        ) {
            Column(
                modifier = Modifier.padding(22.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = stringResource(R.string.txt_add_task),
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Start,
                    style = MaterialTheme.typography.titleLarge.copy(
                        fontSize = 20.sp
                    )
                )

                Spacer(modifier = Modifier.height(16.dp))

                EditTaskField(
                    txtValue = "",
                    focusManager = focusManager,
                    isFocusable = true,
                    placeHolder = R.string.txt_title
                ) { }

                Spacer(modifier = Modifier.height(16.dp))

                EditTaskField(
                    txtValue = "",
                    focusManager = focusManager,
                    placeHolder = R.string.txt_description
                ) { }


            }


        }

    }

}

@Preview
@Composable
fun PreviewAddTask() {
    TODOTheme {
        AddTaskDialog(onDismiss = {

        }) { }
    }

}