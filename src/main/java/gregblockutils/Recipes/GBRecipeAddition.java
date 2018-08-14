package gregblockutils.Recipes;

import exnihilocreatio.compatibility.jei.sieve.SieveRecipe;
import exnihilocreatio.registries.manager.ExNihiloRegistryManager;
import exnihilocreatio.registries.types.Siftable;
import gregtech.api.recipes.Recipe;
import gregtech.api.recipes.builders.SimpleRecipeBuilder;
import net.minecraft.item.ItemStack;

public class GBRecipeAddition {
    public static void postInit() {
        for (SieveRecipe recipe : ExNihiloRegistryManager.SIEVE_REGISTRY.getRecipeList()) {

            SimpleRecipeBuilder builder = GBRecipeMaps.SIEVE_RECIPES.recipeBuilder();
            builder.notConsumable(recipe.getMesh()).inputs((ItemStack) recipe.getInputs().get(0));
            for (Siftable siftable : ExNihiloRegistryManager.SIEVE_REGISTRY.getDrops((ItemStack) recipe.getInputs().get(0))) {
                builder.chancedOutput(siftable.getDrop().getItemStack(), (int) (siftable.getChance() * (float) Recipe.getMaxChancedValue()));
            }
            builder.duration(20).EUt(16);
            builder.buildAndRegister();
        }
    }
}
