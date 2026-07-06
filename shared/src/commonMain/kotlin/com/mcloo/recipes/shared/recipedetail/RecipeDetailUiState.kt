package com.mcloo.recipes.shared.recipedetail

import com.mcloo.recipes.shared.displaymodels.RecipeDisplayModel

data class RecipeDetailUiState(
    val recipe: RecipeDisplayModel?,
) {
    companion object {
        fun default(): RecipeDetailUiState {
            return RecipeDetailUiState(
                recipe = null,
            )
        }
    }
}
