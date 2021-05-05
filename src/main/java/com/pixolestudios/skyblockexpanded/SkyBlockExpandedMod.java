package com.pixolestudios.skyblockexpanded;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(SkyBlockExpandedMod.MODID)
public class SkyBlockExpandedMod
{
    public static final String MODID = "skyblockexpanded";

    // Directly reference a log4j logger.
    private static final Logger LOGGER = LogManager.getLogger();

    public static IEventBus MOD_EVENT_BUS;


    public SkyBlockExpandedMod() {

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);

        MOD_EVENT_BUS = FMLJavaModLoadingContext.get().getModEventBus();

        MOD_EVENT_BUS.register(com.pixolestudios.skyblockexpanded.items.StartupClientOnly.class);
        MOD_EVENT_BUS.register(com.pixolestudios.skyblockexpanded.items.StartupCommon.class);
        MOD_EVENT_BUS.register(com.pixolestudios.skyblockexpanded.blocks.StartupClientOnly.class);
        MOD_EVENT_BUS.register(com.pixolestudios.skyblockexpanded.blocks.StartupCommon.class);


    }
}

