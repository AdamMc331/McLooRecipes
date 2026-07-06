package com.mcloo.recipes.shared.di

import com.mcloo.recipes.shared.addrecipe.AddRecipeViewModel
import com.mcloo.recipes.shared.recipedetail.RecipeDetailViewModel
import com.mcloo.recipes.shared.recipelist.RecipeListViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel {
        AddRecipeViewModel(
            recipeRepository = get(),
        )
    }

    viewModel { parameters ->
        RecipeDetailViewModel(
            recipeId = parameters.get(),
            recipeRepository = get(),
        )
    }

    viewModel {
        RecipeListViewModel(
            recipeRepository = get(),
        )
    }
}
