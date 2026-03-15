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
fun AddRecipeContent(
    state: AddRecipeUiState,
    onEvent: (AddRecipeUiEvent) -> Unit,
    modifier: Modifier = Modifier,
) {
    Surface(
        modifier = modifier
            .fillMaxSize(),
    ) {
        Column {
            AddRecipeHeader(
                saveButtonEnabled = state.saveButtonEnabled,
                onCloseClick = {
                    onEvent.invoke(AddRecipeUiEvent.CloseClicked)
                },
                onSaveClick = {
                    onEvent.invoke(AddRecipeUiEvent.SaveClicked)
                },
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
                    onValueChange = { name ->
                        onEvent.invoke(AddRecipeUiEvent.NameChanged(name))
                    },
                )

                DurationInputSection(
                    value = state.duration,
                    onValueChange = { duration ->
                        onEvent.invoke(AddRecipeUiEvent.DurationChanged(duration))
                    },
                )

                IngredientsInputSection(
                    value = state.ingredients,
                    onValueChange = { ingredients ->
                        onEvent.invoke(AddRecipeUiEvent.IngredientsChanged(ingredients))
                    },
                )

                InstructionsInputSection(
                    value = state.instructions,
                    onValueChange = { instructions ->
                        onEvent.invoke(AddRecipeUiEvent.InstructionsChanged(instructions))
                    },
                )
            }
        }
    }
}

@Composable
@Preview
fun AddRecipeContentEmptyPreview() {
    AddRecipeContent(
        state = AddRecipeUiState.default(),
        onEvent = {},
    )
}

@Composable
@Preview
fun AddRecipeContentFilledPreview() {
    AddRecipeContent(
        state = AddRecipeUiState(
            name = TextFieldValue("Crispy Chicken Thighs"),
            duration = TextFieldValue("30 min"),
            ingredients = TextFieldValue("Salt\nPepper\nPaprika\nGarlic Powder\nBone-in, skin on chicken thighs"),
            isComplete = false,
            instructions = TextFieldValue(
                "Season skin side with salt\n" +
                    "Season meat side with salt, pepper, garlic powder, and paprika\n" +
                    "Place on cold saucepan skin side down for 15 minutes, until crispy\n" +
                    "Flip and cook until done, 165 degrees\n",
            ),
        ),
        onEvent = {},
    )
}
