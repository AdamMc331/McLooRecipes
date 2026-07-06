package com.mcloo.recipes.shared.recipedetail

import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import com.mcloo.recipes.shared.displaymodels.RecipeDisplayModel

@Composable
fun RecipeDetailScreen(
    viewModel: RecipeDetailViewModel,
    modifier: Modifier = Modifier,
) {
    val state = viewModel.state.collectAsState()

    RecipeDetailContent(
        state = state.value,
        modifier = modifier,
    )
}
