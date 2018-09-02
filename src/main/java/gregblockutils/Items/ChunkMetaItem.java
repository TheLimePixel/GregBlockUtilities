package gregblockutils.Items;

import gregtech.api.items.materialitem.MaterialMetaItem;
import gregtech.api.unification.OreDictUnifier;
import gregtech.api.unification.material.type.Material;
import gregtech.api.unification.ore.OrePrefix;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.ObfuscationReflectionHelper;

import java.util.ArrayList;
import java.util.Iterator;

public class ChunkMetaItem extends MaterialMetaItem {

    public ChunkMetaItem() {
        super(OrePrefix.valueOf("oreChunk"), OrePrefix.valueOf("oreEnderChunk"), OrePrefix.valueOf("oreNetherChunk"), OrePrefix.valueOf("oreFineChunk"),
                null, null, null, null, null, null, null,
                null, null, null, null, null, null, null,
                null, null, null, null, null, null, null,
                null, null, null, null, null, null, null);
    }

    public void registerOreDict() {
        super.registerOreDict();

        ArrayList<Short> generatedItems = ObfuscationReflectionHelper.getPrivateValue(MaterialMetaItem.class, this, "generatedItems");

        Iterator var1 = generatedItems.iterator();

        while (var1.hasNext()) {
            short metaItem = (Short) var1.next();
            OrePrefix prefix = this.orePrefixes[metaItem / 1000];
            Material material = (Material) Material.MATERIAL_REGISTRY.getObjectById(metaItem % 1000);

            if (prefix == OrePrefix.valueOf("oreChunk"))
                OreDictUnifier.registerOre(new ItemStack(this, 1, metaItem), "oreGravel" + (material == null ? "" : material.toCamelCaseString()));

            if (prefix == OrePrefix.valueOf("oreEnderChunk"))
                OreDictUnifier.registerOre(new ItemStack(this, 1, metaItem), "oreEndstone" + (material == null ? "" : material.toCamelCaseString()));

            if (prefix == OrePrefix.valueOf("oreNetherChunk"))
                OreDictUnifier.registerOre(new ItemStack(this, 1, metaItem), "oreNetherrack" + (material == null ? "" : material.toCamelCaseString()));

            if (prefix == OrePrefix.valueOf("oreFineChunk"))
                OreDictUnifier.registerOre(new ItemStack(this, 1, metaItem), "oreSand" + (material == null ? "" : material.toCamelCaseString()));
        }

    }
}
