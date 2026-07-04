package com.mcloo.recipes.shared.di

import com.mcloo.recipes.shared.data.DebugRecipeRepository
import com.mcloo.recipes.shared.data.repositories.RecipeRepository

object DependencyContainer {
    val recipeRepository: RecipeRepository by lazy {
        DebugRecipeRepository()
    }
}
