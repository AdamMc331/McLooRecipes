package com.mcloo.recipes.shared.recipedetail

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.History
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mcloo.recipes.shared.displaymodels.RecipeDisplayModel
import com.mcloo.recipes.shared.ui.UiImage
import com.mcloo.recipes.shared.ui.components.ImageWrapper
import com.mcloo.recipes.shared.ui.components.InlineIconText
import com.mcloo.recipes.shared.ui.theme.McLooTheme

@Composable
fun RecipeDetailContent(
    state: RecipeDetailUiState,
    modifier: Modifier = Modifier,
) {
    Surface(
        modifier = modifier
            .fillMaxSize(),
    ) {
        Column(
            modifier = Modifier
                .verticalScroll(rememberScrollState()),
        ) {
            Image(
                state = state,
                modifier = Modifier
                    .aspectRatio(2F),
            )

            Column(
                verticalArrangement = Arrangement.spacedBy(16.dp),
                modifier = Modifier
                    .padding(16.dp),
            ) {
                NameDuration(
                    state = state,
                )

                Ingredients(
                    state = state,
                )

                Instructions(
                    state = state,
                )
            }
        }
    }
}

@Composable
private fun NameDuration(
    state: RecipeDetailUiState,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier,
    ) {
        Text(
            text = state.recipe.name,
            style = MaterialTheme.typography.displaySmall,
        )

        InlineIconText(
            text = state.recipe.duration,
            icon = Icons.Default.History,
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier
                .padding(top = 4.dp),
        )
    }
}

@Composable
private fun Image(
    state: RecipeDetailUiState,
    modifier: Modifier = Modifier,
) {
    ImageWrapper(
        image = state.recipe.image,
        contentDescription = null,
        modifier = modifier,
    )
}

@Composable
private fun Ingredients(
    state: RecipeDetailUiState,
    modifier: Modifier = Modifier,
) {
    IngredientsListCard(
        ingredients = state.recipe.ingredients,
        onCopyClick = {},
        modifier = modifier,
    )
}

@Composable
private fun Instructions(
    state: RecipeDetailUiState,
    modifier: Modifier = Modifier,
) {
    InstructionsListCard(
        instructions = state.recipe.instructions,
        modifier = modifier,
    )
}

@Composable
@Preview
fun RecipeDetailContentPreview() {
    val recipe = RecipeDisplayModel(
        id = "chicken_thighs",
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

    McLooTheme {
        RecipeDetailContent(
            state = RecipeDetailUiState(
                recipe = recipe,
            ),
        )
    }
}
