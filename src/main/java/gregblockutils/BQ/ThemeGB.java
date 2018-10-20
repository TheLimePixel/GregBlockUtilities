package gregblockutils.BQ;

import betterquesting.api.client.themes.ITheme;
import betterquesting.api.client.themes.IThemeRenderer;
import net.minecraft.util.ResourceLocation;

import java.awt.*;

public class ThemeGB implements ITheme {
    private final ThemeRenderGB renderer = new ThemeRenderGB();
    private final ResourceLocation regName;
    private final String name;
    private final ResourceLocation guiTexture;
    private int txtColor = new Color(1F, 0.901F, 0F).getRGB();

    public ThemeGB(String name, ResourceLocation texture, ResourceLocation regName) {
        this.regName = regName;
        this.name = name;
        this.guiTexture = texture;
    }

    @Override
    public ResourceLocation getThemeID() {
        return regName;
    }

    @Override
    public String getDisplayName() {
        return name;
    }

    @Override
    public ResourceLocation getGuiTexture() {
        return guiTexture;
    }

    public ThemeGB setTextColor(int c) {
        txtColor = c;
        return this;
    }

    public ThemeGB setLineColors(int locked, int incomplete, int complete) {
        renderer.setLineColors(locked, incomplete, complete);
        return this;
    }

    public ThemeGB setIconColors(int locked, int incomplete, int pending, int complete) {
        renderer.setIconColors(locked, incomplete, pending, complete);
        return this;
    }

    @Override
    public int getTextColor() {
        return txtColor;
    }

    @Override
    public IThemeRenderer getRenderer() {
        return renderer;
    }
}
