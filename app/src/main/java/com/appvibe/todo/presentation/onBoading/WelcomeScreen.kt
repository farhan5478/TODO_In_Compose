package com.appvibe.todo.presentation.onBoading

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.layoutId
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
import com.appvibe.todo.ui.theme.Dimens
import com.appvibe.todo.ui.theme.TODOTheme

@Composable
fun WelcomeScreen(navController: NavController) {
    val constraints = ConstraintSet {

        val toolbarBackIcon = createRefFor("backIcon")
        val title = createRefFor("title")
        val subtitle = createRefFor("subTitle")
        val loginButton = createRefFor("loginButton")
        val createAccountButton = createRefFor("createAccountButton")


        constrain(toolbarBackIcon) {
            top.linkTo(parent.top, margin = Dimens.marginMedium)
            start.linkTo(parent.start)
        }

        constrain(title) {
            top.linkTo(toolbarBackIcon.bottom, margin = Dimens.marginLarge)
            start.linkTo(parent.start)
            end.linkTo(parent.end)
            height = Dimension.wrapContent
        }

        constrain(subtitle) {
            top.linkTo(title.bottom, margin = Dimens.marginLarge)
            start.linkTo(title.start, margin = Dimens.marginSmall)
            end.linkTo(title.end, margin = Dimens.marginSmall)
            width = Dimension.fillToConstraints
            height = Dimension.wrapContent
        }

        constrain(createAccountButton) {
            bottom.linkTo(parent.bottom, Dimens.marginLarge)
            start.linkTo(parent.start)
            end.linkTo(parent.end)
            width = Dimension.fillToConstraints
            height = Dimension.value(52.dp)
        }

        constrain(loginButton) {
            bottom.linkTo(createAccountButton.top, margin = Dimens.marginLarge)
            start.linkTo(parent.start)
            end.linkTo(parent.end)
            width = Dimension.fillToConstraints
            height = Dimension.value(52.dp)
        }
    }

    ConstraintLayout(
        constraintSet = constraints,
        modifier = Modifier
            .fillMaxSize()
            .background(color = MaterialTheme.colorScheme.background)
            .padding(Dimens.paddingMedium)
    ) {
        IconButton(onClick = {
            navController.popBackStack()
        }, modifier = Modifier.layoutId("backIcon")) {
            Image(painter = painterResource(R.drawable.ic_back), contentDescription = null)
        }

        Text(
            text = stringResource(R.string.txt_welcome_todo),
            modifier = Modifier.layoutId("title"),
            color = MaterialTheme.colorScheme.onBackground,
            style = MaterialTheme.typography.titleLarge
        )

        Text(
            text = stringResource(R.string.txt_login_to_account),
            modifier = Modifier.layoutId("subTitle"),
            color = MaterialTheme.colorScheme.onBackground,
            style = MaterialTheme.typography.bodySmall,
            textAlign = TextAlign.Center
        )

        OutlinedButton(
            onClick = {

            },
            modifier = Modifier.layoutId("createAccountButton"),
            shape = RectangleShape,
            border = BorderStroke(width = 3.dp, color = MaterialTheme.colorScheme.primary)
        ) {
            Text(
                text = stringResource(R.string.action_create_account),
                color = MaterialTheme.colorScheme.onBackground,
                style = MaterialTheme.typography.bodySmall,
                textAlign = TextAlign.Center
            )
        }


        Button(onClick = {

        }, modifier = Modifier.layoutId("loginButton"), shape = RoundedCornerShape(8.dp)) {
            Text(
                text = stringResource(R.string.action_login),
                color = MaterialTheme.colorScheme.onBackground,
                style = MaterialTheme.typography.bodySmall,
                textAlign = TextAlign.Center
            )
        }
    }
}


@Preview()
@Composable
fun PreviewWelcomeScreen() {
    TODOTheme {
        WelcomeScreen(navController = rememberNavController())
    }
}