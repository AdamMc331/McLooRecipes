package com.mcloo.recipes.shared.addrecipe

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier

@Composable
fun AddRecipeScreen(
    viewModel: AddRecipeViewModel,
    modifier: Modifier = Modifier,
) {
    val state = viewModel.state.collectAsState()

    AddRecipeContent(
        state = state.value,
        onNameChange = viewModel::onNameChange,
        onDurationChange = viewModel::onDurationChange,
        onIngredientsChange = viewModel::onIngredientsChange,
        onInstructionsChange = viewModel::onInstructionsChange,
        onCloseClick = viewModel::onCloseClick,
        onSaveClick = viewModel::onSaveClick,
        modifier = modifier,
    )
}
