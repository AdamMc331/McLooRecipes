package com.mcloo.recipes.shared.addrecipe

import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier

@Composable
fun AddRecipeScreen(
    viewModel: AddRecipeViewModel,
    onComplete: () -> Unit,
    modifier: Modifier = Modifier,
) {
    val state = viewModel.state.collectAsState()

    LaunchedEffect(state.value.isComplete) {
        if (state.value.isComplete) {
            onComplete.invoke()
        }
    }

    AddRecipeContent(
        state = state.value,
        onEvent = viewModel::onEvent,
        modifier = modifier
            .statusBarsPadding(),
    )
}
