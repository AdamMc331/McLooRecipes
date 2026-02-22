package com.mcloo.recipes.shared.addrecipe

import androidx.compose.ui.text.input.TextFieldValue
import androidx.lifecycle.ViewModel
import com.mcloo.recipes.shared.models.Recipe
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class AddRecipeViewModel : ViewModel() {
    private val mutableState = MutableStateFlow(AddRecipeUiState.default())

    val state = mutableState.asStateFlow()

    fun onNameChange(value: TextFieldValue) {
        mutableState.update { currentState ->
            currentState.copy(
                name = value,
            )
        }
    }

    fun onDurationChange(value: TextFieldValue) {
        mutableState.update { currentState ->
            currentState.copy(
                duration = value,
            )
        }
    }

    fun onIngredientsChange(value: TextFieldValue) {
        mutableState.update { currentState ->
            currentState.copy(
                ingredients = value,
            )
        }
    }

    fun onInstructionsChange(value: TextFieldValue) {
        mutableState.update { currentState ->
            currentState.copy(
                instructions = value,
            )
        }
    }

    fun onSaveClick() {
        // Save recipe
    }

    fun onCloseClick() {
        // Navigate back
    }

    private fun buildRecipe(): Recipe {
        return Recipe(
            id = state.value.name.text, // Replace this?
            name = state.value.name.text,
            duration = state.value.duration.text,
            ingredients = state.value.ingredients.text
                .split("\n"),
            instructions = state.value.instructions.text
                .split("\n"),
            tags = emptyList(),
        )
    }
}
