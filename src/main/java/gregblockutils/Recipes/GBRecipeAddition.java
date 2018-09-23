package gregblockutils.Recipes;

import binnie.extrabees.genetics.ExtraBeeDefinition;
import exnihilocreatio.compatibility.jei.sieve.SieveRecipe;
import exnihilocreatio.registries.manager.ExNihiloRegistryManager;
import exnihilocreatio.registries.types.Siftable;
import forestry.api.apiculture.BeeManager;
import forestry.api.apiculture.EnumBeeType;
import forestry.apiculture.genetics.BeeDefinition;
import forestry.core.fluids.Fluids;
import gregblockutils.Items.GBPebble;
import gregtech.api.recipes.ModHandler;
import gregtech.api.recipes.Recipe;
import gregtech.api.recipes.RecipeMaps;
import gregtech.api.recipes.builders.SimpleRecipeBuilder;
import gregtech.api.unification.OreDictUnifier;
import gregtech.api.unification.material.Materials;
import gregtech.api.unification.material.type.DustMaterial;
import gregtech.api.unification.material.type.GemMaterial;
import gregtech.api.unification.material.type.IngotMaterial;
import gregtech.api.unification.material.type.Material;
import gregtech.api.unification.ore.OrePrefix;
import gregtech.api.unification.stack.UnificationEntry;
import gregtech.api.util.GTUtility;
import gregtech.common.blocks.BlockGranite;
import gregtech.common.blocks.BlockMineral;
import gregtech.common.blocks.MetaBlocks;
import gregtech.common.blocks.StoneBlock;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

import java.util.List;
import java.util.stream.Collectors;

