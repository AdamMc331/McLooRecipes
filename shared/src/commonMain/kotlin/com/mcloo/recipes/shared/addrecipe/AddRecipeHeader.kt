package com.mcloo.recipes.shared.addrecipe

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun AddRecipeHeader(
    modifier: Modifier = Modifier,
) {
    Surface(
        modifier = modifier,
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .padding(16.dp),
        ) {
            Icon(
                imageVector = Icons.Default.Close,
                contentDescription = null,
            )

            Text(
                text = "Add Recipe",
                style = MaterialTheme.typography.titleLarge,
            )

            Button(
                onClick = {},
                shape = RoundedCornerShape(8.dp),
            ) {
                Text(
                    text = "Save",
                )
            }
        }
    }
}

@Composable
@Preview
fun AddRecipeHeaderPreview() {
    AddRecipeHeader(
        modifier = Modifier
            .fillMaxWidth(),
    )
}
