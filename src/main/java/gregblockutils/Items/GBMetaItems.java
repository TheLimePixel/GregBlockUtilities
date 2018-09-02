package gregblockutils.Items;

public class GBMetaItems {

    public static void preInit() {
        ChunkMetaItem chunk = new ChunkMetaItem();
        GBMetaItem item = new GBMetaItem();
        chunk.setRegistryName("chunk_meta_item");
        item.setRegistryName("gb_meta_item");
    }
}