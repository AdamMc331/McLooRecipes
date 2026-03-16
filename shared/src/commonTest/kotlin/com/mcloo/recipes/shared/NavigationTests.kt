package com.mcloo.recipes.shared

import androidx.compose.ui.test.ExperimentalTestApi
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.runComposeUiTest
import com.mcloo.recipes.shared.addrecipe.ADD_RECIPE_SCREEN_TAG
import com.mcloo.recipes.shared.recipelist.ADD_RECIPE_BUTTON
import com.mcloo.recipes.shared.recipelist.RECIPE_LIST_SCREEN_TAG
import kotlin.test.Test

@OptIn(ExperimentalTestApi::class)
class NavigationTests {
    @Test
    fun launchRecipeListScreen() = runComposeUiTest {
        setContent {
            AppNavHost()
        }

        onNodeWithTag(RECIPE_LIST_SCREEN_TAG).assertIsDisplayed()
    }

    @Test
    fun navigateToAddRecipe() = runComposeUiTest {
        setContent {
            AppNavHost()
        }

        onNodeWithTag(RECIPE_LIST_SCREEN_TAG).assertIsDisplayed()
        onNodeWithTag(ADD_RECIPE_BUTTON).performClick()
        onNodeWithTag(ADD_RECIPE_SCREEN_TAG).assertIsDisplayed()
    }
}
