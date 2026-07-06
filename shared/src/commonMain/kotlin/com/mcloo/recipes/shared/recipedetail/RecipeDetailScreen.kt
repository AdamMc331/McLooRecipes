package com.mcloo.recipes.shared.recipedetail

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import org.koin.compose.viewmodel.koinViewModel
import org.koin.core.parameter.parametersOf

@Composable
fun RecipeDetailScreen(
    recipeId: String,
    modifier: Modifier = Modifier,
    viewModel: RecipeDetailViewModel = koinViewModel(
        key = "RecipeDetailVm_$recipeId",
        parameters = {
            parametersOf(recipeId)
        },
    ),
) {
    val state = viewModel.state.collectAsState()

    RecipeDetailContent(
        state = state.value,
        modifier = modifier,
    )
}
