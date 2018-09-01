package gregblockutils.Recipes;

import exnihilocreatio.ModBlocks;
import gregblockutils.Machines.GBTileEntities;
import gregtech.api.metatileentity.MetaTileEntity;
import gregtech.api.recipes.ModHandler;
import gregtech.api.unification.material.Materials;
import gregtech.api.unification.ore.OrePrefix;
import gregtech.api.unification.stack.UnificationEntry;
import gregtech.common.blocks.BlockMachineCasing;
import gregtech.common.blocks.MetaBlocks;
import net.minecraft.item.ItemStack;

import java.util.Arrays;

import static gregblockutils.Recipes.GBCraftingComponents.*;


public class GBMachineRecipes {
    public static void init() {
        ModHandler.addShapedRecipe("steam_pump", GBTileEntities.STEAM_PUMP.getStackForm(), "NLN", "NMN", "LRL", 'N', new UnificationEntry(OrePrefix.pipeMedium, Materials.Bronze), 'L', new UnificationEntry(OrePrefix.pipeLarge, Materials.Bronze), 'M', MetaBlocks.MACHINE_CASING.getItemVariant(BlockMachineCasing.MachineCasingType.BRONZE_HULL), 'R', new UnificationEntry(OrePrefix.rotor, Materials.Bronze));
        registerMachineRecipe(GBTileEntities.ELECTRIC_SIEVE, "CPC", "FMF", "OSO", 'M', HULL, 'C', CIRCUIT, 'O', CABLE, 'F', CONVEYOR, 'S', new ItemStack(ModBlocks.sieve), 'P', PISTON);
    }

    public static <T extends MetaTileEntity> void registerMachineRecipe(T[] metaTileEntities, Object... recipe) {
        for (int i = 0; i < metaTileEntities.length; i++) {
            if (metaTileEntities[i] != null)
                ModHandler.addShapedRecipe(String.format("gb_%s", metaTileEntities[i].getMetaName()), metaTileEntities[i].getStackForm(), prepareRecipe(i + 1, Arrays.copyOf(recipe, recipe.length)));
        }
    }

    private static Object[] prepareRecipe(int tier, Object... recipe) {
        for (int i = 3; i < recipe.length; i++) {
            if (recipe[i] instanceof GBCraftingComponents) {
                recipe[i] = ((GBCraftingComponents) recipe[i]).getIngredient(tier);
            }
        }
        return recipe;
    }
}
