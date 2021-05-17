package com.teamaurora.dumbores.datagen.recipe;

import com.teamaurora.dumbores.common.core.DumbOres;
import com.teamaurora.dumbores.common.core.registry.DOBlocks;
import net.minecraft.data.CookingRecipeBuilder;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.IFinishedRecipe;
import net.minecraft.data.RecipeProvider;
import net.minecraft.item.Items;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.IItemProvider;

import java.util.Objects;
import java.util.function.Consumer;

public class DORecipeProvider extends RecipeProvider {

    public DORecipeProvider(DataGenerator dataGenerator) {
        super(dataGenerator);
    }

    @Override
    protected void buildShapelessRecipes(Consumer<IFinishedRecipe> consumer) {
        this.smeltingRecipe(DOBlocks.ORE_ORE.get(), Items.COBBLESTONE, 0.0F, consumer);

        this.blastingRecipe(DOBlocks.ORE_ORE.get(), Items.COBBLESTONE, 0.0F, consumer);
    }

    protected void smeltingRecipe(IItemProvider ingredient, IItemProvider result, float experience, Consumer<IFinishedRecipe> consumer) {
        String ingredientName = itemName(result);
        CookingRecipeBuilder.smelting(Ingredient.of(ingredient), result, experience, 200)
                .unlockedBy("has_" + ingredientName, has(ingredient))
                .save(consumer, DumbOres.resourceLoc(ingredientName + "_from_smelting"));
    }

    protected void blastingRecipe(IItemProvider ingredient, IItemProvider result, float experience, Consumer<IFinishedRecipe> consumer) {
        String ingredientName = itemName(ingredient);
        String resultName = itemName(result);

        CookingRecipeBuilder.blasting(Ingredient.of(ingredient), result, experience, 100)
                .unlockedBy("has_" + ingredientName, has(ingredient))
                .save(consumer, DumbOres.resourceLoc(resultName + "_from_" + ingredientName + "_blasting"));
    }

    protected String itemName(IItemProvider criterionItem) {
        return Objects.requireNonNull(criterionItem.asItem().getRegistryName()).getPath();
    }

}