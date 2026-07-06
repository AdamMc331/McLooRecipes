package com.mcloo.recipes.shared.di

import com.mcloo.recipes.shared.data.remote.FirebaseRecipeRepository
import com.mcloo.recipes.shared.data.repositories.RecipeRepository
import org.koin.dsl.module

val repositoryModule = module {
    single<RecipeRepository> {
        FirebaseRecipeRepository()
    }
}
