package com.mcloo.recipes.shared.data.remote

import com.mcloo.recipes.shared.data.repositories.RecipeRepository
import com.mcloo.recipes.shared.models.Recipe
import dev.gitlive.firebase.Firebase
import dev.gitlive.firebase.firestore.firestore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class FirebaseRecipeRepository : RecipeRepository {
    override fun getRecipes(query: String): Flow<List<Recipe>> {
        return Firebase.firestore.collection("recipes").snapshots.map { query ->
            query.documents.map { it.data<FirebaseRecipe>() }.map(FirebaseRecipe::toRecipe)
        }
    }

    override suspend fun saveRecipe(recipe: Recipe) {
        TODO("Not yet implemented")
    }
}
