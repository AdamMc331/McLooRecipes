package com.mcloo.recipes.shared.recipedetail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mcloo.recipes.shared.data.repositories.RecipeRepository
import com.mcloo.recipes.shared.displaymodels.RecipeDisplayModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class RecipeDetailViewModel(
    recipeId: String,
    private val recipeRepository: RecipeRepository,
) : ViewModel() {
    private val mutableState = MutableStateFlow(RecipeDetailUiState.default())

    val state = mutableState.asStateFlow()

    init {
        viewModelScope.launch {
            recipeRepository
                .getRecipe(recipeId)
                .collect { recipe ->
                    val displayModel = RecipeDisplayModel(recipe)

                    mutableState.update { currentState ->
                        currentState.copy(
                            recipe = displayModel,
                        )
                    }
                }
        }
    }
}
