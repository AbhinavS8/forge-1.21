package net.dominosq.mobweapons.block.custom;

import net.dominosq.mobweapons.MobWeapons;
import net.dominosq.mobweapons.item.ModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;

public class MagicBlock extends Block {
    public MagicBlock(Properties properties) {
        super(properties);
    }

    @Override
    protected InteractionResult useWithoutItem(BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer, BlockHitResult pHitResult) {

        pLevel.playSound(pPlayer,pPos, SoundEvents.CAT_AMBIENT, SoundSource.BLOCKS,1f,2f);
        return InteractionResult.SUCCESS; //super.useWithoutItem(pState, pLevel, pPos, pPlayer, pHitResult);

    }

    @Override
    public void animateTick(BlockState pState, Level pLevel, BlockPos pPos, RandomSource pRandom) {
        if (pRandom.nextInt(100) == 0) {
            pLevel.playLocalSound(pPos, SoundEvents.RESPAWN_ANCHOR_AMBIENT, SoundSource.BLOCKS, 1.0F, 1.0F, false);
        }

        double d0 = (double)pPos.getX() + 0.5 + (0.5 - pRandom.nextDouble());
        double d1 = (double)pPos.getY() + 1.0;
        double d2 = (double)pPos.getZ() + 0.5 + (0.5 - pRandom.nextDouble());
        double d3 = (double)pRandom.nextFloat() * 0.04;
        pLevel.addParticle(ParticleTypes.SOUL_FIRE_FLAME, d0, d1, d2, 0.0, d3, 0.0);

    }

    @Override
    public void stepOn(Level pLevel, BlockPos pPos, BlockState pState, Entity pEntity) {
        if (pEntity instanceof ItemEntity itemEntity ) {
            if (itemEntity.getItem().getItem() == ModItems.ESSENCE.get()) {
                itemEntity.setItem(new ItemStack(Items.DANDELION,itemEntity.getItem().getCount()));
            }

            if (itemEntity.getItem().getItem() == ModItems.CHISEL_ITEM.get()) {
                itemEntity.setItem(new ItemStack(Items.TOTEM_OF_UNDYING,itemEntity.getItem().getCount()));
            }
        }

        super.stepOn(pLevel, pPos, pState, pEntity);
    }
}
