package com.mcloo.recipes.shared

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.mcloo.recipes.shared.ui.theme.McLooTheme

@Preview
@Composable
fun App() {
    McLooTheme {
        Surface {
            AppNavHost(
                modifier = Modifier
                    .fillMaxSize(),
            )
        }
    }
}
