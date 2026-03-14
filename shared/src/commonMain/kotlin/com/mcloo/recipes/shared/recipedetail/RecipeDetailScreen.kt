package com.mcloo.recipes.shared.recipedetail

import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun RecipeDetailScreen(
    id: String,
    modifier: Modifier = Modifier,
) {
    Text(
        text = "Recipe Detail: $id",
        modifier = modifier.statusBarsPadding(),
    )
}
