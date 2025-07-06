package com.appvibe.todo.presentation.dashBoard.index.addTask

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.window.Dialog

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
                Text("Task Priority", style = MaterialTheme.typography.titleMedium)

                Spacer(Modifier.height(8.dp))

                LazyVerticalGrid(
                    columns = GridCells.Fixed(4),
                    modifier = Modifier
                        .height(200.dp)
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    items(10) { index ->
                        val number = index + 1
                        val isSelected = number == selectedPriority

                        Button(
                            onClick = { selectedPriority = number },
                            colors = ButtonDefaults.buttonColors(
                                containerColor = if (isSelected) Color(0xFF9286F7) else Color.DarkGray
                            ),
                            modifier = Modifier.size(64.dp)
                        ) {
                            Text("$number")
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




