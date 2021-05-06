package com.pixolestudios.skyblockexpanded;

import net.minecraft.block.Blocks;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
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

    public static final ItemGroup TAB_SBE = new ItemGroup(1, "SkyBlock Expanded") {
        @OnlyIn(Dist.CLIENT)
        public ItemStack makeIcon() {
            return new ItemStack(Blocks.BLUE_ORCHID);
        }
    };

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

