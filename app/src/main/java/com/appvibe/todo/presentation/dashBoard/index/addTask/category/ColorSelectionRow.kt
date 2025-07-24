package com.appvibe.todo.presentation.dashBoard.index.addTask.category

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun ColorSelectionRow(
    colors: List<Color>,
    onColorSelected: (Color) -> Unit,
    initiallySelectedIndex: Int = 0 // Optional: to set an initial selection
) {
    var selectedIndex by remember { mutableIntStateOf(initiallySelectedIndex) }

    LazyRow(
        contentPadding = PaddingValues(vertical = 8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp) // Spacing between items
    ) {
        itemsIndexed(colors) { index, color ->
            ColorCircleItem(
                color = color,
                isSelected = index == selectedIndex,
                onClick = {
                    selectedIndex = index
                    onColorSelected(color)
                }
            )
        }

        item {
            AddCircleItem {

            }
        }
    }
}

@Composable
fun ColorCircleItem(
    color: Color,
    isSelected: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {

    Box(
        modifier = modifier
            .size(36.dp) // Adjust size as needed
            .clip(CircleShape)
            .background(color)
            .clickable { onClick() },
        contentAlignment = Alignment.Center
    ) {
        if (isSelected) {
            Icon(
                imageVector = Icons.Filled.Check, // Or Icons.Rounded.Check for a rounded checkmark
                contentDescription = "Selected", // Provide a meaningful content description
                tint = Color.White,
                modifier = Modifier.size(24.dp) // Adjust icon size as needed
            )
        }
    }
}

@Composable
fun AddCircleItem(
    onClick: () -> Unit,
) {

    Box(
        modifier = Modifier
            .size(36.dp) // Adjust size as needed
            .background(Color.Transparent)
            .clickable { onClick() }
            .border(width = 1.dp, color = Color.White, shape = CircleShape),
        contentAlignment = Alignment.Center
    ) {
        Icon(
            imageVector = Icons.Default.Add, // Or Icons.Rounded.Check for a rounded checkmark
            contentDescription = "Add", // Provide a meaningful content description
            tint = Color.White,
            modifier = Modifier.size(24.dp) // Adjust icon size as needed
        )

    }
}

// Preview
@Preview(showBackground = true, backgroundColor = 0xFF000000) // Dark background for preview
@Composable
fun ColorSelectionRowPreview() {
    // Define your color palette
    val colorPalette = listOf(
        Color(0xFFDCE775), // Light Lime Green (with checkmark in your example)
        Color(0xFF9CCC65), // Lime Green
        Color(0xFF80CBC4), // Teal
        Color(0xFF64B5F6), // Light Blue
        Color(0xFF4FC3F7), // Cyan
        Color(0xFFFFB74D), // Orange
        Color(0xFFBA68C8), // Purple
        Color(0xFFF06292)  // Pink
    )
    MaterialTheme { // Wrap with your app's theme or MaterialTheme for preview
        ColorSelectionRow(
            colors = colorPalette,
            onColorSelected = { /* Handle color selection */ }
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ColorCircleItemPreview() {
    MaterialTheme {
        Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            ColorCircleItem(color = Color.Red, isSelected = false, onClick = {})
            ColorCircleItem(color = Color.Green, isSelected = true, onClick = {})
        }
    }
}