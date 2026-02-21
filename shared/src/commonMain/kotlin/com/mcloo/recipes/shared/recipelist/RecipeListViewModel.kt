package com.mcloo.recipes.shared.recipelist

import androidx.compose.ui.text.input.TextFieldValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mcloo.recipes.shared.data.repositories.RecipeRepository
import com.mcloo.recipes.shared.displaymodels.RecipeDisplayModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn

@OptIn(ExperimentalCoroutinesApi::class)
class RecipeListViewModel(
    private val repository: RecipeRepository,
) : ViewModel() {
    private val searchText = MutableStateFlow(TextFieldValue())

    private val recipes = searchText
        .map { it.text }
        .distinctUntilChanged()
        .flatMapLatest { query ->
            repository.getRecipes(query)
        }.map { recipes ->
            recipes.map(::RecipeDisplayModel)
        }

    val state = combine(searchText, recipes) { searchText, recipes ->
        RecipeListUiState(
            searchText = searchText,
            recipes = recipes,
        )
    }.stateIn(
        scope = viewModelScope,
        started = SharingStarted.Lazily,
        initialValue = RecipeListUiState.default(),
    )

    fun onSearchTextChanged(searchText: TextFieldValue) {
        this.searchText.value = searchText
    }
}
