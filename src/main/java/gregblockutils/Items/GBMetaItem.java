package gregblockutils.Items;

import gregtech.api.items.materialitem.MaterialMetaItem;
import gregtech.api.items.metaitem.MetaItem;
import gregtech.api.unification.ore.OrePrefix;
import gregtech.common.items.MetaItems;
import net.minecraftforge.fml.common.ObfuscationReflectionHelper;

public class GBMetaItem  extends MaterialMetaItem {

    public GBMetaItem() {
        super(OrePrefix.valueOf("plateDouble"), null, null, null,
                null, null, null, null, null, null, null,
                null, null, null, null, null, null, null,
                null, null, null, null, null, null, null,
                null, null, null, null, null, null, null);
        
        ObfuscationReflectionHelper.setPrivateValue(MetaItem.MetaValueItem.class, MetaItems.CROP_DROP_PLUMBILIA, true, "visible");
        ObfuscationReflectionHelper.setPrivateValue(MetaItem.MetaValueItem.class, MetaItems.CROP_DROP_ARGENTIA, true, "visible");
        ObfuscationReflectionHelper.setPrivateValue(MetaItem.MetaValueItem.class, MetaItems.CROP_DROP_INDIGO, true, "visible");
        ObfuscationReflectionHelper.setPrivateValue(MetaItem.MetaValueItem.class, MetaItems.CROP_DROP_FERRU, true, "visible");
        ObfuscationReflectionHelper.setPrivateValue(MetaItem.MetaValueItem.class, MetaItems.CROP_DROP_AURELIA, true, "visible");
        ObfuscationReflectionHelper.setPrivateValue(MetaItem.MetaValueItem.class, MetaItems.CROP_DROP_OIL_BERRY, true, "visible");
        ObfuscationReflectionHelper.setPrivateValue(MetaItem.MetaValueItem.class, MetaItems.CROP_DROP_BOBS_YER_UNCLE_RANKS, true, "visible");
        ObfuscationReflectionHelper.setPrivateValue(MetaItem.MetaValueItem.class, MetaItems.CROP_DROP_UUM_BERRY, true, "visible");
        ObfuscationReflectionHelper.setPrivateValue(MetaItem.MetaValueItem.class, MetaItems.CROP_DROP_MILK_WART, true, "visible");
        ObfuscationReflectionHelper.setPrivateValue(MetaItem.MetaValueItem.class, MetaItems.CROP_DROP_COPPON, true, "visible");
        ObfuscationReflectionHelper.setPrivateValue(MetaItem.MetaValueItem.class, MetaItems.CROP_DROP_TINE, true, "visible");
        ObfuscationReflectionHelper.setPrivateValue(MetaItem.MetaValueItem.class, MetaItems.CROP_DROP_BAUXITE, true, "visible");
        ObfuscationReflectionHelper.setPrivateValue(MetaItem.MetaValueItem.class, MetaItems.CROP_DROP_ILMENITE, true, "visible");
        ObfuscationReflectionHelper.setPrivateValue(MetaItem.MetaValueItem.class, MetaItems.CROP_DROP_PITCHBLENDE, true, "visible");
        ObfuscationReflectionHelper.setPrivateValue(MetaItem.MetaValueItem.class, MetaItems.CROP_DROP_URANINITE, true, "visible");
        ObfuscationReflectionHelper.setPrivateValue(MetaItem.MetaValueItem.class, MetaItems.CROP_DROP_THORIUM, true, "visible");
        ObfuscationReflectionHelper.setPrivateValue(MetaItem.MetaValueItem.class, MetaItems.CROP_DROP_NICKEL, true, "visible");
        ObfuscationReflectionHelper.setPrivateValue(MetaItem.MetaValueItem.class, MetaItems.CROP_DROP_ZINC, true, "visible");
        ObfuscationReflectionHelper.setPrivateValue(MetaItem.MetaValueItem.class, MetaItems.CROP_DROP_MANGANESE, true, "visible");
        ObfuscationReflectionHelper.setPrivateValue(MetaItem.MetaValueItem.class, MetaItems.CROP_DROP_SCHEELITE, true, "visible");
        ObfuscationReflectionHelper.setPrivateValue(MetaItem.MetaValueItem.class, MetaItems.CROP_DROP_PLATINUM, true, "visible");
        ObfuscationReflectionHelper.setPrivateValue(MetaItem.MetaValueItem.class, MetaItems.CROP_DROP_IRIDIUM, true, "visible");
        ObfuscationReflectionHelper.setPrivateValue(MetaItem.MetaValueItem.class, MetaItems.CROP_DROP_OSMIUM, true, "visible");
        ObfuscationReflectionHelper.setPrivateValue(MetaItem.MetaValueItem.class, MetaItems.CROP_DROP_NAQUADAH, true, "visible");
        ObfuscationReflectionHelper.setPrivateValue(MetaItem.MetaValueItem.class, MetaItems.CROP_DROP_CHILLY, true, "visible");
        ObfuscationReflectionHelper.setPrivateValue(MetaItem.MetaValueItem.class, MetaItems.CROP_DROP_LEMON, true, "visible");
        ObfuscationReflectionHelper.setPrivateValue(MetaItem.MetaValueItem.class, MetaItems.CROP_DROP_TOMATO, true, "visible");
        ObfuscationReflectionHelper.setPrivateValue(MetaItem.MetaValueItem.class, MetaItems.CROP_DROP_MTOMATO, true, "visible");
        ObfuscationReflectionHelper.setPrivateValue(MetaItem.MetaValueItem.class, MetaItems.CROP_DROP_GRAPES, true, "visible");
        ObfuscationReflectionHelper.setPrivateValue(MetaItem.MetaValueItem.class, MetaItems.CROP_DROP_ONION, true, "visible");
        ObfuscationReflectionHelper.setPrivateValue(MetaItem.MetaValueItem.class, MetaItems.CROP_DROP_CUCUMBER, true, "visible");
    }
}
