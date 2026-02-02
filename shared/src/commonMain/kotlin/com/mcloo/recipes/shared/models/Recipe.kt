package com.mcloo.recipes.shared.models

data class Recipe(
    val id: String,
    val name: String,
    val duration: String,
    val tags: List<String>,
    val ingredients: List<String>,
    val instructions: List<String>,
)
