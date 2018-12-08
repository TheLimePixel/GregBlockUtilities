package gregblockutils.Recipes;

import exnihilocreatio.ModBlocks;
import forestry.core.ModuleCore;
import gregblockutils.Machines.GBTileEntities;
import gregtech.api.metatileentity.MetaTileEntity;
import gregtech.api.recipes.ModHandler;
import gregtech.api.unification.material.Materials;
import gregtech.api.unification.ore.OrePrefix;
import gregtech.api.unification.stack.UnificationEntry;
import gregtech.common.blocks.BlockMachineCasing;
import gregtech.common.blocks.MetaBlocks;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;

import java.util.Arrays;

import static gregblockutils.Recipes.GBCraftingComponents.*;


public class GBMachineRecipes {
    public static void init() {
        ModHandler.addShapedRecipe("steam_pump", GBTileEntities.STEAM_PUMP.getStackForm(), "NLN", "NMN", "LRL", 'N', new UnificationEntry(OrePrefix.pipeMedium, Materials.Bronze), 'L', new UnificationEntry(OrePrefix.pipeLarge, Materials.Bronze), 'M', MetaBlocks.MACHINE_CASING.getItemVariant(BlockMachineCasing.MachineCasingType.BRONZE_HULL), 'R', new UnificationEntry(OrePrefix.rotor, Materials.Bronze));
        ModHandler.addShapedRecipe("steam_rock_breaker", GBTileEntities.STEAM_BREAKER.getStackForm(), "BPB", "BMB", "GGG", 'P', new ItemStack(Blocks.PISTON), 'M', MetaBlocks.MACHINE_CASING.getItemVariant(BlockMachineCasing.MachineCasingType.BRONZE_HULL), 'B', new UnificationEntry(OrePrefix.pipeSmall, Materials.Bronze), 'G', new UnificationEntry(OrePrefix.block, Materials.Glass));
        registerMachineRecipe(GBTileEntities.ELECTRIC_SIEVE, "CPC", "FMF", "OSO", 'M', HULL, 'C', CIRCUIT, 'O', CABLE, 'F', CONVEYOR, 'S', new ItemStack(ModBlocks.sieve), 'P', PISTON);
        registerMachineRecipe(GBTileEntities.BEE_ATTRACTOR, "CGC", "FMF", "SPS", 'M', HULL, 'C', CABLE, 'G', GLASS, 'F', ModuleCore.getItems().impregnatedCasing.getItemStack(), 'S', CIRCUIT, 'P', PUMP);
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
