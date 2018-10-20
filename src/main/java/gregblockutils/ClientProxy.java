package gregblockutils;

import betterquesting.api.api.ApiReference;
import betterquesting.api.api.QuestingAPI;
import betterquesting.api.client.themes.IThemeRegistry;
import gregblockutils.BQ.ThemeGB;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;


@Mod.EventBusSubscriber(Side.CLIENT)
public class ClientProxy extends CommonProxy {
    public void preInit() {
        super.preInit();
    }

    public void postInit() {

    }

    @SubscribeEvent
    public static void registerModels(ModelRegistryEvent event) {
    }

    @Override
    public void registerExpansion() {
        IThemeRegistry themeReg = QuestingAPI.getAPI(ApiReference.THEME_REG);
        themeReg.registerTheme(new ThemeGB("GregBlock", new ResourceLocation("gregblockutils", "textures/gui/editor_gui_gb.png"), new ResourceLocation("gregblockutils", "gb")));
    }
}
