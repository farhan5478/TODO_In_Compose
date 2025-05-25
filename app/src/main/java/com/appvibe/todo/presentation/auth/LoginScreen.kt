package com.appvibe.todo.presentation.auth

import android.util.Log.d
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet
import androidx.constraintlayout.compose.Dimension
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.appvibe.todo.R
import com.appvibe.todo.presentation.components.DividerWithText
import com.appvibe.todo.presentation.components.EmailInputField
import com.appvibe.todo.presentation.components.PasswordInputField
import com.appvibe.todo.ui.theme.Dimens
import com.appvibe.todo.ui.theme.Purple60
import com.appvibe.todo.ui.theme.TODOTheme
import com.appvibe.todo.ui.theme.White80

@Composable
fun LoginScreen(navController: NavController) {
    val statusBarPadding = WindowInsets.statusBars.asPaddingValues().calculateTopPadding()
    val bottomNavigationBarPadding =
        WindowInsets.navigationBars.asPaddingValues().calculateTopPadding()
    val focusManager = LocalFocusManager.current
    val constraints = ConstraintSet {
        val toolbarBackIcon = createRefFor("backIcon")
        val screenCaption = createRefFor("screenCaption")
        val username = createRefFor("username")
        val password = createRefFor("password")
        val loginButton = createRefFor("loginButton")
        val orDivider = createRefFor("orDivider")
        val loginWithGoogle = createRefFor("loginWithGoogle")
        val loginWithApple = createRefFor("loginWithApple")
        val registerRow = createRefFor("registerRow")

        constrain(toolbarBackIcon) {
            top.linkTo(parent.top, margin = statusBarPadding)
            start.linkTo(parent.start)
        }

        constrain(screenCaption) {
            top.linkTo(toolbarBackIcon.bottom, margin = Dimens.marginExtraLarge)
            start.linkTo(parent.start)
        }

        constrain(username) {
            bottom.linkTo(password.top, margin = Dimens.marginLarge)
            start.linkTo(parent.start)
            end.linkTo(parent.end)
            width = Dimension.fillToConstraints
            height = Dimension.value(dp = 80.dp)
        }

        constrain(password) {
            bottom.linkTo(loginButton.top, margin = 62.dp)
            start.linkTo(parent.start)
            end.linkTo(parent.end)
            width = Dimension.fillToConstraints
            height = Dimension.value(dp = 80.dp)
        }

        constrain(loginButton) {
            bottom.linkTo(orDivider.top, margin = 50.dp)
            start.linkTo(parent.start)
            end.linkTo(parent.end)
            width = Dimension.fillToConstraints
            height = Dimension.value(dp = 52.dp)
        }

        constrain(orDivider) {
            bottom.linkTo(loginWithGoogle.top, margin = 50.dp)
            start.linkTo(parent.start)
            end.linkTo(parent.end)
            width = Dimension.fillToConstraints
            height = Dimension.wrapContent
        }

        constrain(loginWithGoogle) {
            bottom.linkTo(loginWithApple.top, margin = Dimens.marginMedium)
            start.linkTo(parent.start)
            end.linkTo(parent.end)
            width = Dimension.fillToConstraints
            height = Dimension.value(dp = 52.dp)
        }

        constrain(loginWithApple) {
            bottom.linkTo(registerRow.top, margin = 80.dp)
            start.linkTo(parent.start)
            end.linkTo(parent.end)
            width = Dimension.fillToConstraints
            height = Dimension.value(dp = 52.dp)
        }

        constrain(registerRow) {
            bottom.linkTo(parent.bottom, margin = bottomNavigationBarPadding)
            start.linkTo(parent.start)
            end.linkTo(parent.end)
            width = Dimension.wrapContent
            height = Dimension.wrapContent
        }


    }

    ConstraintLayout(
        constraintSet = constraints,
        modifier = Modifier
            .fillMaxSize()
            .background(color = MaterialTheme.colorScheme.background)
            .padding(Dimens.paddingMedium)
    ) {
        IconButton(
            onClick = {
                navController.popBackStack()
            }, modifier = Modifier
                .layoutId("backIcon")
                .size(24.dp)
        ) {
            Image(painter = painterResource(R.drawable.ic_back), contentDescription = null)
        }
        Text(
            text = stringResource(R.string.txt_login),
            modifier = Modifier.layoutId("screenCaption"),
            color = MaterialTheme.colorScheme.onBackground,
            style = MaterialTheme.typography.titleLarge
        )

        EmailInputField(
            modifier = Modifier.layoutId("username"),
            focusManager = focusManager,
            labelId = R.string.txt_user_name,
            placeHolder = R.string.txt_enter_your_user_name,
            value = "",
        ) {
            d("TAG", "LoginScreen: $it")
        }

        PasswordInputField(
            modifier = Modifier.layoutId("password"),
            focusManager = focusManager,
            labelId = R.string.txt_password,
            placeHolder = R.string.txt_enter_your_password,
            value = ""
        ) {
            d("TAG", "LoginScreen: $it")
        }

        Button(onClick = {


        }, modifier = Modifier.layoutId("loginButton"), shape = RoundedCornerShape(5.dp)) {
            Text(
                text = stringResource(R.string.action_login),
                color = MaterialTheme.colorScheme.onBackground,
                style = MaterialTheme.typography.bodySmall,
                textAlign = TextAlign.Center
            )
        }

        DividerWithText(modifier = Modifier.layoutId("orDivider"))

        OutlinedButton(
            onClick = {

            },
            modifier = Modifier.layoutId("loginWithGoogle"),
            shape = RoundedCornerShape(5.dp),
            border = BorderStroke(width = 1.dp, color = Purple60)
        ) {
            Row(
                modifier = Modifier.fillMaxSize(),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    painter = painterResource(R.drawable.ic_google),
                    contentDescription = null,
                    tint = Color.Unspecified,
                    modifier = Modifier.size(24.dp)
                )
                Text(
                    text = stringResource(R.string.action_login_with_google),
                    color = MaterialTheme.colorScheme.onBackground,
                    style = MaterialTheme.typography.bodySmall,
                    modifier = Modifier.padding(start = 10.dp)
                )
            }
        }

        OutlinedButton(
            onClick = {

            },
            modifier = Modifier.layoutId("loginWithApple"),
            shape = RoundedCornerShape(5.dp),
            border = BorderStroke(width = 1.dp, color = Purple60),

            ) {
            Row(
                modifier = Modifier.fillMaxSize(),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    painter = painterResource(R.drawable.ic_apple),
                    contentDescription = null,
                    tint = Color.Unspecified,
                    modifier = Modifier.size(24.dp)
                )
                Text(
                    text = stringResource(R.string.action_login_with_apple),
                    color = MaterialTheme.colorScheme.onBackground,
                    style = MaterialTheme.typography.bodySmall,
                    modifier = Modifier.padding(start = 10.dp)
                )
            }

        }

        Row(
            modifier = Modifier.layoutId("registerRow"),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = stringResource(R.string.action_do_not_have_account),
                color = White80,
                style = MaterialTheme.typography.labelSmall,
                textAlign = TextAlign.Center
            )

            TextButton(
                onClick = {

                }, contentPadding = PaddingValues(start = 0.dp)
            ) {
                Text(
                    text = stringResource(R.string.action_register),
                    color = MaterialTheme.colorScheme.onBackground,
                    style = MaterialTheme.typography.labelSmall
                )
            }
        }
    }


}


@Composable
@Preview
fun PreviewLoginScreen() {
    TODOTheme {
        LoginScreen(navController = rememberNavController())
    }
}