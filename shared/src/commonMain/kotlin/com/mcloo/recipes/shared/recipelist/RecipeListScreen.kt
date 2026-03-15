package com.mcloo.recipes.shared.recipelist

import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier

@Composable
fun RecipeListScreen(
    viewModel: RecipeListViewModel,
    navigateToAddRecipe: () -> Unit,
    navigateToRecipeDetail: (String) -> Unit,
    modifier: Modifier = Modifier,
) {
    val state = viewModel.state.collectAsState()

    RecipeListContent(
        state = state.value,
        onEvent = { event ->
            // Ideally these get passed into ViewModel and handled as state, will do in a follow up.
            when (event) {
                RecipeListUiEvent.AddRecipeClicked -> {
                    navigateToAddRecipe.invoke()
                }

                is RecipeListUiEvent.RecipeClicked -> {
                    navigateToRecipeDetail.invoke(event.recipeId)
                }
            }
        },
        modifier = modifier
            .statusBarsPadding(),
    )
}