public class GBRecipeAddition {
    public static void postInit() {
        for (SieveRecipe recipe : ExNihiloRegistryManager.SIEVE_REGISTRY.getRecipeList()) {
            for (Object object : recipe.getInputs()) {
                SimpleRecipeBuilder builder = GBRecipeMaps.SIEVE_RECIPES.recipeBuilder();
                builder.notConsumable(recipe.getMesh()).inputs((ItemStack) object);
                for (Siftable siftable : ExNihiloRegistryManager.SIEVE_REGISTRY.getDrops((ItemStack) recipe.getInputs().get(0))) {
                    if (siftable.getMeshLevel() == recipe.getMesh().getMetadata())
                        builder.chancedOutput(siftable.getDrop().getItemStack(), (int) (siftable.getChance() * (float) Recipe.getMaxChancedValue()));
                }
                builder.duration(100).EUt(4);
                builder.buildAndRegister();
            }
        }

        ModHandler.addShapedRecipe("pebbles_to_basalt", MetaBlocks.MINERAL.getItemVariant(BlockMineral.MineralVariant.BASALT, StoneBlock.ChiselingVariant.CRACKED), "PP", "PP", 'P', GBPebble.getPebbleStack("basalt"));
        ModHandler.addShapedRecipe("pebbles_to_black_granite", MetaBlocks.GRANITE.getItemVariant(BlockGranite.GraniteVariant.BLACK_GRANITE, StoneBlock.ChiselingVariant.CRACKED), "PP", "PP", 'P', GBPebble.getPebbleStack("black_granite"));
        ModHandler.addShapedRecipe("pebbles_to_marble", MetaBlocks.MINERAL.getItemVariant(BlockMineral.MineralVariant.MARBLE, StoneBlock.ChiselingVariant.CRACKED), "PP", "PP", 'P', GBPebble.getPebbleStack("marble"));
        ModHandler.addShapedRecipe("pebbles_to_red_granite", MetaBlocks.GRANITE.getItemVariant(BlockGranite.GraniteVariant.RED_GRANITE, StoneBlock.ChiselingVariant.CRACKED), "PP", "PP", 'P', GBPebble.getPebbleStack("red_granite"));

        ModHandler.addSmeltingRecipe(MetaBlocks.MINERAL.getItemVariant(BlockMineral.MineralVariant.BASALT, StoneBlock.ChiselingVariant.CRACKED), MetaBlocks.MINERAL.getItemVariant(BlockMineral.MineralVariant.BASALT, StoneBlock.ChiselingVariant.NORMAL));
        ModHandler.addSmeltingRecipe(OreDictUnifier.get(OrePrefix.cobblestone, Materials.GraniteBlack), OreDictUnifier.get(OrePrefix.stone, Materials.GraniteBlack));
        ModHandler.addSmeltingRecipe(MetaBlocks.MINERAL.getItemVariant(BlockMineral.MineralVariant.MARBLE, StoneBlock.ChiselingVariant.CRACKED), MetaBlocks.MINERAL.getItemVariant(BlockMineral.MineralVariant.MARBLE, StoneBlock.ChiselingVariant.NORMAL));
        ModHandler.addSmeltingRecipe(OreDictUnifier.get(OrePrefix.cobblestone, Materials.GraniteRed), OreDictUnifier.get(OrePrefix.stone, Materials.GraniteRed));

        for (Material m : IngotMaterial.MATERIAL_REGISTRY) {
            if (!OreDictUnifier.get(OrePrefix.valueOf("plateDouble"), m).isEmpty()) {
                RecipeMaps.BENDER_RECIPES.recipeBuilder().EUt(24).duration((int) m.getMass() * 2).inputs(OreDictUnifier.get(OrePrefix.plate, m, 2)).circuitMeta(3).outputs(OreDictUnifier.get(OrePrefix.valueOf("plateDouble"), m)).buildAndRegister();
                ModHandler.addShapedRecipe("double_plate_" + m.toString(), OreDictUnifier.get(OrePrefix.valueOf("plateDouble"), m), "h", "P", "P", 'P', OreDictUnifier.get(OrePrefix.plate, m));
            }
        }

        //Bees
        List<ItemStack> allFlowers = OreDictionary.getOres("flower").stream()
                .flatMap(stack -> ModHandler.getAllSubItems(stack).stream())
                .collect(Collectors.toList());

        for (ItemStack stack : allFlowers)
            GBRecipeMaps.ATTRACTOR_RECIPES.recipeBuilder().notConsumable(GTUtility.copyAmount(1, stack)).fluidInputs(Fluids.SEED_OIL.getFluid(100))
                    .chancedOutput(BeeManager.beeRoot.getMemberStack(BeeDefinition.FOREST.getIndividual(), EnumBeeType.PRINCESS), 500)
                    .chancedOutput(BeeManager.beeRoot.getMemberStack(BeeDefinition.FOREST.getIndividual(), EnumBeeType.DRONE), 1500)
                    .chancedOutput(BeeManager.beeRoot.getMemberStack(BeeDefinition.MEADOWS.getIndividual(), EnumBeeType.PRINCESS), 500)
                    .chancedOutput(BeeManager.beeRoot.getMemberStack(BeeDefinition.MEADOWS.getIndividual(), EnumBeeType.DRONE), 1500)
                    .chancedOutput(BeeManager.beeRoot.getMemberStack(BeeDefinition.VALIANT.getIndividual(), EnumBeeType.PRINCESS), 50)
                    .chancedOutput(BeeManager.beeRoot.getMemberStack(BeeDefinition.VALIANT.getIndividual(), EnumBeeType.DRONE), 150)
                    .EUt(26).duration(200).buildAndRegister();

        GBRecipeMaps.ATTRACTOR_RECIPES.recipeBuilder().notConsumable(new ItemStack(Blocks.BROWN_MUSHROOM)).fluidInputs(Fluids.SEED_OIL.getFluid(100))
                .chancedOutput(BeeManager.beeRoot.getMemberStack(BeeDefinition.MARSHY.getIndividual(), EnumBeeType.PRINCESS), 500)
                .chancedOutput(BeeManager.beeRoot.getMemberStack(BeeDefinition.MARSHY.getIndividual(), EnumBeeType.DRONE), 1500)
                .chancedOutput(BeeManager.beeRoot.getMemberStack(BeeDefinition.VALIANT.getIndividual(), EnumBeeType.PRINCESS), 50)
                .chancedOutput(BeeManager.beeRoot.getMemberStack(BeeDefinition.VALIANT.getIndividual(), EnumBeeType.DRONE), 150)
                .EUt(26).duration(200).buildAndRegister();

        GBRecipeMaps.ATTRACTOR_RECIPES.recipeBuilder().notConsumable(new ItemStack(Blocks.RED_MUSHROOM)).fluidInputs(Fluids.SEED_OIL.getFluid(100))
                .chancedOutput(BeeManager.beeRoot.getMemberStack(BeeDefinition.MARSHY.getIndividual(), EnumBeeType.PRINCESS), 500)
                .chancedOutput(BeeManager.beeRoot.getMemberStack(BeeDefinition.MARSHY.getIndividual(), EnumBeeType.DRONE), 1500)
                .chancedOutput(BeeManager.beeRoot.getMemberStack(BeeDefinition.VALIANT.getIndividual(), EnumBeeType.PRINCESS), 50)
                .chancedOutput(BeeManager.beeRoot.getMemberStack(BeeDefinition.VALIANT.getIndividual(), EnumBeeType.DRONE), 150)
                .EUt(26).duration(200).buildAndRegister();

        GBRecipeMaps.ATTRACTOR_RECIPES.recipeBuilder().notConsumable(new ItemStack(Blocks.SNOW)).fluidInputs(Fluids.SEED_OIL.getFluid(100))
                .chancedOutput(BeeManager.beeRoot.getMemberStack(BeeDefinition.WINTRY.getIndividual(), EnumBeeType.PRINCESS), 500)
                .chancedOutput(BeeManager.beeRoot.getMemberStack(BeeDefinition.WINTRY.getIndividual(), EnumBeeType.DRONE), 1500)
                .chancedOutput(BeeManager.beeRoot.getMemberStack(BeeDefinition.VALIANT.getIndividual(), EnumBeeType.PRINCESS), 50)
                .chancedOutput(BeeManager.beeRoot.getMemberStack(BeeDefinition.VALIANT.getIndividual(), EnumBeeType.DRONE), 150)
                .EUt(26).duration(200).buildAndRegister();

        GBRecipeMaps.ATTRACTOR_RECIPES.recipeBuilder().notConsumable(new ItemStack(Items.CHORUS_FRUIT)).fluidInputs(Fluids.SEED_OIL.getFluid(100))
                .chancedOutput(BeeManager.beeRoot.getMemberStack(BeeDefinition.ENDED.getIndividual(), EnumBeeType.PRINCESS), 500)
                .chancedOutput(BeeManager.beeRoot.getMemberStack(BeeDefinition.ENDED.getIndividual(), EnumBeeType.DRONE), 1500)
                .chancedOutput(BeeManager.beeRoot.getMemberStack(BeeDefinition.VALIANT.getIndividual(), EnumBeeType.PRINCESS), 50)
                .chancedOutput(BeeManager.beeRoot.getMemberStack(BeeDefinition.VALIANT.getIndividual(), EnumBeeType.DRONE), 150)
                .EUt(26).duration(200).buildAndRegister();

        GBRecipeMaps.ATTRACTOR_RECIPES.recipeBuilder().notConsumable(new ItemStack(Blocks.CACTUS)).fluidInputs(Fluids.SEED_OIL.getFluid(100))
                .chancedOutput(BeeManager.beeRoot.getMemberStack(BeeDefinition.MODEST.getIndividual(), EnumBeeType.PRINCESS), 500)
                .chancedOutput(BeeManager.beeRoot.getMemberStack(BeeDefinition.MODEST.getIndividual(), EnumBeeType.DRONE), 1500)
                .chancedOutput(BeeManager.beeRoot.getMemberStack(BeeDefinition.VALIANT.getIndividual(), EnumBeeType.PRINCESS), 50)
                .chancedOutput(BeeManager.beeRoot.getMemberStack(BeeDefinition.VALIANT.getIndividual(), EnumBeeType.DRONE), 150)
                .EUt(26).duration(200).buildAndRegister();

        GBRecipeMaps.ATTRACTOR_RECIPES.recipeBuilder().notConsumable(new ItemStack(Blocks.VINE)).fluidInputs(Fluids.SEED_OIL.getFluid(100))
                .chancedOutput(BeeManager.beeRoot.getMemberStack(BeeDefinition.TROPICAL.getIndividual(), EnumBeeType.PRINCESS), 500)
                .chancedOutput(BeeManager.beeRoot.getMemberStack(BeeDefinition.TROPICAL.getIndividual(), EnumBeeType.DRONE), 1500)
                .chancedOutput(BeeManager.beeRoot.getMemberStack(BeeDefinition.VALIANT.getIndividual(), EnumBeeType.PRINCESS), 50)
                .chancedOutput(BeeManager.beeRoot.getMemberStack(BeeDefinition.VALIANT.getIndividual(), EnumBeeType.DRONE), 150)
                .EUt(26).duration(200).buildAndRegister();

        GBRecipeMaps.ATTRACTOR_RECIPES.recipeBuilder().notConsumable(new ItemStack(Blocks.WATERLILY)).fluidInputs(Fluids.SEED_OIL.getFluid(100))
                .chancedOutput(BeeManager.beeRoot.getMemberStack(ExtraBeeDefinition.WATER.getIndividual(), EnumBeeType.PRINCESS), 500)
                .chancedOutput(BeeManager.beeRoot.getMemberStack(ExtraBeeDefinition.WATER.getIndividual(), EnumBeeType.DRONE), 1500)
                .chancedOutput(BeeManager.beeRoot.getMemberStack(BeeDefinition.VALIANT.getIndividual(), EnumBeeType.PRINCESS), 50)
                .chancedOutput(BeeManager.beeRoot.getMemberStack(BeeDefinition.VALIANT.getIndividual(), EnumBeeType.DRONE), 150)
                .EUt(26).duration(200).buildAndRegister();

        GBRecipeMaps.ATTRACTOR_RECIPES.recipeBuilder().notConsumable(OreDictUnifier.get(OrePrefix.stone, null)).fluidInputs(Fluids.SEED_OIL.getFluid(100))
                .chancedOutput(BeeManager.beeRoot.getMemberStack(ExtraBeeDefinition.ROCK.getIndividual(), EnumBeeType.PRINCESS), 500)
                .chancedOutput(BeeManager.beeRoot.getMemberStack(ExtraBeeDefinition.ROCK.getIndividual(), EnumBeeType.DRONE), 1500)
                .chancedOutput(BeeManager.beeRoot.getMemberStack(BeeDefinition.VALIANT.getIndividual(), EnumBeeType.PRINCESS), 50)
                .chancedOutput(BeeManager.beeRoot.getMemberStack(BeeDefinition.VALIANT.getIndividual(), EnumBeeType.DRONE), 150)
                .EUt(26).duration(200).buildAndRegister();

        GBRecipeMaps.ATTRACTOR_RECIPES.recipeBuilder().notConsumable(new ItemStack(Items.NETHER_WART)).fluidInputs(Fluids.SEED_OIL.getFluid(100))
                .chancedOutput(BeeManager.beeRoot.getMemberStack(ExtraBeeDefinition.BASALT.getIndividual(), EnumBeeType.PRINCESS), 500)
                .chancedOutput(BeeManager.beeRoot.getMemberStack(ExtraBeeDefinition.BASALT.getIndividual(), EnumBeeType.DRONE), 1500)
                .chancedOutput(BeeManager.beeRoot.getMemberStack(BeeDefinition.VALIANT.getIndividual(), EnumBeeType.PRINCESS), 50)
                .chancedOutput(BeeManager.beeRoot.getMemberStack(BeeDefinition.VALIANT.getIndividual(), EnumBeeType.DRONE), 150)
                .EUt(26).duration(200).buildAndRegister();
    }

