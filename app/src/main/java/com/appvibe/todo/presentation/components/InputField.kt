package com.appvibe.todo.presentation.components

import androidx.annotation.StringRes
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.appvibe.todo.ui.theme.Black90
import com.appvibe.todo.ui.theme.Gray60
import com.appvibe.todo.ui.theme.White80

@Composable
fun InputField(
    modifier: Modifier,
    @StringRes labelId: Int,
    @StringRes placeHolder: Int,
    keyBoardOption: KeyboardOptions,
    keyboardActions: KeyboardActions = KeyboardActions(),
    value: String,
    onValueChange: (String) -> Unit
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .height(80.dp), // Consider if a fixed height is always desired
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = stringResource(labelId),
            modifier = Modifier.padding(vertical = 8.dp),
            color = White80, // Consider using MaterialTheme.colorScheme for this too
            style = MaterialTheme.typography.labelMedium
        )

        BasicTextField(
            value = value,
            onValueChange = onValueChange,
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp) // Height of the text field area
                .background(color = Black90) // Consider from Theme
                .border(width = 1.dp, color = Gray60), // Consider from Theme
            singleLine = true,
            textStyle = MaterialTheme.typography.bodySmall.copy(
                color = MaterialTheme.colorScheme.onBackground,
                textAlign = TextAlign.Start
            ),
            keyboardOptions = keyBoardOption.copy(
                capitalization = KeyboardCapitalization.Words,
                autoCorrectEnabled = true,
            ),
            keyboardActions = keyboardActions,
            decorationBox = { innerTextField ->
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 12.dp), // Padding inside the border
                    contentAlignment = Alignment.CenterStart // Align placeholder and text to the start
                ) {
                    if (value.isEmpty()) {
                        Text(
                            text = stringResource(placeHolder),
                            color = MaterialTheme.colorScheme.onBackground.copy(alpha = 0.6f), // Softer placeholder
                            style = MaterialTheme.typography.bodySmall,
                            textAlign = TextAlign.Start
                        )
                    }
                    innerTextField() // This is where the actual text input will be rendered
                }
            }
        )
    }
}