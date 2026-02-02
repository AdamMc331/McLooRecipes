package com.mcloo.recipes.shared.displaymodels

import com.mcloo.recipes.shared.ui.UiImage

data class RecipeDisplayModel(
    val id: String,
    val name: String,
    val duration: String,
    val tags: List<String>,
    val ingredients: List<String>,
    val instructions: List<String>,
    val image: UiImage,
)
