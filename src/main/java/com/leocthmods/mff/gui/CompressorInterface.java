package com.leocthmods.mff.gui;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.inventory.Container;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumHand;

public class CompressorInterface extends Container{
        public CompressorInterface()
        {
            super();
        }

        @Override
        public boolean canInteractWith(EntityPlayer playerIn)
        {
            return playerIn.isSneaking() && playerIn.world.isRainingAt(playerIn.getPosition()) && new ItemStack(Blocks.TNT).isItemEqual(playerIn.getHeldItemOffhand());
        }
}
