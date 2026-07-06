package com.mcloo.recipes.shared.data.remote

import com.mcloo.recipes.shared.models.Recipe
import kotlinx.serialization.Serializable

/**
 * Matches the backend configuration of a [Recipe] that is stored on Firebase. May
 * have a different structure from our domain recipe, so this is kept separate
 * and mapped to a domain model via [toRecipe].
 */
@Serializable
data class FirebaseRecipe(
    val name: String,
    val imageUrl: String?,
    val ingredients: List<String>,
    val instructions: List<String>,
    val tags: List<String>,
    val duration: String?,
) {
    constructor(recipe: Recipe) : this(
        name = recipe.name,
        imageUrl = recipe.imageUrl,
        ingredients = recipe.ingredients,
        instructions = recipe.instructions,
        tags = recipe.tags,
        duration = recipe.duration,
    )

    fun toRecipe(
        documentId: String,
    ): Recipe {
        return Recipe(
            id = documentId,
            name = this.name,
            duration = this.duration.orEmpty(),
            tags = this.tags,
            ingredients = this.ingredients,
            instructions = this.instructions,
            imageUrl = this.imageUrl,
        )
    }
}
