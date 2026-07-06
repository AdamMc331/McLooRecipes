package com.mcloo.recipes.shared.addrecipe

import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import org.koin.compose.viewmodel.koinViewModel

const val ADD_RECIPE_SCREEN_TAG = "AddRecipeScreen"

@Composable
fun AddRecipeScreen(
    onComplete: () -> Unit,
    modifier: Modifier = Modifier,
    viewModel: AddRecipeViewModel = koinViewModel(),
) {
    val state = viewModel.state.collectAsState()

    LaunchedEffect(state.value.isComplete) {
        if (state.value.isComplete) {
            onComplete.invoke()

            viewModel.onEvent(AddRecipeUiEvent.CompletionHandled)
        }
    }

    AddRecipeContent(
        state = state.value,
        onEvent = viewModel::onEvent,
        modifier = modifier
            .testTag(ADD_RECIPE_SCREEN_TAG)
            .statusBarsPadding(),
    )
}
