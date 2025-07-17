package com.appvibe.todo.utils

import androidx.compose.ui.graphics.Color

fun Color.withAlpha(alpha: Int): Color {
    val rgb = this.value.toInt() and 0x00FFFFFF
    return Color((alpha shl 24) or rgb)
}