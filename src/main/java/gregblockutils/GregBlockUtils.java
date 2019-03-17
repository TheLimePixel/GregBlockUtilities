package gregblockutils;

import exnihilocreatio.registries.manager.ExNihiloRegistryManager;
import gregblockutils.Events.StoneGenEvents;
import gregblockutils.ExNihilo.GBSieveDrops;
import gregblockutils.Items.GBEnums;
import gregblockutils.Items.GBItems;
import gregblockutils.Items.GBMetaItems;
import gregblockutils.ExNihilo.SieveDrops;
import gregblockutils.Machines.GBTextures;
import gregblockutils.Machines.GBTileEntities;
import gregblockutils.Recipes.GBMachineRecipes;
import gregblockutils.Recipes.GBRecipeAddition;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.Logger;

@Mod(modid = GregBlockUtils.MODID,
        name = GregBlockUtils.NAME,
        version = GregBlockUtils.VERSION,
        dependencies = "required-after:gtadditions;required-after:exnihilocreatio"
)
public class GregBlockUtils {
    public static final String MODID = "gregblockutils";
    public static final String NAME = "GregBlock Utilities";
    public static final String VERSION = "@VERSION@";

    @SidedProxy(
            modId = MODID,
            clientSide = "gregblockutils.ClientProxy",
            serverSide = "gregblockutils.CommonProxy"
    )
    public static CommonProxy proxy;

    private static Logger logger;

    public GregBlockUtils() {
        GBEnums.preInit();
        new GBTextures();
    }

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        GBMetaItems.preInit();
        new GBItems();
        SieveDrops.addSieveRecipe();
        ExNihiloRegistryManager.registerSieveDefaultRecipeHandler(new GBSieveDrops());
    }

    @EventHandler
    public void init(FMLInitializationEvent event) {
        GBTileEntities.init();
        GBMachineRecipes.init();
        MinecraftForge.EVENT_BUS.register(new StoneGenEvents());
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent event) {
        proxy.postInit();
        GBRecipeAddition.postInit();
    }
}
