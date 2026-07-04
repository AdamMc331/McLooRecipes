package com.mcloo.recipes.shared.recipelist

import androidx.compose.ui.text.input.TextFieldValue

sealed interface RecipeListUiEvent {
    data object AddRecipeClicked : RecipeListUiEvent

    data class RecipeClicked(
        val recipeId: String,
    ) : RecipeListUiEvent

    data class SearchTextChanged(
        val searchText: TextFieldValue,
    ) : RecipeListUiEvent
}
