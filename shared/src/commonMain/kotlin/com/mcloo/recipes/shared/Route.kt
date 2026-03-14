package com.mcloo.recipes.shared

import androidx.navigation3.runtime.NavKey
import kotlinx.serialization.Serializable

@Serializable
sealed interface Route : NavKey {
    @Serializable
    data object RecipeList : Route

    @Serializable
    data object AddRecipe : Route

    @Serializable
    data class RecipeDetail(
        val id: String,
    ) : Route
}
