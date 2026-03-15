package com.mcloo.recipes.shared.recipelist

sealed interface RecipeListUiEvent {
    data object AddRecipeClicked : RecipeListUiEvent

    data class RecipeClicked(
        val recipeId: String,
    ) : RecipeListUiEvent
}
