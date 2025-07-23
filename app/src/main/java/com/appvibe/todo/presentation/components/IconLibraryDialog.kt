package com.appvibe.todo.presentation.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.appvibe.todo.R
import com.appvibe.todo.ui.theme.Gray21
import com.appvibe.todo.ui.theme.White

@Composable
fun IconLibraryDialog(iconsList: List<Int>, onDismiss: () -> Unit, onSelectIcon: (Int) -> Unit) {

    var iconsList by remember { mutableStateOf(emptyList<Int>()) }

    LaunchedEffect(key1 = Unit) {
       arrayListOf(
            R.drawable.ic_category_work,
            R.drawable.ic_category_home,
            R.drawable.ic_category_shopping,
            R.drawable.ic_category_groceries,
            R.drawable.ic_category_personal,
            R.drawable.ic_category_health,
            R.drawable.ic_category_fitness,
            R.drawable.ic_category_study,
            R.drawable.ic_category_finance,
            R.drawable.ic_category_travel,
            R.drawable.ic_category_family,
            R.drawable.ic_category_friends,
            R.drawable.ic_category_birthday,
            R.drawable.ic_category_event,
            R.drawable.ic_category_music,
            R.drawable.ic_category_food,
            R.drawable.ic_category_pet,
            R.drawable.ic_category_car,
            R.drawable.ic_category_bills,
            R.drawable.ic_category_cleaning,
            R.drawable.ic_category_gift,
            R.drawable.ic_category_movie,
            R.drawable.ic_category_reading
        )
    }

    Dialog(onDismissRequest = onDismiss) {
        Surface(
            shape = MaterialTheme.shapes.medium,
            tonalElevation = 8.dp,
            color = Color(0xFF2B2B2B) // dark theme background
        ) {
            Column(modifier = Modifier.padding(16.dp)) {
                Text(
                    "Choose Icon",
                    style = MaterialTheme.typography.titleMedium,
                    color = MaterialTheme.colorScheme.onBackground,
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Center
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
                        iconsList.size,
                        key = { it -> iconsList[it] }) { index ->

                        Button(
                            onClick = {
                                onSelectIcon.invoke(iconsList[index])
                                onDismiss.invoke()
                            },
                            colors = ButtonDefaults.buttonColors(
                                containerColor = Gray21
                            ),
                            shape = RoundedCornerShape(3.dp),
                            modifier = Modifier.size(64.dp)
                        ) {
                            Image(
                                painter = painterResource(iconsList[index]),
                                contentDescription = "Icons",
                                modifier = Modifier.size(28.dp),
                                contentScale = ContentScale.FillBounds,
                            )
                        }

                    }

           /*         item {

                        Column(
                            modifier = Modifier.fillMaxSize(),
                            horizontalAlignment = Alignment.CenterHorizontally
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
                    }*/
                }
            }
        }


    }

}