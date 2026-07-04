package com.mcloo.recipes.shared.data.remote

import com.mcloo.recipes.shared.models.Recipe
import kotlinx.serialization.Serializable

@Serializable
data class FirebaseRecipe(
    val id: String,
    val name: String,
    val imageUrl: String?,
) {
    fun toRecipe(): Recipe {
        return Recipe(
            id = this.id,
            name = this.name,
            duration = "",
            tags = emptyList(),
            ingredients = emptyList(),
            instructions = emptyList(),
        )
    }
}
