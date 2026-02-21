package com.mcloo.recipes.shared.recipelist

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier

@Composable
fun RecipeListScreen(
    viewModel: RecipeListViewModel,
    modifier: Modifier = Modifier,
) {
    val state = viewModel.state.collectAsState()

    RecipeListContent(
        state = state.value,
        modifier = modifier,
    )
}
