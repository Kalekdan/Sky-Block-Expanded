package com.pixolestudios.skyblockexpanded.blocks;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.material.Material;
import net.minecraft.entity.LivingEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorldReader;

public class RopeBlock extends Block {
    public RopeBlock(){
        super(AbstractBlock.Properties.of(Material.PLANT).noCollission().instabreak());
    }

    @Override
    public boolean isLadder(BlockState state, IWorldReader world, BlockPos pos, LivingEntity entity) {
        return true;
    }
}
