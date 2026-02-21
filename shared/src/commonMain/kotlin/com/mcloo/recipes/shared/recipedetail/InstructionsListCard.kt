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
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.List
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.LocalGroceryStore
import androidx.compose.material3.Card
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
fun InstructionsListCard(
    instructions: List<String>,
    modifier: Modifier = Modifier,
) {
    Card(
        modifier = modifier,
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp),
        ) {
            InstructionsHeader()

            Spacer(
                modifier = Modifier
                    .height(8.dp),
            )

            instructions.forEach { instruction ->
                InstructionListItem(instruction)
            }
        }
    }
}

@Composable
private fun InstructionsHeader() {
    InlineIconText(
        text = "Instructions",
        icon = Icons.AutoMirrored.Filled.List,
        iconTint = MaterialTheme.colorScheme.primary,
        style = MaterialTheme.typography.titleLarge,
    )
}

@Composable
private fun InstructionListItem(
    instruction: String,
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
            text = instruction,
        )
    }
}

@Composable
@Preview
fun InstructionsListCardPreview() {
    McLooTheme {
        InstructionsListCard(
            instructions = listOf(
                "Season skin side with salt",
                "Season meat side with salt, pepper, garlic powder, and paprika",
                "Place on cold saucepan skin side down for 15 minutes, until crispy",
                "Flip and cook until done, 165 degrees",
            ),
            modifier = Modifier
                .fillMaxWidth(),
        )
    }
}
