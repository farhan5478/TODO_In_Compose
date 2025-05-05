package com.appvibe.todo.presentation

import androidx.annotation.StringRes
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.appvibe.todo.R
import com.appvibe.todo.ui.theme.Black90
import com.appvibe.todo.ui.theme.Dimens
import com.appvibe.todo.ui.theme.Gray60
import com.appvibe.todo.ui.theme.TODOTheme

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
fun UserInputField(@StringRes labelId: Int, value: String, onValueChange: (String) -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .height(80.dp)
            .wrapContentHeight(),
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = stringResource(labelId),
            modifier = Modifier.padding(8.dp),
            color = MaterialTheme.colorScheme.onBackground,
            style = MaterialTheme.typography.labelMedium
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
                    text = stringResource(R.string.txt_user_name),
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
                    .fillMaxWidth()


            )
        }


    }
}

@Composable
@Preview
fun PreviewUserInputField() {
    TODOTheme {
        UserInputField(labelId = R.string.txt_user_name, value = "", onValueChange = {})
    }

}
