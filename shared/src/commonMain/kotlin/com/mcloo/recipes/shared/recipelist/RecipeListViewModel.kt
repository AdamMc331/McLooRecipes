package com.mcloo.recipes.shared.recipelist

import androidx.compose.ui.text.input.TextFieldValue
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class RecipeListViewModel : ViewModel() {
    private val mutableState = MutableStateFlow(RecipeListUiState.default())

    val state = mutableState.asStateFlow()

    fun onSearchTextChanged(searchText: TextFieldValue) {
        mutableState.update { currentState ->
            currentState.copy(
                searchText = searchText,
            )
        }
    }
}
