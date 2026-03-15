package com.mcloo.recipes.shared.addrecipe

import androidx.compose.ui.graphics.vector.Path
import androidx.compose.ui.text.input.TextFieldValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mcloo.recipes.shared.data.repositories.RecipeRepository
import com.mcloo.recipes.shared.models.Recipe
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class AddRecipeViewModel(
    private val recipeRepository: RecipeRepository,
) : ViewModel() {
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

            AddRecipeUiEvent.CompletionHandled -> {
                handleCompletion()
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
        val recipe = buildRecipe()

        viewModelScope.launch {
            // Need loading state
            recipeRepository.saveRecipe(recipe)

            mutableState.update { currentState ->
                currentState.copy(
                    isComplete = true,
                )
            }
        }
    }

    private fun onCloseClick() {
        mutableState.update { currentState ->
            currentState.copy(
                isComplete = true,
            )
        }
    }

    private fun handleCompletion() {
        mutableState.update { currentState ->
            currentState.copy(
                isComplete = false,
            )
        }
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
