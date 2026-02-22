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

    fun onEvent(
        event: AddRecipeUiEvent,
    ) {
        when (event) {
            AddRecipeUiEvent.CloseClicked -> {
                onCloseClick()
            }

            is AddRecipeUiEvent.DurationChanged -> {
                onDurationChange(event.duration)
            }

            is AddRecipeUiEvent.IngredientsChanged -> {
                onIngredientsChange(event.ingredients)
            }

            is AddRecipeUiEvent.InstructionsChanged -> {
                onInstructionsChange(event.instructions)
            }

            is AddRecipeUiEvent.NameChanged -> {
                onNameChange(event.name)
            }

            AddRecipeUiEvent.SaveClicked -> {
                onSaveClick()
            }
        }
    }

    private fun onNameChange(value: TextFieldValue) {
        mutableState.update { currentState ->
            currentState.copy(
                name = value,
            )
        }
    }

    private fun onDurationChange(value: TextFieldValue) {
        mutableState.update { currentState ->
            currentState.copy(
                duration = value,
            )
        }
    }

    private fun onIngredientsChange(value: TextFieldValue) {
        mutableState.update { currentState ->
            currentState.copy(
                ingredients = value,
            )
        }
    }

    private fun onInstructionsChange(value: TextFieldValue) {
        mutableState.update { currentState ->
            currentState.copy(
                instructions = value,
            )
        }
    }

    private fun onSaveClick() {
        // Save recipe
    }

    private fun onCloseClick() {
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
