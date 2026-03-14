package com.mcloo.recipes.shared.recipelist

import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier

@Composable
fun RecipeListScreen(
    viewModel: RecipeListViewModel,
    onAddRecipeClicked: () -> Unit,
    onRecipeClicked: (String) -> Unit,
    modifier: Modifier = Modifier,
) {
    val state = viewModel.state.collectAsState()

    RecipeListContent(
        state = state.value,
        onAddRecipeClicked = onAddRecipeClicked,
        onRecipeClicked = onRecipeClicked,
        modifier = modifier
            .statusBarsPadding(),
    )
}
