package com.appvibe.todo.presentation.dashBoard.index.addTask

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.lazy.grid.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.window.Dialog
import com.appvibe.todo.R
import com.appvibe.todo.ui.theme.TODOTheme
import com.appvibe.todo.ui.theme.White

@Composable
fun TaskPriorityDialog(
    onDismiss: () -> Unit,
    onSave: (Int) -> Unit
) {
    var selectedPriority by remember { mutableStateOf(1) }

    Dialog(onDismissRequest = onDismiss) {
        Surface(
            shape = MaterialTheme.shapes.medium,
            tonalElevation = 8.dp,
            color = Color(0xFF2B2B2B) // dark theme background
        ) {
            Column(modifier = Modifier.padding(16.dp)) {
                Text(
                    "Task Priority",
                    style = MaterialTheme.typography.titleMedium,
                    color = MaterialTheme.colorScheme.onBackground,
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = androidx.compose.ui.text.style.TextAlign.Center
                )

                Spacer(Modifier.height(8.dp))

                HorizontalDivider(
                    modifier = Modifier.fillMaxWidth(),
                    thickness = 1.dp,
                    color = White
                )

                Spacer(Modifier.height(15.dp))

                LazyVerticalGrid(
                    columns = GridCells.Fixed(4),
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(12.dp),
                    verticalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    items(10) { index ->
                        val number = index + 1
                        val isSelected = number == selectedPriority

                        Button(
                            onClick = { selectedPriority = number },
                            colors = ButtonDefaults.buttonColors(
                                containerColor = if (isSelected) Color(0xFF9286F7) else Color.DarkGray
                            ),
                            shape = RoundedCornerShape(3.dp),
                            modifier = Modifier.size(64.dp)
                        ) {
                            Column(
                                modifier = Modifier.fillMaxSize()
                            ) {
                                Image(
                                    painter = painterResource(R.drawable.ic_flag),
                                    contentDescription = "Timer",
                                    modifier = Modifier.fillMaxWidth().height(30.dp),
                                    contentScale = androidx.compose.ui.layout.ContentScale.FillBounds,
                                    alignment = Alignment.TopCenter,
                                )
                                Text(
                                    "$number", style = MaterialTheme.typography.labelSmall,
                                    color = MaterialTheme.colorScheme.onBackground,
                                    modifier = Modifier.fillMaxWidth(),
                                    textAlign = androidx.compose.ui.text.style.TextAlign.Center
                                )
                            }

                        }
                    }
                }

                Spacer(Modifier.height(16.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    TextButton(onClick = onDismiss) {
                        Text("Cancel", color = Color(0xFF9286F7))
                    }
                    Button(
                        onClick = { onSave(selectedPriority) },
                        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF9286F7))
                    ) {
                        Text("Save")
                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun TaskPriorityDialogPreview() {
    TODOTheme {
        TaskPriorityDialog(onDismiss = {}, onSave = {})
    }

}



