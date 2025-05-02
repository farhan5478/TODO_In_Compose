package com.appvibe.todo.presentation

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource

@Composable
fun TextButton(@StringRes caption: Int, onClick: () -> Unit) {
    TextButton(
        onClick = onClick,
        modifier = Modifier
            .wrapContentSize(),
        shape = ButtonDefaults.textShape
    ) {
        Text(
            text = stringResource(id = caption),
            color = MaterialTheme.colorScheme.onBackground,
            style = MaterialTheme.typography.titleSmall
        )
    }
}
