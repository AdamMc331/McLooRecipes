package com.mcloo.recipes.shared

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation3.runtime.NavBackStack
import androidx.navigation3.runtime.NavEntry
import androidx.navigation3.runtime.NavKey
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.ui.NavDisplay
import androidx.savedstate.serialization.SavedStateConfiguration
import com.mcloo.recipes.shared.addrecipe.AddRecipeScreen
import com.mcloo.recipes.shared.addrecipe.AddRecipeViewModel
import com.mcloo.recipes.shared.data.remote.FirebaseRecipeRepository
import com.mcloo.recipes.shared.recipedetail.RecipeDetailScreen
import com.mcloo.recipes.shared.recipedetail.RecipeDetailViewModel
import com.mcloo.recipes.shared.recipelist.RecipeListScreen
import com.mcloo.recipes.shared.recipelist.RecipeListViewModel
import kotlinx.serialization.modules.SerializersModule
import kotlinx.serialization.modules.polymorphic

private val config = SavedStateConfiguration {
    serializersModule = SerializersModule {
        polymorphic(NavKey::class) {
            subclass(Route.RecipeList::class, Route.RecipeList.serializer())
            subclass(Route.AddRecipe::class, Route.AddRecipe.serializer())
            subclass(Route.RecipeDetail::class, Route.RecipeDetail.serializer())
        }
    }
}

@Composable
fun AppNavHost(
    modifier: Modifier = Modifier,
) {
    val backStack = rememberNavBackStack(config, Route.RecipeList)

    NavDisplay(
        backStack = backStack,
        modifier = modifier,
        entryProvider = { key ->
            when (key) {
                Route.RecipeList -> {
                    NavEntry(key) {
                        RecipeListEntry(backStack)
                    }
                }

                Route.AddRecipe -> {
                    NavEntry(key) {
                        AddRecipeEntry(backStack)
                    }
                }

                is Route.RecipeDetail -> {
                    NavEntry(key) {
                        RecipeDetailEntry(key)
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

@Composable
private fun RecipeDetailEntry(key: Route.RecipeDetail) {
    RecipeDetailScreen(
        recipeId = key.id,
    )
}

@Composable
private fun AddRecipeEntry(backStack: NavBackStack<NavKey>) {
    AddRecipeScreen(
        onComplete = {
            if (backStack.isNotEmpty()) {
                backStack.removeAt(backStack.size - 1)
            }
        },
    )
}

@Composable
private fun RecipeListEntry(backStack: NavBackStack<NavKey>) {
    RecipeListScreen(
        navigateToAddRecipe = {
            backStack.add(Route.AddRecipe)
        },
        navigateToRecipeDetail = { id ->
            backStack.add(Route.RecipeDetail(id = id))
        },
    )
}
