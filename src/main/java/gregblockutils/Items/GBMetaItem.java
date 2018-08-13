package gregblockutils.Items;

import gregtech.api.items.materialitem.MaterialMetaItem;
import gregtech.api.unification.ore.OrePrefix;

public class GBMetaItem extends MaterialMetaItem {

    public GBMetaItem() {
        super(OrePrefix.valueOf("oreChunk"), OrePrefix.valueOf("oreEnderChunk"), OrePrefix.valueOf("oreNetherChunk"), OrePrefix.valueOf("oreFineChunk"),
                null, null, null, null, null, null, null,
                null, null, null, null, null, null, null,
                null, null, null, null, null, null, null,
                null, null, null, null, null, null, null);
    }
}
