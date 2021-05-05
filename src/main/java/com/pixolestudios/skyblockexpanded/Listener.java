package com.pixolestudios.skyblockexpanded;

import net.minecraft.block.Block;
import net.minecraft.block.GrassBlock;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.passive.ChickenEntity;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.event.entity.player.BonemealEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.Random;

@Mod.EventBusSubscriber
public class Listener {

    // Chance for a chicken to spawn when bone mealing grass is 1/val
    private static final int CHANCE_OF_CHICKEN_SPAWN_ON_BONE_MEAL = 20;

    @SubscribeEvent(priority= EventPriority.NORMAL, receiveCanceled=true)
    public static void onBoneMeal(BonemealEvent event) {
        Block block = event.getBlock().getBlock();
        if (block instanceof GrassBlock){
            World world = event.getWorld();
            if (!world.isClientSide){
                Random random = new Random();
                int randInt = random.nextInt(CHANCE_OF_CHICKEN_SPAWN_ON_BONE_MEAL);
                if (randInt == 1){
                    ChickenEntity newChicken = EntityType.CHICKEN.spawn((ServerWorld)world, null, null, event.getPlayer(),  event.getPos(), SpawnReason.SPAWN_EGG, true, true);
                    newChicken.setBaby(true);
                }

            }
        }
    }
}
