package com.mcloo.recipes.shared.displaymodels

import com.mcloo.recipes.shared.models.Recipe
import com.mcloo.recipes.shared.ui.UiImage

data class RecipeDisplayModel(
    val id: String,
    val name: String,
    val duration: String,
    val tags: List<String>,
    val ingredients: List<String>,
    val instructions: List<String>,
    val image: UiImage,
) {
    constructor(recipe: Recipe) : this(
        id = recipe.id,
        name = recipe.name,
        duration = recipe.duration,
        tags = recipe.tags,
        ingredients = recipe.ingredients,
        instructions = recipe.instructions,
        image = if (recipe.imageUrl != null) {
            UiImage.Remote(recipe.imageUrl)
        } else {
            UiImage.Placeholder
        },
    )

    val imageSharedElementKey = "RecipeImage_$id"

    val nameSharedElementKey = "RecipeTitle_$id"

    val durationSharedElementKey = "RecipeDuration_$id"
}
