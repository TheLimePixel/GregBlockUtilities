package gregblockutils.Machines;

import gregtech.api.gui.resources.TextureArea;
import gregtech.api.render.SimpleOverlayRenderer;

public class GBTextures {
    public static SimpleOverlayRenderer STEAM_PUMP_OVERLAY;

    public static final TextureArea BRONZE_DISPLAY = TextureArea.fullImage("textures/gui/steam/bronze_display.png");
    public static final TextureArea BRONZE_IN_SLOT_OVERLAY = TextureArea.fullImage("textures/gui/steam/bronze_in_slot_overlay.png");
    public static final TextureArea BRONZE_OUT_SLOT_OVERLAY = TextureArea.fullImage("textures/gui/steam/bronze_out_slot_overlay.png");
    public static final TextureArea BRONZE_TANK_ICON = TextureArea.fullImage("textures/gui/steam/bronze_tank_icon.png");

    static {
        STEAM_PUMP_OVERLAY = new SimpleOverlayRenderer("machine/overlay_steam_pump");
    }
}
