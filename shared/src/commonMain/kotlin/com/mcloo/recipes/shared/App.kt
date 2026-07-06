package com.mcloo.recipes.shared

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.mcloo.recipes.shared.di.appModules
import com.mcloo.recipes.shared.ui.theme.McLooTheme
import org.koin.compose.KoinApplication
import org.koin.compose.KoinMultiplatformApplication
import org.koin.dsl.KoinConfiguration

@Preview
@Composable
fun App() {
    KoinApplication(
        configuration = KoinConfiguration {
            modules(appModules)
        },
    ) {
        McLooTheme {
            Surface {
                AppNavHost(
                    modifier = Modifier
                        .fillMaxSize(),
                )
            }
        }
    }
}
