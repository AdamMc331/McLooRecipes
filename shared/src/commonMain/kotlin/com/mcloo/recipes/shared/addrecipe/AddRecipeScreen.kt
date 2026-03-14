package com.mcloo.recipes.shared.addrecipe

import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier

@Composable
fun AddRecipeScreen(
    viewModel: AddRecipeViewModel,
    onCloseClicked: () -> Unit,
    modifier: Modifier = Modifier,
) {
    val state = viewModel.state.collectAsState()

    AddRecipeContent(
        state = state.value,
        onEvent = { event ->
            when (event) {
                AddRecipeUiEvent.CloseClicked -> onCloseClicked.invoke()
                else -> viewModel.onEvent(event)
            }
        },
        modifier = modifier
            .statusBarsPadding(),
    )
}
