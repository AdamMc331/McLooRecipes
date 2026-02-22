package com.mcloo.recipes.shared.addrecipe

import androidx.compose.ui.text.input.TextFieldValue
import androidx.lifecycle.ViewModel
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
        // TODO: Save recipe
    }

    fun onCloseClick() {
        // TODO: Navigate back
    }
}
