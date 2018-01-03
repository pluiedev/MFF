package com.leocthmods.mff.items;

import com.leocthmods.mff.CreativeTabsLoader;
import com.leocthmods.mff.blocks.BlockLoader;
import net.minecraft.init.Items;
import net.minecraft.item.ItemBucket;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.fluids.capability.wrappers.FluidBucketWrapper;

import javax.annotation.Nullable;

public class ItemBucketBlood extends ItemBucket {
    public ItemBucketBlood() {
        super(BlockLoader.fluidBlood);
        this.setContainerItem(Items.BUCKET);
        this.setUnlocalizedName("bucketBlood");
        this.setCreativeTab(CreativeTabsLoader.tabMFF);
    }

    @Override
    public ICapabilityProvider initCapabilities(ItemStack stack, @Nullable NBTTagCompound nbt) {
        return new FluidBucketWrapper(stack); //As Univ-Bucket does
    }
}
