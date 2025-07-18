package com.appvibe.todo.presentation.dashBoard.index.addTask.category

import android.R.attr.category
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.appvibe.todo.R
import com.appvibe.todo.data.Dummy
import com.appvibe.todo.domain.Category
import com.appvibe.todo.ui.theme.TODOTheme
import com.appvibe.todo.ui.theme.White
import com.appvibe.todo.utils.withAlpha

@Composable
fun CategoryDialog(
    onDismiss: () -> Unit,
    onSelectCategory: (Category) -> Unit,
    onAddCategory: () -> Unit
) {

    Dialog(onDismissRequest = onDismiss) {
        Surface(
            shape = MaterialTheme.shapes.medium,
            tonalElevation = 8.dp,
            color = Color(0xFF2B2B2B) // dark theme background
        ) {
            Column(modifier = Modifier.padding(16.dp)) {
                Text(
                    "Choose Category",
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
                    columns = GridCells.Fixed(3),
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(12.dp),
                    verticalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    items(
                        Dummy.categoryList().size,
                        key = { it -> Dummy.categoryList()[it].id }) { index ->
                        val category = Dummy.categoryList()[index]

                        Column(
                            modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally
                        ) {

                            Button(
                                onClick = {
                                    onSelectCategory(category)
                                },
                                colors = ButtonDefaults.buttonColors(
                                    containerColor = Color(category.color)
                                ),
                                shape = RoundedCornerShape(3.dp),
                                modifier = Modifier.size(64.dp)
                            ) {
                                Image(
                                    painter = painterResource(category.icon),
                                    contentDescription = "Timer",
                                    modifier = Modifier.size(28.dp),
                                    contentScale = ContentScale.FillBounds,
                                    colorFilter = ColorFilter.tint(
                                        color = Color(category.color).withAlpha(
                                            0x99
                                        )
                                    )
                                )
                            }

                            Spacer(modifier = Modifier.height(5.dp))


                            Text(
                                text = category.name, style = MaterialTheme.typography.labelSmall,
                                color = MaterialTheme.colorScheme.onBackground,
                                modifier = Modifier.fillMaxWidth(),
                                textAlign = TextAlign.Center
                            )
                        }

                    }

                    item {

                        Column(
                            modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally
                        ) {

                            Button(
                                onClick = onAddCategory,
                                colors = ButtonDefaults.buttonColors(
                                    containerColor = Color.Blue
                                ),
                                shape = RoundedCornerShape(3.dp),
                                modifier = Modifier.size(64.dp)
                            ) {
                                Image(
                                    imageVector = Icons.Default.Add,
                                    contentDescription = "Add",
                                    modifier = Modifier.size(28.dp),
                                    contentScale = ContentScale.FillBounds,
                                    colorFilter = ColorFilter.tint(
                                        color = Color.Blue.withAlpha(
                                            0x99
                                        )
                                    )
                                )
                            }

                            Spacer(modifier = Modifier.height(5.dp))


                            Text(
                                text = "Create New", style = MaterialTheme.typography.labelSmall,
                                color = MaterialTheme.colorScheme.onBackground,
                                modifier = Modifier.fillMaxWidth(),
                                textAlign = TextAlign.Center
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
fun CategoryDialogPreview() {
    TODOTheme {
        CategoryDialog(
            onDismiss = {},
            onSelectCategory = {},
            onAddCategory = {}
        )
    }
}
