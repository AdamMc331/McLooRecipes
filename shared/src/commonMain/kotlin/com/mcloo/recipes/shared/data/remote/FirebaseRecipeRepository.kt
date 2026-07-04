package com.mcloo.recipes.shared.data.remote

import com.mcloo.recipes.shared.data.repositories.RecipeRepository
import com.mcloo.recipes.shared.models.Recipe
import dev.gitlive.firebase.Firebase
import dev.gitlive.firebase.firestore.CollectionReference
import dev.gitlive.firebase.firestore.firestore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

private const val RECIPE_COLLECTION_NAME = "recipes"

class FirebaseRecipeRepository : RecipeRepository {
    private fun recipeCollection(): CollectionReference {
        return Firebase.firestore.collection(RECIPE_COLLECTION_NAME)
    }

    override fun getRecipes(query: String): Flow<List<Recipe>> {
        return recipeCollection().snapshots.map { query ->
            query.documents
                .map { document ->
                    document.data<FirebaseRecipe>().copy(
                        id = document.id,
                    )
                }.map(FirebaseRecipe::toRecipe)
        }
    }

    override suspend fun saveRecipe(recipe: Recipe) {
        val firebaseRecipe = FirebaseRecipe(recipe)

        recipeCollection().document(firebaseRecipe.id).set(firebaseRecipe)
    }
}
