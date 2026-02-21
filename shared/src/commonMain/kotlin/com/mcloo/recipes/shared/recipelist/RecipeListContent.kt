package com.mcloo.recipes.shared.recipelist

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mcloo.recipes.shared.displaymodels.RecipeDisplayModel
import com.mcloo.recipes.shared.ui.UiImage
import com.mcloo.recipes.shared.ui.theme.McLooTheme

@Composable
fun RecipeListContent(
    state: RecipeListUiState,
    modifier: Modifier = Modifier,
) {
    Surface(
        modifier = modifier,
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize(),
        ) {
            RecipeListHeader(
                searchText = state.searchText,
                onSearchTextChanged = {},
                modifier = Modifier
                    .fillMaxWidth(),
            )

            LazyColumn(
                contentPadding = PaddingValues(16.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp),
            ) {
                items(state.recipes) { recipe ->
                    RecipeListCard(
                        recipe = recipe,
                        modifier = Modifier
                            .fillMaxWidth(),
                    )
                }
            }
        }
    }
}

@Preview
@Composable
@Suppress("MagicNumber")
fun RecipeListContentPreview() {
    val recipes = List(3) { index ->
        RecipeDisplayModel(
            id = index.toString(),
            name = "Crispy Chicken Thighs",
            duration = "30 min",
            tags = listOf("Dinner"),
            ingredients = listOf(
                "Salt",
                "Pepper",
                "Garlic Powder",
                "Paprika",
                "Bone-in skin-on Chicken Thighs",
            ),
            instructions = listOf(
                "Season skin side with salt",
                "Season meat side with salt, pepper, garlic powder, and paprika",
                "Place on cold saucepan skin side down for 15 minutes, until crispy",
                "Flip and cook until done, 165 degrees",
            ),
            image = UiImage.Placeholder,
        )
    }

    val state = RecipeListUiState(
        searchText = TextFieldValue(),
        recipes = recipes,
    )

    McLooTheme {
        RecipeListContent(
            state = state,
            modifier = Modifier
                .fillMaxWidth(),
        )
    }
}
