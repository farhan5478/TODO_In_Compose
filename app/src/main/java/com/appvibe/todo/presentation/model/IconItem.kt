package com.appvibe.todo.presentation.model

import androidx.annotation.DrawableRes

data class IconItem(@DrawableRes val drawableId: Int, val contentDescription: String = "Icon")