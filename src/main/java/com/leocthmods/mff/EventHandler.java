package com.leocthmods.mff;

import com.leocthmods.mff.items.ItemLoader;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.FillBucketEvent;
import net.minecraftforge.fluids.*;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.Event;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import static java.lang.System.out;

public class EventHandler {

    //TODO: this thing is not ready yet
    @SubscribeEvent
    public void onFillBucket(FillBucketEvent event)
    {
        out.println("Try to fill bucket.");
        BlockPos blockpos = event.getTarget().getBlockPos();
        IBlockState blockState = event.getWorld().getBlockState(blockpos);
        Fluid fluid = FluidRegistry.lookupFluidForBlock(blockState.getBlock());
        if (fluid != null && new Integer(0).equals(blockState.getValue(BlockFluidBase.LEVEL)))
        {
            FluidStack fluidStack = new FluidStack(fluid, Fluid.BUCKET_VOLUME);
            event.getWorld().setBlockToAir(blockpos);
            FluidActionResult result = FluidUtil.tryFillContainer(event.getEmptyBucket(), null, Integer.MAX_VALUE, event.getEntityPlayer(), true);
            if (result == FluidActionResult.FAILURE) {
                out.println("FAILURE");
                event.setResult(Event.Result.DENY);
            }
            else {
                event.setResult(Event.Result.ALLOW);
                out.println("SUCCESS");
                event.setFilledBucket(new ItemStack(ItemLoader.bucketBlood));
            }
        }
    }
}
