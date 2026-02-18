package com.mcloo.recipes.shared.recipelist

import androidx.compose.ui.text.input.TextFieldValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mcloo.recipes.shared.data.repositories.RecipeRepository
import com.mcloo.recipes.shared.displaymodels.RecipeDisplayModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.update

class RecipeListViewModel(
    private val repository: RecipeRepository,
) : ViewModel() {
    private val mutableState = MutableStateFlow(RecipeListUiState.default())

    val state = mutableState.asStateFlow()

    init {
        state
            .map { state ->
                state.searchText
            }.distinctUntilChanged()
            .onEach { searchText ->
                repository.getRecipes(searchText.text).collect { recipes ->
                    val displayModels = recipes.map(::RecipeDisplayModel)

                    mutableState.update { currentState ->
                        currentState.copy(
                            recipes = displayModels,
                        )
                    }
                }
            }.launchIn(viewModelScope)
    }

    fun onSearchTextChanged(searchText: TextFieldValue) {
        mutableState.update { currentState ->
            currentState.copy(
                searchText = searchText,
            )
        }
    }
}
