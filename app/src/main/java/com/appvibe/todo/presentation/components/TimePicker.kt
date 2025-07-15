package com.appvibe.todo.presentation.components

import android.icu.util.Calendar
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TimeInput
import androidx.compose.material3.TimePickerDefaults
import androidx.compose.material3.TimePickerState
import androidx.compose.material3.rememberTimePickerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.appvibe.todo.R
import com.appvibe.todo.ui.theme.Gray60
import com.appvibe.todo.ui.theme.Purple60
import com.appvibe.todo.ui.theme.Violet

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TimePickerModal(onDismiss: () -> Unit, onTimeSelected: (TimePickerState) -> Unit) {

    val calendar = Calendar.getInstance()

    val timePickerState = rememberTimePickerState(
        initialHour = calendar.get(Calendar.HOUR_OF_DAY),
        initialMinute = calendar.get(Calendar.MINUTE),
        is24Hour = false
    )

    Dialog(
        onDismissRequest = onDismiss,
        properties = DialogProperties(dismissOnBackPress = false, dismissOnClickOutside = false),
        {
            Card(
                modifier = Modifier
                    .wrapContentSize()
                    .wrapContentHeight()
                    .padding(8.dp),
                shape = RoundedCornerShape(10.dp),
                colors = CardDefaults.cardColors(
                    containerColor = MaterialTheme.colorScheme.background,
                ),
                elevation = CardDefaults.cardElevation(defaultElevation = 10.dp)
            ) {
                Column(
                    modifier = Modifier
                        .wrapContentSize()
                        .padding(bottom = 12.dp),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally,
                ) {

                    Text(
                        text = stringResource(R.string.txt_choose_time),
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 12.dp),
                        textAlign = TextAlign.Center,
                        style = MaterialTheme.typography.titleMedium
                    )

                    HorizontalDivider(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(bottom = 12.dp, start = 16.dp, end = 16.dp),
                        thickness = 1.dp,
                        color = Gray60
                    )


                    TimeInput(
                        state = timePickerState,
                        colors = TimePickerDefaults.colors(
                            containerColor = MaterialTheme.colorScheme.background,
                            clockDialColor = Color.Transparent,
                            timeSelectorSelectedContentColor = Color.White,
                            timeSelectorUnselectedContentColor = Color.White,
                            timeSelectorSelectedContainerColor = Color.Transparent,
                            timeSelectorUnselectedContainerColor = Color.Transparent,
                            periodSelectorSelectedContentColor = Color.White,
                            periodSelectorSelectedContainerColor = Violet,
                            periodSelectorUnselectedContainerColor = Color.Transparent
                        )

                    )
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .wrapContentHeight()
                            .padding(horizontal = 16.dp),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {

                        TextButton(
                            onClick = {
                                onDismiss()
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
                                onTimeSelected.invoke(timePickerState)
                                onDismiss.invoke()
                            }, modifier = Modifier
                                .weight(1f)
                                .height(40.dp),
                            shape = RoundedCornerShape(4.dp)
                        ) {
                            Text(
                                text = stringResource(R.string.action_save),
                                modifier = Modifier.fillMaxWidth(),
                                color = MaterialTheme.colorScheme.onBackground,
                                style = MaterialTheme.typography.bodySmall,
                                textAlign = TextAlign.Center
                            )
                        }
                    }

                }

            }
        })
}