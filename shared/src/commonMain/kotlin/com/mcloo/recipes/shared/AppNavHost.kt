package com.mcloo.recipes.shared

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation3.runtime.NavEntry
import androidx.navigation3.runtime.NavKey
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.ui.NavDisplay
import androidx.savedstate.serialization.SavedStateConfiguration
import com.mcloo.recipes.shared.addrecipe.AddRecipeScreen
import com.mcloo.recipes.shared.addrecipe.AddRecipeViewModel
import com.mcloo.recipes.shared.data.DebugRecipeRepository
import com.mcloo.recipes.shared.recipelist.RecipeListScreen
import com.mcloo.recipes.shared.recipelist.RecipeListViewModel
import kotlinx.serialization.modules.SerializersModule
import kotlinx.serialization.modules.polymorphic

private val config = SavedStateConfiguration {
    serializersModule = SerializersModule {
        polymorphic(NavKey::class) {
            subclass(Route.RecipeList::class, Route.RecipeList.serializer())
            subclass(Route.AddRecipe::class, Route.AddRecipe.serializer())
        }
    }
}

@Composable
fun AppNavHost(
    modifier: Modifier = Modifier,
) {
    val backStack = rememberNavBackStack(config, Route.RecipeList)

    println("ADAMLOg - BACKSTACK: $backStack")

    NavDisplay(
        backStack = backStack,
        modifier = modifier,
        entryProvider = { key ->
            when (key) {
                Route.RecipeList -> {
                    NavEntry(key) {
                        RecipeListScreen(
                            viewModel = viewModel {
                                RecipeListViewModel(
                                    repository = DebugRecipeRepository(),
                                )
                            },
                            onAddRecipeClicked = {
                                backStack.add(Route.AddRecipe)
                            },
                        )
                    }
                }

                Route.AddRecipe -> {
                    NavEntry(key) {
                        AddRecipeScreen(
                            viewModel = viewModel {
                                AddRecipeViewModel(
                                    recipeRepository = DebugRecipeRepository(),
                                )
                            },
                            onCloseClicked = {
                                if (backStack.isNotEmpty()) {
                                    backStack.dropLast(1)
                                }
                            },
                        )
                    }
                }

                else -> {
                    NavEntry(key) {
                        Text(
                            text = "Invalid Key: $key",
                        )
                    }
                }
            }
        },
    )
}
