package com.pixolestudios.skyblockexpanded.blocks;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;

public class StartupCommon
{
    public static RopeBlock ropeBlock;  // this holds the unique instances of your blocks
    public static BlockItem ropeItemBlock;

    @SubscribeEvent
    public static void onBlocksRegistration(final RegistryEvent.Register<Block> blockRegisterEvent) {
        ropeBlock = (RopeBlock)(new RopeBlock().setRegistryName("skyblockexpanded", "rope_block"));
        blockRegisterEvent.getRegistry().register(ropeBlock);
        RenderTypeLookup.setRenderLayer(ropeBlock, RenderType.cutout());
    }

    @SubscribeEvent
    public static void onItemsRegistration(final RegistryEvent.Register<Item> itemRegisterEvent) {
        // We need to create a BlockItem so the player can carry this block in their hand and it can appear in the inventory
        final int MAXIMUM_STACK_SIZE = 64;  // player can only hold 64 of this block in their hand at once
        Item.Properties ropeItemProperties = new Item.Properties().stacksTo(MAXIMUM_STACK_SIZE).tab(ItemGroup.TAB_MISC);  // which inventory tab?
        ropeItemBlock = new BlockItem(ropeBlock, ropeItemProperties);
        ropeItemBlock.setRegistryName(ropeBlock.getRegistryName());
        itemRegisterEvent.getRegistry().register(ropeItemBlock);
    }

    @SubscribeEvent
    public static void onCommonSetupEvent(FMLCommonSetupEvent event) {
        // not actually required for this example....
    }
}