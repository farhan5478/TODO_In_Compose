package com.appvibe.todo.presentation.dashBoard.index.addTask

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet
import androidx.constraintlayout.compose.Dimension
import com.appvibe.todo.R
import com.appvibe.todo.presentation.components.EditTaskField
import com.appvibe.todo.ui.theme.Dimens
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
                .height(250.dp),
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

                Spacer(modifier = Modifier.height(16.dp))

                val constraints = ConstraintSet {
                    val timer = createRefFor("timer")
                    val tag = createRefFor("tag")
                    val priority = createRefFor("priority")
                    val addTask = createRefFor("addTask")

                    constrain(timer) {
                        top.linkTo(parent.top)
                        start.linkTo(parent.start, margin = 3.dp)
                        bottom.linkTo(parent.bottom)
                        width = Dimension.value(24.dp)
                        height = Dimension.value(24.dp)
                    }

                    constrain(tag) {
                        top.linkTo(parent.top)
                        start.linkTo(timer.end, margin = 20.dp)
                        bottom.linkTo(parent.bottom)
                        width = Dimension.value(24.dp)
                        height = Dimension.value(24.dp)
                    }

                    constrain(priority) {
                        top.linkTo(parent.top)
                        start.linkTo(tag.end, margin = 20.dp)
                        bottom.linkTo(parent.bottom)
                        width = Dimension.value(24.dp)
                        height = Dimension.value(24.dp)
                    }

                    constrain(addTask) {
                        top.linkTo(parent.top)
                        end.linkTo(parent.end)
                        bottom.linkTo(parent.bottom)
                        width = Dimension.value(24.dp)
                        height = Dimension.value(24.dp)
                    }
                }

                ConstraintLayout(
                    constraintSet = constraints,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(30.dp)
                ) {
                    Image(
                        painter = painterResource(R.drawable.ic_timer),
                        contentDescription = "Timer",
                        modifier = Modifier.layoutId("timer"),
                        alignment = Alignment.Center
                    )

                    Image(
                        painter = painterResource(R.drawable.ic_tag),
                        contentDescription = "Timer",
                        modifier = Modifier.layoutId("tag"),
                        alignment = Alignment.Center
                    )

                    Image(
                        painter = painterResource(R.drawable.ic_flag),
                        contentDescription = "Timer",
                        modifier = Modifier.layoutId("priority"),
                        alignment = Alignment.Center
                    )

                    Image(
                        painter = painterResource(R.drawable.ic_add_task),
                        contentDescription = "Timer",
                        modifier = Modifier.layoutId("addTask"),
                        alignment = Alignment.Center
                    )
                }
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