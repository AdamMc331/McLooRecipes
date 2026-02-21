package com.mcloo.recipes.shared.recipelist

import androidx.compose.ui.text.input.TextFieldValue
import com.mcloo.recipes.shared.displaymodels.RecipeDisplayModel

data class RecipeListUiState(
    val searchText: TextFieldValue,
    val recipes: List<RecipeDisplayModel>,
) {
    companion object {
        fun default(): RecipeListUiState {
            return RecipeListUiState(
                searchText = TextFieldValue(),
                recipes = emptyList(),
            )
        }
    }
}
