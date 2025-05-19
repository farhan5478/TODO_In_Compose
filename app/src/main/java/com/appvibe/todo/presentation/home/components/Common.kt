package com.appvibe.todo.presentation.home.components

import androidx.annotation.StringRes
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.focus.FocusManager
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.appvibe.todo.R
import com.appvibe.todo.ui.theme.Black90
import com.appvibe.todo.ui.theme.Gray60
import com.appvibe.todo.ui.theme.TODOTheme
import com.appvibe.todo.ui.theme.White80

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

@Composable
fun EmailInputField(
    modifier: Modifier,
    focusManager: FocusManager,
    @StringRes labelId: Int,
    @StringRes placeHolder: Int,
    value: String,
    onValueChange: (String) -> Unit
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .height(80.dp),
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = stringResource(labelId),
            modifier = Modifier.padding(vertical = 8.dp),
            color = White80,
            style = MaterialTheme.typography.labelSmall
        )

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp)
                .background(color = Black90)
                .border(width = 1.dp, color = Gray60)
                .padding(horizontal = 12.dp),
            contentAlignment = Alignment.Center
        ) {
            if (value.isEmpty()) {
                Text(
                    text = stringResource(placeHolder),
                    modifier = Modifier.fillMaxWidth(),
                    color = MaterialTheme.colorScheme.onBackground,
                    style = MaterialTheme.typography.bodySmall,
                    textAlign = TextAlign.Start
                )
            }
            BasicTextField(
                value = value,
                onValueChange = onValueChange,
                singleLine = true,
                textStyle = MaterialTheme.typography.bodySmall.copy(
                    color = MaterialTheme.colorScheme.onBackground,
                    textAlign = TextAlign.Start
                ),
                modifier = Modifier
                    .fillMaxWidth(),
                maxLines = 1,
                keyboardOptions = KeyboardOptions.Default.copy(
                    capitalization = KeyboardCapitalization.Words,
                    autoCorrectEnabled = true,
                    keyboardType = KeyboardType.Email,
                    imeAction = ImeAction.Next,
                    showKeyboardOnFocus = true
                ),
                keyboardActions = KeyboardActions(
                    onNext = {
                        focusManager.moveFocus(FocusDirection.Down)
                    }
                )


            )
        }


    }
}

@Composable
fun PasswordInputField(
    modifier: Modifier,
    focusManager: FocusManager,
    @StringRes labelId: Int,
    @StringRes placeHolder: Int,
    value: String,
    onValueChange: (String) -> Unit
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .height(80.dp),
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = stringResource(labelId),
            modifier = Modifier.padding(vertical = 8.dp),
            color = White80,
            style = MaterialTheme.typography.labelSmall
        )

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp)
                .background(color = Black90)
                .border(width = 1.dp, color = Gray60)
                .padding(horizontal = 12.dp),
            contentAlignment = Alignment.Center
        ) {
            if (value.isEmpty()) {
                Text(
                    text = stringResource(placeHolder),
                    modifier = Modifier.fillMaxWidth(),
                    color = MaterialTheme.colorScheme.onBackground,
                    style = MaterialTheme.typography.bodySmall,
                    textAlign = TextAlign.Start
                )
            }
            BasicTextField(
                value = value,
                onValueChange = onValueChange,
                singleLine = true,
                textStyle = MaterialTheme.typography.bodySmall.copy(
                    color = MaterialTheme.colorScheme.onBackground,
                    textAlign = TextAlign.Start
                ),
                modifier = Modifier
                    .fillMaxWidth(),
                maxLines = 1,
                visualTransformation = PasswordVisualTransformation(),
                keyboardOptions = KeyboardOptions.Default.copy(
                    capitalization = KeyboardCapitalization.Words,
                    autoCorrectEnabled = true,
                    keyboardType = KeyboardType.Password,
                    imeAction = ImeAction.Next,
                    showKeyboardOnFocus = true
                ),
                keyboardActions = KeyboardActions(
                    onNext = {
                        focusManager.moveFocus(FocusDirection.Down)
                    }
                )


            )
        }


    }
}

@Composable
fun DividerWithText(modifier: Modifier) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically
    ) {
        HorizontalDivider(
            modifier = Modifier.weight(1f),
            color = Gray60,
            thickness = 1.dp
        )
        Text(
            text = "or",
            modifier = Modifier.padding(horizontal = 8.dp),
            color = Gray60
        )
        HorizontalDivider(
            modifier = Modifier.weight(1f),
            color = Gray60,
            thickness = 1.dp
        )
    }
}

@Composable
@Preview
fun PreviewEmailInputField() {
    TODOTheme {
        val focusManager = LocalFocusManager.current
        EmailInputField(
            modifier = Modifier,
            focusManager = focusManager,
            labelId = R.string.txt_user_name,
            placeHolder = R.string.txt_enter_your_user_name,
            value = "",
            onValueChange = {})
    }

}

@Composable
@Preview
fun PreviewPasswordInputField() {
    TODOTheme {
        val focusManager = LocalFocusManager.current
        PasswordInputField(
            modifier = Modifier,
            focusManager = focusManager,
            labelId = R.string.txt_password,
            placeHolder = R.string.txt_enter_your_password,
            value = "",
            onValueChange = {})
    }

}

@Composable
@Preview
fun PreviewDividerWithText() {
    TODOTheme {
        DividerWithText(modifier = Modifier.fillMaxWidth())
    }

}
