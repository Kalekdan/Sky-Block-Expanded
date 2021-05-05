package com.pixolestudios.skyblockexpanded.items;

import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;

public class StartupCommon {
    public static EndFrameEngraving endFrameEngraving;  // this holds the unique instances of your items
    public static LifeEssence lifeEssence;

    @SubscribeEvent
    public static void onItemsRegistration(final RegistryEvent.Register<Item> itemRegisterEvent) {
        endFrameEngraving = new EndFrameEngraving();
        endFrameEngraving.setRegistryName("end_frame_engraving");
        itemRegisterEvent.getRegistry().register(endFrameEngraving);

        lifeEssence = new LifeEssence();
        lifeEssence.setRegistryName("life_essence");
        itemRegisterEvent.getRegistry().register(lifeEssence);
    }

    @SubscribeEvent
    public static void onCommonSetupEvent(FMLCommonSetupEvent event) {
        // not actually required for this example....
    }
}
