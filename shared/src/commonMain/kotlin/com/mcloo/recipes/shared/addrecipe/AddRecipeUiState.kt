package com.mcloo.recipes.shared.addrecipe

import androidx.compose.ui.text.input.TextFieldValue

data class AddRecipeUiState(
    val name: TextFieldValue,
    val duration: TextFieldValue,
    val ingredients: TextFieldValue,
    val instructions: TextFieldValue,
) {
    val saveButtonEnabled: Boolean = name.text.isNotBlank()

    companion object {
        fun default(): AddRecipeUiState {
            return AddRecipeUiState(
                name = TextFieldValue(),
                duration = TextFieldValue(),
                ingredients = TextFieldValue(),
                instructions = TextFieldValue(),
            )
        }
    }
}
