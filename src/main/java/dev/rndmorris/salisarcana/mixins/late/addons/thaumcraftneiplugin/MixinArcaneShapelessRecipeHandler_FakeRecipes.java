package dev.rndmorris.salisarcana.mixins.late.addons.thaumcraftneiplugin;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

import com.djgiannuzz.thaumcraftneiplugin.nei.recipehandler.ArcaneShapelessRecipeHandler;
import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;

import dev.rndmorris.salisarcana.common.recipes.NeiOnlyRecipeRegistry;

@Mixin(value = ArcaneShapelessRecipeHandler.class, remap = false)
public abstract class MixinArcaneShapelessRecipeHandler_FakeRecipes {

    @WrapOperation(
        method = { "loadCraftingRecipes(Ljava/lang/String;[Ljava/lang/Object;)V",
            "loadCraftingRecipes(Lnet/minecraft/item/ItemStack;)V",
            "loadUsageRecipes(Lnet/minecraft/item/ItemStack;)V" },
        at = @At(value = "INVOKE", target = "Lthaumcraft/api/ThaumcraftApi;getCraftingRecipes()Ljava/util/List;"))
    private List<Object> wrapLoadCraftingRecipes(Operation<List<Object>> original) {
        return Stream.concat(
            original.call()
                .stream(),
            NeiOnlyRecipeRegistry.getInstance().shapelessArcaneRecipes.stream())
            .collect(Collectors.toList());
    }

}
