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
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SelectableDates
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.appvibe.todo.R
import com.appvibe.todo.ui.theme.Gray60
import com.appvibe.todo.ui.theme.Purple60

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DatePickerModal(onDismiss: () -> Unit, onDateSelected: (Long?) -> Unit) {
    val calendar = Calendar.getInstance()
    val datePickerState = rememberDatePickerState(
        initialSelectedDateMillis = calendar.timeInMillis,
        selectableDates = object : SelectableDates {
            override fun isSelectableDate(utcTimeMillis: Long): Boolean {
                return utcTimeMillis >= (calendar.timeInMillis - 86400000)
            }
        }, yearRange = IntRange(2025, 2100)
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
                    DatePicker(
                        state = datePickerState,
                        showModeToggle = false,
                        title = null,
                        headline = null,
                        colors = DatePickerDefaults.colors(
                            containerColor = MaterialTheme.colorScheme.background,
                            titleContentColor = MaterialTheme.colorScheme.onBackground,
                            navigationContentColor = MaterialTheme.colorScheme.onBackground,
                            dayContentColor = MaterialTheme.colorScheme.onBackground,
                            weekdayContentColor = MaterialTheme.colorScheme.onBackground,
                            disabledDayContentColor = Gray60
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
                                onDateSelected.invoke(datePickerState.selectedDateMillis)
                                onDismiss.invoke()
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

            }
        })

}