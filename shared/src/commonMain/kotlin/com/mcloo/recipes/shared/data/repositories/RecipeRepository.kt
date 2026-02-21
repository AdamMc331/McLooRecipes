package com.mcloo.recipes.shared.data.repositories

import com.mcloo.recipes.shared.models.Recipe
import kotlinx.coroutines.flow.Flow

interface RecipeRepository {
    fun getRecipes(
        query: String,
    ): Flow<List<Recipe>>
}
