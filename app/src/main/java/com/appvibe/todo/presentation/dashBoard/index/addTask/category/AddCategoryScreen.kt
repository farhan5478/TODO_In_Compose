package com.appvibe.todo.presentation.dashBoard.index.addTask.category

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.appvibe.todo.R
import com.appvibe.todo.presentation.components.IconLibraryDialog
import com.appvibe.todo.presentation.components.InputField
import com.appvibe.todo.ui.theme.Purple60
import com.appvibe.todo.ui.theme.TODOTheme
import com.appvibe.todo.ui.theme.White21
import com.appvibe.todo.ui.theme.White80

@Composable
fun AddNewCategoryScreen(onCancel: () -> Unit, onCreateCategory: () -> Unit) {

    val colorPalette = listOf(
        Color(0xFFDCE775), // Light Lime Green (with checkmark in your example)
        Color(0xFF9CCC65), // Lime Green
        Color(0xFF80CBC4), // Teal
        Color(0xFF64B5F6), // Light Blue
        Color(0xFF4FC3F7), // Cyan
        Color(0xFFFFB74D), // Orange
        Color(0xFFBA68C8), // Purple
        Color(0xFFF06292),  // Pink
         Color(0xFFFFB74D), // Orange
        Color(0xFFBA68C8), // Purple
        Color(0xFFF06292)
    )

   

    var showCategoryIconDialog by remember { mutableStateOf(false) }

    Scaffold(
        modifier = Modifier
            .fillMaxSize(),
        bottomBar = {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
                    .padding(horizontal = 16.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {

                TextButton(
                    onClick = {

                    },
                    shape = ButtonDefaults.textShape,
                    modifier = Modifier
                        .weight(1f)
                        .height(40.dp)
                ) {
                    Text(
                        text = stringResource(R.string.action_cancel),
                        modifier = Modifier.fillMaxWidth(),
                        color = Purple60,
                        style = MaterialTheme.typography.titleSmall,
                        textAlign = TextAlign.Center
                    )
                }

                Button(
                    onClick = {

                    }, modifier = Modifier
                        .weight(1f)
                        .height(40.dp),
                    shape = RoundedCornerShape(4.dp)
                ) {
                    Text(
                        text = stringResource(R.string.action_choose_date),
                        modifier = Modifier.fillMaxWidth(),
                        color = MaterialTheme.colorScheme.onBackground,
                        style = MaterialTheme.typography.bodySmall,
                        textAlign = TextAlign.Center
                    )
                }
            }

        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(
                    top = innerPadding.calculateTopPadding(),
                    start = 16.dp,
                    end = 16.dp,
                    bottom = innerPadding.calculateBottomPadding()
                ),
        ) {

            Spacer(modifier = Modifier.height(20.dp))

            Text(
                text = stringResource(R.string.txt_create_category),
                modifier = Modifier.fillMaxWidth(),
                color = MaterialTheme.colorScheme.onBackground,
                style = MaterialTheme.typography.titleLarge
            )

            Spacer(modifier = Modifier.height(20.dp))

            InputField(
                modifier = Modifier,
                labelId = R.string.txt_category_name,
                placeHolder = R.string.txt_enter_category_name,
                keyBoardOption = KeyboardOptions().copy(keyboardType = KeyboardType.Text),
                value = "",
                onValueChange = {})

            Spacer(modifier = Modifier.height(20.dp))

            Text(
                text = stringResource(R.string.txt_category_icon),
                modifier = Modifier.padding(vertical = 8.dp),
                color = White80, // Consider using MaterialTheme.colorScheme for this too
                style = MaterialTheme.typography.labelMedium,
            )
            Button(
                onClick = {
                    showCategoryIconDialog = true

                },
                modifier = Modifier
                    .wrapContentSize(),
                shape = RoundedCornerShape(6.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = White21,
                    contentColor = MaterialTheme.colorScheme.onBackground
                )
            ) {
                Text(
                    text = stringResource(R.string.txt_icon_from_lib),
                    modifier = Modifier.wrapContentSize(),
                    style = MaterialTheme.typography.labelMedium
                )
            }

            Spacer(modifier = Modifier.height(20.dp))

            Text(
                text = stringResource(R.string.txt_category_color),
                modifier = Modifier.padding(vertical = 8.dp),
                color = White80, // Consider using MaterialTheme.colorScheme for this too
                style = MaterialTheme.typography.labelMedium,
            )


            ColorSelectionRow(colors = colorPalette, onColorSelected = {

            })


        }

        if(showCategoryIconDialog) {
            IconLibraryDialog(onDismiss = {
                showCategoryIconDialog = false

            }, onSelectIcon = { drawable ->
                Log.d("TAG", "AddNewCategoryScreen: ")
                showCategoryIconDialog = false
            })
        }

    }


}

@Preview
@Composable
fun AddNewCategoryScreenPreview() {
    TODOTheme {
        AddNewCategoryScreen(onCancel = {}, onCreateCategory = {})
    }

}
