package com.mcloo.recipes.shared.recipelist

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.History
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
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
import com.mcloo.recipes.shared.ui.theme.McLooTheme

@Composable
fun RecipeListCard(
    recipe: RecipeDisplayModel,
    modifier: Modifier = Modifier,
) {
    Card(
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer,
        ),
        modifier = modifier,
    ) {
        Row(modifier = Modifier.height(IntrinsicSize.Min)) {
            ImageWrapper(
                image = recipe.image,
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .aspectRatio(1f)
                    .fillMaxHeight(),
            )

            Column(
                modifier = Modifier
                    .padding(16.dp),
            ) {
                Text(
                    text = recipe.name,
                    style = MaterialTheme.typography.titleSmall,
                )

                InlineIconText(
                    text = recipe.duration,
                    icon = Icons.Default.History,
                    style = MaterialTheme.typography.labelMedium,
                    modifier = Modifier
                        .padding(top = 4.dp),
                )
            }
        }
    }
}

@Preview
@Composable
fun RecipeListCardPreview() {
    val recipe = RecipeDisplayModel(
        id = "123",
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
        RecipeListCard(
            recipe = recipe,
            modifier = Modifier
                .fillMaxWidth(),
        )
    }
}
