package com.mcloo.recipes.shared.addrecipe

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun AddRecipeContent(
    modifier: Modifier = Modifier,
) {
    Surface(
        modifier = modifier
            .fillMaxSize(),
    ) {
        Column {
            AddRecipeHeader(
                modifier = Modifier
                    .fillMaxWidth(),
            )

            Column(
                verticalArrangement = Arrangement.spacedBy(16.dp),
                modifier = Modifier
                    .verticalScroll(rememberScrollState())
                    .fillMaxWidth()
                    .padding(16.dp),
            ) {
                RecipeName()

                CookTime()

                Ingredients()

                Instructions()
            }
        }
    }
}

@Composable
private fun RecipeName() {
    Column {
        Text(
            text = "Recipe Name",
            style = MaterialTheme.typography.titleSmall,
        )

        OutlinedTextField(
            value = TextFieldValue(),
            onValueChange = {},
            placeholder = {
                Text(
                    text = "Crispy Chicken Thighs",
                )
            },
            shape = RoundedCornerShape(8.dp),
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 8.dp),
        )
    }
}

@Composable
private fun CookTime() {
    Column {
        Text(
            text = "Cook Time",
            style = MaterialTheme.typography.titleSmall,
        )

        OutlinedTextField(
            value = TextFieldValue(),
            onValueChange = {},
            placeholder = {
                Text(
                    text = "30 min",
                )
            },
            shape = RoundedCornerShape(8.dp),
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 8.dp),
        )
    }
}

@Composable
private fun Ingredients() {
    Column {
        Text(
            text = "Ingredients",
            style = MaterialTheme.typography.titleSmall,
        )

        OutlinedTextField(
            value = TextFieldValue(),
            onValueChange = {},
            placeholder = {
                Text(
                    text = "Enter each ingredient on a new line",
                )
            },
            shape = RoundedCornerShape(8.dp),
            minLines = 6,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 8.dp),
        )
    }
}

@Composable
private fun Instructions() {
    Column {
        Text(
            text = "Instructions",
            style = MaterialTheme.typography.titleSmall,
        )

        OutlinedTextField(
            value = TextFieldValue(),
            onValueChange = {},
            placeholder = {
                Text(
                    text = "Enter each instruction on a new line",
                )
            },
            shape = RoundedCornerShape(8.dp),
            minLines = 6,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 8.dp),
        )
    }
}

@Composable
@Preview
fun AddRecipeContentPreviewEmpty() {
    AddRecipeContent()
}
