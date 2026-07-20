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
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mcloo.recipes.shared.displaymodels.RecipeDisplayModel
import com.mcloo.recipes.shared.ui.UiImage
import com.mcloo.recipes.shared.ui.components.ImageWrapper
import com.mcloo.recipes.shared.ui.components.InlineIconText
import com.mcloo.recipes.shared.ui.sharedBounds
import com.mcloo.recipes.shared.ui.sharedElement
import com.mcloo.recipes.shared.ui.theme.McLooTheme

@Composable
fun RecipeDetailContent(
    state: RecipeDetailUiState,
    modifier: Modifier = Modifier,
) {
    val recipe = state.recipe ?: return

    Surface(
        modifier = modifier
            .fillMaxSize(),
    ) {
        Column(
            modifier = Modifier
                .verticalScroll(rememberScrollState()),
        ) {
            Image(
                recipe = recipe,
                modifier = Modifier
                    .aspectRatio(2F),
            )

            Column(
                verticalArrangement = Arrangement.spacedBy(16.dp),
                modifier = Modifier
                    .padding(16.dp),
            ) {
                NameDuration(
                    recipe = recipe,
                )

                Ingredients(
                    recipe = recipe,
                )

                Instructions(
                    recipe = recipe,
                )
            }
        }
    }
}

@Composable
private fun NameDuration(
    recipe: RecipeDisplayModel,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier,
    ) {
        Text(
            text = recipe.name,
            style = MaterialTheme.typography.displaySmall,
            modifier = Modifier
                .sharedBounds(recipe.nameSharedElementKey),
        )

        InlineIconText(
            text = recipe.duration,
            icon = Icons.Default.History,
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier
                .padding(top = 4.dp)
                .sharedBounds(recipe.durationSharedElementKey),
        )
    }
}

@Composable
private fun Image(
    recipe: RecipeDisplayModel,
    modifier: Modifier = Modifier,
) {
    ImageWrapper(
        image = recipe.image,
        contentDescription = null,
        contentScale = ContentScale.Crop,
        modifier = modifier
            .sharedElement(recipe.imageSharedElementKey),
    )
}

@Composable
private fun Ingredients(
    recipe: RecipeDisplayModel,
    modifier: Modifier = Modifier,
) {
    IngredientsListCard(
        ingredients = recipe.ingredients,
        onCopyClick = {},
        modifier = modifier,
    )
}

@Composable
private fun Instructions(
    recipe: RecipeDisplayModel,
    modifier: Modifier = Modifier,
) {
    InstructionsListCard(
        instructions = recipe.instructions,
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
