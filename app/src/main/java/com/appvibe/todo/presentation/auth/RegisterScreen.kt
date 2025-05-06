package com.appvibe.todo.presentation.auth

import android.R.attr.bottom
import android.R.attr.end
import android.R.attr.height
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
import com.appvibe.todo.presentation.DividerWithText
import com.appvibe.todo.presentation.EmailInputField
import com.appvibe.todo.presentation.PasswordInputField
import com.appvibe.todo.ui.theme.Dimens
import com.appvibe.todo.ui.theme.Purple60
import com.appvibe.todo.ui.theme.TODOTheme
import com.appvibe.todo.ui.theme.White80

@Composable
fun RegisterScreen(navController: NavController) {
    val statusBarPadding = WindowInsets.statusBars.asPaddingValues().calculateTopPadding()
    val bottomNavigationBarPadding =
        WindowInsets.navigationBars.asPaddingValues().calculateTopPadding()
    val focusManager = LocalFocusManager.current
    val constraints = ConstraintSet {
        val toolbarBackIcon = createRefFor("backIcon")
        val screenCaption = createRefFor("screenCaption")
        val username = createRefFor("username")
        val password = createRefFor("password")
        val confirmPassword = createRefFor("confirmPassword")
        val registerButton = createRefFor("registerButton")
        val orDivider = createRefFor("orDivider")
        val registerWithGoogle = createRefFor("registerWithGoogle")
        val registerWithApple = createRefFor("registerWithApple")
        val loginRow = createRefFor("loginRow")

        constrain(toolbarBackIcon) {
            top.linkTo(parent.top, margin = statusBarPadding)
            start.linkTo(parent.start)
        }

        constrain(screenCaption) {
            top.linkTo(toolbarBackIcon.bottom, margin = Dimens.marginExtraLarge)
            start.linkTo(parent.start)
        }

        constrain(username) {
            top.linkTo(screenCaption.bottom, margin = Dimens.marginExtraLarge)
            start.linkTo(parent.start)
            end.linkTo(parent.end)
            width = Dimension.fillToConstraints
            height = Dimension.value(dp = 80.dp)
        }

        constrain(password) {
            top.linkTo(username.bottom, margin = Dimens.marginLarge)
            start.linkTo(parent.start)
            end.linkTo(parent.end)
            width = Dimension.fillToConstraints
            height = Dimension.value(dp = 80.dp)
        }

        constrain(confirmPassword) {
            top.linkTo(password.bottom, margin = Dimens.marginLarge)
            start.linkTo(parent.start)
            end.linkTo(parent.end)
            width = Dimension.fillToConstraints
            height = Dimension.value(dp = 80.dp)
        }


        constrain(registerButton) {
           top.linkTo(confirmPassword.bottom, margin = 55.dp)
            start.linkTo(parent.start)
            end.linkTo(parent.end)
            width = Dimension.fillToConstraints
            height = Dimension.value(dp = 52.dp)
        }

        constrain(orDivider) {
            top.linkTo(registerButton.bottom, margin = Dimens.marginExtraLarge)
            start.linkTo(parent.start)
            end.linkTo(parent.end)
            width = Dimension.fillToConstraints
            height = Dimension.wrapContent
        }

        constrain(registerWithGoogle) {
            top.linkTo(orDivider.bottom, margin = Dimens.marginExtraLarge)
            start.linkTo(parent.start)
            end.linkTo(parent.end)
            width = Dimension.fillToConstraints
            height = Dimension.value(dp = 52.dp)
        }

        constrain(registerWithApple) {
            top.linkTo(registerWithGoogle.bottom, margin = Dimens.marginLarge)
            start.linkTo(parent.start)
            end.linkTo(parent.end)
            width = Dimension.fillToConstraints
            height = Dimension.value(dp = 52.dp)
        }

        constrain(loginRow) {
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
            text = stringResource(R.string.txt_register),
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

        PasswordInputField(
            modifier = Modifier.layoutId("confirmPassword"),
            focusManager = focusManager,
            labelId = R.string.txt_confirms_password,
            placeHolder = R.string.txt_enter_your_password,
            value = ""
        ) {
            d("TAG", "LoginScreen: $it")
        }

        Button(onClick = {


        }, modifier = Modifier.layoutId("registerButton"), shape = RoundedCornerShape(5.dp)) {
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
            modifier = Modifier.layoutId("registerWithGoogle"),
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
            modifier = Modifier.layoutId("registerWithApple"),
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
                    text = stringResource(R.string.action_register_with_apple),
                    color = MaterialTheme.colorScheme.onBackground,
                    style = MaterialTheme.typography.bodySmall,
                    modifier = Modifier.padding(start = 10.dp)
                )
            }

        }

        Row(
            modifier = Modifier.layoutId("loginRow"),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = stringResource(R.string.txt_already_have_account),
                color = White80,
                style = MaterialTheme.typography.labelSmall,
                textAlign = TextAlign.Center
            )

            TextButton(
                onClick = {

                }, contentPadding = PaddingValues(start = 0.dp)
            ) {
                Text(
                    text = stringResource(R.string.txt_login),
                    color = MaterialTheme.colorScheme.onBackground,
                    style = MaterialTheme.typography.labelSmall
                )
            }
        }
    }


}


@Composable
@Preview
fun PreviewRegisterScreen() {
    TODOTheme {
        RegisterScreen(navController = rememberNavController())
    }
}