package com.mcloo.recipes

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import com.mcloo.recipes.shared.App

fun main() = application {
    Window(
        onCloseRequest = ::exitApplication,
        title = "KotlinProject",
    ) {
        App()
    }
}
