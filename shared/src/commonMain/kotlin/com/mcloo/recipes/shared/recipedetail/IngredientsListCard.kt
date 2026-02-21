package com.mcloo.recipes.shared.recipedetail

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ContentCopy
import androidx.compose.material.icons.filled.CopyAll
import androidx.compose.material.icons.filled.LocalGroceryStore
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mcloo.recipes.shared.ui.components.InlineIconText
import com.mcloo.recipes.shared.ui.theme.McLooTheme

@Composable
fun IngredientsListCard(
    ingredients: List<String>,
    onCopyClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Card(
        modifier = modifier,
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp),
        ) {
            IngredientsHeader(
                onCopyClick = onCopyClick,
            )

            Spacer(
                modifier = Modifier
                    .height(8.dp),
            )

            ingredients.forEach { ingredient ->
                IngredientListItem(ingredient)
            }
        }
    }
}

@Composable
private fun IngredientsHeader(
    onCopyClick: () -> Unit,
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
    ) {
        InlineIconText(
            text = "Ingredients",
            icon = Icons.Default.LocalGroceryStore,
            iconTint = MaterialTheme.colorScheme.primary,
            style = MaterialTheme.typography.titleLarge,
            modifier = Modifier
                .weight(1F),
        )

        Button(
            onClick = onCopyClick,
            shape = RoundedCornerShape(8.dp),
        ) {
            Row(
                horizontalArrangement = Arrangement.spacedBy(8.dp),
            ) {
                Icon(
                    imageVector = Icons.Default.ContentCopy,
                    contentDescription = null,
                )

                Text(
                    text = "Copy",
                )
            }
        }
    }
}

@Composable
private fun IngredientListItem(
    ingredient: String,
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(16.dp),
    ) {
        Box(
            modifier = Modifier
                .size(8.dp)
                .clip(CircleShape)
                .background(
                    color = MaterialTheme.colorScheme.primary,
                ),
        )

        Text(
            text = ingredient,
        )
    }
}

@Composable
@Preview
fun IngredientsListCardPreview() {
    McLooTheme {
        IngredientsListCard(
            ingredients = listOf(
                "Salt",
                "Pepper",
                "Paprika",
                "Bone-in, skin on chicken thighs",
            ),
            onCopyClick = {},
            modifier = Modifier
                .fillMaxWidth(),
        )
    }
}
