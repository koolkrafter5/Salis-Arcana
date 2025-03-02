package dev.rndmorris.salisarcana.api;

import net.minecraft.item.ItemStack;

import dev.rndmorris.salisarcana.common.recipes.NeiOnlyRecipeRegistry;
import thaumcraft.api.aspects.AspectList;
import thaumcraft.api.crafting.CrucibleRecipe;
import thaumcraft.api.crafting.InfusionRecipe;
import thaumcraft.api.crafting.ShapedArcaneRecipe;
import thaumcraft.api.crafting.ShapelessArcaneRecipe;

/**
 * Methods to register Thaumcraft recipes that will appear in NEI but should not be registered as a functional recipe.
 */
public interface INeiOnlyRecipeRegistry {

    static INeiOnlyRecipeRegistry getInstance() {
        return NeiOnlyRecipeRegistry.getInstance();
    }

    /**
     * Register a shaped arcane recipe that only appears in NEI and should not be registered as a functional recipe.
     */
    ShapedArcaneRecipe registerFakeShapedArcaneRecipe(ShapedArcaneRecipe recipe);

    /**
     * Register a shaped arcane recipe that only appears in NEI and should not be registered as a functional recipe.
     */
    ShapedArcaneRecipe registerFakeShapedArcaneRecipe(String research, ItemStack result, AspectList aspects,
        Object... recipe);

    /**
     * Register a shapeless arcane recipe that only appears in NEI and should not be registered as a functional recipe.
     */
    ShapelessArcaneRecipe registerFakeShapelessArcaneRecipe(ShapelessArcaneRecipe recipe);

    /**
     * Register a shapeless arcane recipe that only appears in NEI and should not be registered as a functional recipe.
     */
    ShapelessArcaneRecipe registerFakeShapelessArcaneRecipe(String research, ItemStack result, AspectList aspects,
        Object... recipe);

    /**
     * Register a crucible recipe that only appears in NEI and should not be registered as a functional recipe.
     */
    CrucibleRecipe registerFakeCrucibleRecipeHandler(CrucibleRecipe recipe);

    /**
     * Register a crucible recipe that only appears in NEI and should not be registered as a functional recipe.
     */
    CrucibleRecipe registerFakeCrucibleRecipeHandler(String key, ItemStack result, Object catalyst, AspectList tags);

    /**
     * Register an infusion recipe that only appears in NEI and should not be registered as a functional recipe.
     */
    InfusionRecipe registerFakeInfusionRecipeHandler(InfusionRecipe recipe);

    /**
     * Register an infusion recipe that only appears in NEI and should not be registered as a functional recipe.
     */
    InfusionRecipe registerFakeInfusionRecipeHandler(String research, Object result, int instability,
        AspectList aspects, ItemStack input, ItemStack[] recipe);
}