    public static void register() {
        OrePrefix.valueOf("oreChunk").addProcessingHandler(DustMaterial.class, GBRecipeAddition::processOre);
        OrePrefix.valueOf("oreEnderChunk").addProcessingHandler(DustMaterial.class, GBRecipeAddition::processOre);
        OrePrefix.valueOf("oreNetherChunk").addProcessingHandler(DustMaterial.class, GBRecipeAddition::processOre);
        OrePrefix.valueOf("oreFineChunk").addProcessingHandler(DustMaterial.class, GBRecipeAddition::processOre);
    }

    public static void processOre(OrePrefix orePrefix, DustMaterial material) {
        ItemStack ingotStack;
        DustMaterial smeltingMaterial = material;
        if (material.directSmelting != null) {
            smeltingMaterial = material.directSmelting;
        }
        if (smeltingMaterial instanceof IngotMaterial) {
            ingotStack = OreDictUnifier.get(OrePrefix.ingot, smeltingMaterial);
        } else if (smeltingMaterial instanceof GemMaterial) {
            ingotStack = OreDictUnifier.get(OrePrefix.gem, smeltingMaterial);
        } else {
            ingotStack = OreDictUnifier.get(OrePrefix.dust, smeltingMaterial);
        }
        ingotStack.setCount(material.smeltingMultiplier);

        if (!ingotStack.isEmpty() && doesMaterialUseNormalFurnace(material)) {
            ModHandler.addSmeltingRecipe(new UnificationEntry(orePrefix, material), ingotStack);
        }
    }

    private static boolean doesMaterialUseNormalFurnace(Material material) {
        return !(material instanceof IngotMaterial) ||
                ((IngotMaterial) material).blastFurnaceTemperature <= 0;
    }
}
