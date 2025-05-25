package com.appvibe.todo.presentation.onBoading

import android.app.Activity
import androidx.activity.compose.LocalActivity
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet
import androidx.constraintlayout.compose.Dimension
import androidx.navigation.NavController
import com.appvibe.todo.R
import com.appvibe.todo.presentation.components.TextButton

@Composable
fun BaseScreen(navController: NavController, content: @Composable (modifier: Modifier) -> Unit) {
    val statusBarPadding = WindowInsets.statusBars.asPaddingValues().calculateTopPadding()
    val bottomPadding = WindowInsets.navigationBars.asPaddingValues().calculateBottomPadding()
    val activity = LocalActivity.current

    val constraints = ConstraintSet {
        val header = createRefFor("header")
        val body = createRefFor("body")
        val footer = createRefFor("footer")

        constrain(header) {
            top.linkTo(parent.top)
            start.linkTo(parent.start)
            end.linkTo(parent.end)
        }

        constrain(body) {
            top.linkTo(header.bottom)
            start.linkTo(parent.start)
            end.linkTo(parent.end)
        }

        constrain(footer) {
            bottom.linkTo(parent.bottom)
            start.linkTo(parent.start)
            end.linkTo(parent.end)
        }
    }

    ConstraintLayout(
        constraintSet = constraints, modifier = Modifier
            .fillMaxSize()
            .background(
                MaterialTheme.colorScheme.background
            )
            .padding(start = 16.dp, top = statusBarPadding, end = 16.dp, bottom = bottomPadding)
    ) {
        Header(navController, modifier = Modifier.layoutId("header"))
        content(Modifier.layoutId("body"))
        Footer(
            navController, modifier = Modifier
                .layoutId("footer"),
            activity = activity
        )
    }

}


@Composable
fun Header(navController: NavController, modifier: Modifier) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(44.dp),
        contentAlignment = Alignment.CenterStart
    ) {
        TextButton(caption = R.string.action_skip) {
            when (navController.currentBackStackEntry?.destination?.route) {
                OnBoardDestination.STEP_1 -> navController.navigate(OnBoardDestination.STEP_2)
                OnBoardDestination.STEP_2 -> navController.navigate(OnBoardDestination.STEP_3)
            }
        }
    }
}

@Composable
fun Footer(navController: NavController, modifier: Modifier, activity: Activity?) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .wrapContentHeight(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        val currentRoute = navController.currentBackStackEntry?.destination?.route
        TextButton(caption = R.string.action_back) {
            if (currentRoute == OnBoardDestination.STEP_1) {
                activity?.finish()
            } else {
                navController.popBackStack()
            }

        }

        Button(
            onClick = {
                when (currentRoute) {
                    OnBoardDestination.STEP_1 -> navController.navigate(OnBoardDestination.STEP_2)
                    OnBoardDestination.STEP_2 -> navController.navigate(OnBoardDestination.STEP_3)
                }
            },
            modifier = Modifier
                .wrapContentWidth()
                .height(48.dp),
            shape = RoundedCornerShape(4.dp)
        ) {
            val action = if (currentRoute == OnBoardDestination.STEP_3) {
                R.string.action_get_started
            } else {
                R.string.action_next
            }
            Text(text = stringResource(action))
        }
    }
}

@Composable
fun Body(
    navController: NavController,
    @DrawableRes image: Int,
    @DrawableRes navImage: Int,
    @StringRes title: Int,
    @StringRes description: Int
) {
    BaseScreen(navController) { modifier ->
        ConstraintLayout(modifier = modifier) {
            val (mainImg, spacer1, navImg, spacer2, mainTitle, spacer3, subtitle) = createRefs()

            Image(
                painter = painterResource(image),
                contentDescription = null,
                modifier = Modifier.constrainAs(mainImg) {
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                })

            Spacer(
                modifier = Modifier
                    .height(35.dp)
                    .constrainAs(spacer1) {
                        top.linkTo(mainImg.bottom)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                    })

            Image(
                painter = painterResource(navImage),
                contentDescription = null,
                modifier = Modifier.constrainAs(navImg) {
                    top.linkTo(spacer1.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                })

            Spacer(
                modifier = Modifier
                    .height(55.dp)
                    .constrainAs(spacer2) {
                        top.linkTo(navImg.bottom)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                    })

            Text(
                text = stringResource(title),
                color = MaterialTheme.colorScheme.onBackground,
                style = MaterialTheme.typography.titleLarge,
                modifier = Modifier
                    .constrainAs(mainTitle) {
                        top.linkTo(spacer2.bottom)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                    }
            )

            Spacer(
                modifier = Modifier
                    .height(45.dp)
                    .constrainAs(spacer3) {
                        top.linkTo(mainTitle.bottom)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                    })

            Text(
                text = stringResource(description),
                color = MaterialTheme.colorScheme.onBackground,
                style = MaterialTheme.typography.bodySmall,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .constrainAs(subtitle) {
                        top.linkTo(spacer3.bottom)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                        width = Dimension.fillToConstraints
                    })
        }
    }
}

@Composable
fun OnBoardScreenOne(navController: NavController) {
    Body(
        navController = navController,
        image = R.drawable.on_board_1,
        navImage = R.drawable.on_board_nav_1,
        title = R.string.txt_manage_your_tasks,
        description = R.string.txt_manage_des
    )
}

@Composable
fun OnBoardScreenTwo(navController: NavController) {
    Body(
        navController = navController,
        image = R.drawable.on_board_2,
        navImage = R.drawable.on_board_nav_2,
        title = R.string.txt_daily_routine,
        description = R.string.txt_routine_des
    )
}

@Composable
fun OnBoardScreenThree(navController: NavController) {
    Body(
        navController = navController,
        image = R.drawable.on_board_3,
        navImage = R.drawable.on_board_nav_3,
        title = R.string.txt_manage_your_tasks,
        description = R.string.txt_organize_des
    )
}