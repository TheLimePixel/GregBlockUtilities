package gregblockutils.Machines;

import gregblockutils.Recipes.GBRecipeMaps;
import gregtech.api.GregTechAPI;
import gregtech.api.metatileentity.SimpleMachineMetaTileEntity;
import gregtech.api.render.Textures;

public class GBTileEntities {
    public static SimpleMachineMetaTileEntity[] ELECTRIC_SIEVE = new SimpleMachineMetaTileEntity[8];
    public static SimpleMachineMetaTileEntity[] BEE_ATTRACTOR = new SimpleMachineMetaTileEntity[8];

    public static SteamPump STEAM_PUMP;

    public static SteamRockBreaker STEAM_BREAKER;

    public static void init() {
        ELECTRIC_SIEVE[0] = GregTechAPI.registerMetaTileEntity(2750, new SimpleMachineMetaTileEntity("sieve.lv", GBRecipeMaps.SIEVE_RECIPES, Textures.SIFTER_OVERLAY, 1));
        ELECTRIC_SIEVE[1] = GregTechAPI.registerMetaTileEntity(2751, new SimpleMachineMetaTileEntity("sieve.mv", GBRecipeMaps.SIEVE_RECIPES, Textures.SIFTER_OVERLAY, 2));
        ELECTRIC_SIEVE[2] = GregTechAPI.registerMetaTileEntity(2752, new SimpleMachineMetaTileEntity("sieve.hv", GBRecipeMaps.SIEVE_RECIPES, Textures.SIFTER_OVERLAY, 3));
        ELECTRIC_SIEVE[3] = GregTechAPI.registerMetaTileEntity(2753, new SimpleMachineMetaTileEntity("sieve.ev", GBRecipeMaps.SIEVE_RECIPES, Textures.SIFTER_OVERLAY, 4));
        ELECTRIC_SIEVE[4] = GregTechAPI.registerMetaTileEntity(2754, new SimpleMachineMetaTileEntity("sieve.iv", GBRecipeMaps.SIEVE_RECIPES, Textures.SIFTER_OVERLAY, 5));
        ELECTRIC_SIEVE[5] = GregTechAPI.registerMetaTileEntity(2755, new SimpleMachineMetaTileEntity("sieve.luv", GBRecipeMaps.SIEVE_RECIPES, Textures.SIFTER_OVERLAY, 6));
        ELECTRIC_SIEVE[6] = GregTechAPI.registerMetaTileEntity(2756, new SimpleMachineMetaTileEntity("sieve.zpm", GBRecipeMaps.SIEVE_RECIPES, Textures.SIFTER_OVERLAY, 7));
        ELECTRIC_SIEVE[7] = GregTechAPI.registerMetaTileEntity(2757, new SimpleMachineMetaTileEntity("sieve.uv", GBRecipeMaps.SIEVE_RECIPES, Textures.SIFTER_OVERLAY, 8));

        STEAM_PUMP = GregTechAPI.registerMetaTileEntity(2758, new SteamPump("pump.steam"));

        BEE_ATTRACTOR[0] = GregTechAPI.registerMetaTileEntity(2759, new SimpleMachineMetaTileEntity("attractor.lv", GBRecipeMaps.ATTRACTOR_RECIPES, GBTextures.BEE_ATTRACTOR, 1));
        BEE_ATTRACTOR[1] = GregTechAPI.registerMetaTileEntity(2760, new SimpleMachineMetaTileEntity("attractor.mv", GBRecipeMaps.ATTRACTOR_RECIPES, GBTextures.BEE_ATTRACTOR, 2));
        BEE_ATTRACTOR[2] = GregTechAPI.registerMetaTileEntity(2761, new SimpleMachineMetaTileEntity("attractor.hv", GBRecipeMaps.ATTRACTOR_RECIPES, GBTextures.BEE_ATTRACTOR, 3));
        BEE_ATTRACTOR[3] = GregTechAPI.registerMetaTileEntity(2762, new SimpleMachineMetaTileEntity("attractor.ev", GBRecipeMaps.ATTRACTOR_RECIPES, GBTextures.BEE_ATTRACTOR, 4));
        BEE_ATTRACTOR[4] = GregTechAPI.registerMetaTileEntity(2763, new SimpleMachineMetaTileEntity("attractor.iv", GBRecipeMaps.ATTRACTOR_RECIPES, GBTextures.BEE_ATTRACTOR, 5));
        BEE_ATTRACTOR[5] = GregTechAPI.registerMetaTileEntity(2764, new SimpleMachineMetaTileEntity("attractor.luv", GBRecipeMaps.ATTRACTOR_RECIPES, GBTextures.BEE_ATTRACTOR, 6));
        BEE_ATTRACTOR[6] = GregTechAPI.registerMetaTileEntity(2765, new SimpleMachineMetaTileEntity("attractor.zpm", GBRecipeMaps.ATTRACTOR_RECIPES, GBTextures.BEE_ATTRACTOR, 7));
        BEE_ATTRACTOR[7] = GregTechAPI.registerMetaTileEntity(2766, new SimpleMachineMetaTileEntity("attractor.uv", GBRecipeMaps.ATTRACTOR_RECIPES, GBTextures.BEE_ATTRACTOR, 8));

        STEAM_BREAKER = GregTechAPI.registerMetaTileEntity(2767, new SteamRockBreaker("rock_breaker.steam"));
    }
}
