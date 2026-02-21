package com.mcloo.recipes.shared.data

import com.mcloo.recipes.shared.data.repositories.RecipeRepository
import com.mcloo.recipes.shared.models.Recipe
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.map

class DebugRecipeRepository : RecipeRepository {
    private val debugRecipes = listOf(
        Recipe(
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
        ),
        Recipe(
            id = "lobster",
            name = "Ginger Scallion Lobster",
            duration = "1 hr",
            tags = listOf("Dinner"),
            ingredients = listOf(
                "Ginger",
                "Scallions",
                "Garlic",
                "Salt",
                "Corn Starch",
                "Lobster Tails",
                "Misc Sauces",
                "Eggs",
            ),
            instructions = listOf(
                "Cut sharp parts and fins off of tails. Cut into pieces.",
                "Mix salt, corn starch, and lobster tails in a large bowl",
                "Heat wok and sautee white parts of scallions, garlic, and ginger",
                "Add lobster and stir occasionally until cooked and bright red",
                "If dry, add small amounts of water. If too wet, add cornstarch",
                "Once done, mix in sauces and cook another 1-2 minutes",
                "Add eggs - do not stir, but mix softly to seal in sauce",
                "Top with green onions and serve over rice",
            ),
        ),
    )

    override fun getRecipes(query: String): Flow<List<Recipe>> {
        return flowOf(debugRecipes).map { recipes ->
            recipes.filter { recipe ->
                recipe.name.contains(query) || recipe.ingredients.any { ingredient ->
                    ingredient.contains(query)
                }
            }
        }
    }
}
