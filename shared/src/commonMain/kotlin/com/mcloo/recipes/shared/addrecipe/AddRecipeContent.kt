package com.mcloo.recipes.shared.addrecipe

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
@Suppress("LongParameterList")
fun AddRecipeContent(
    state: AddRecipeUiState,
    onNameChange: (TextFieldValue) -> Unit,
    onDurationChange: (TextFieldValue) -> Unit,
    onIngredientsChange: (TextFieldValue) -> Unit,
    onInstructionsChange: (TextFieldValue) -> Unit,
    modifier: Modifier = Modifier,
) {
    Surface(
        modifier = modifier
            .fillMaxSize(),
    ) {
        Column {
            AddRecipeHeader(
                modifier = Modifier
                    .fillMaxWidth(),
            )

            Column(
                verticalArrangement = Arrangement.spacedBy(16.dp),
                modifier = Modifier
                    .verticalScroll(rememberScrollState())
                    .fillMaxWidth()
                    .padding(16.dp),
            ) {
                NameInputSection(
                    value = state.name,
                    onValueChange = onNameChange,
                )

                DurationInputSection(
                    value = state.duration,
                    onValueChange = onDurationChange,
                )

                IngredientsInputSection(
                    value = state.ingredients,
                    onValueChange = onIngredientsChange,
                )

                InstructionsInputSection(
                    value = state.instructions,
                    onValueChange = onInstructionsChange,
                )
            }
        }
    }
}

@Composable
@Preview
fun AddRecipeContentPreviewEmpty() {
    AddRecipeContent(
        state = AddRecipeUiState.default(),
        onNameChange = {},
        onDurationChange = {},
        onIngredientsChange = {},
        onInstructionsChange = {},
    )
}
