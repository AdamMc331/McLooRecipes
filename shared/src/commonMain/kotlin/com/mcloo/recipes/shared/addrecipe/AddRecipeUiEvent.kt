package com.mcloo.recipes.shared.addrecipe

import androidx.compose.ui.text.input.TextFieldValue

sealed interface AddRecipeUiEvent {
    data object CloseClicked : AddRecipeUiEvent

    data object SaveClicked : AddRecipeUiEvent

    data class NameChanged(
        val name: TextFieldValue,
    ) : AddRecipeUiEvent

    data class DurationChanged(
        val duration: TextFieldValue,
    ) : AddRecipeUiEvent

    data class IngredientsChanged(
        val ingredients: TextFieldValue,
    ) : AddRecipeUiEvent

    data class InstructionsChanged(
        val instructions: TextFieldValue,
    ) : AddRecipeUiEvent

    data object CompletionHandled : AddRecipeUiEvent
}
