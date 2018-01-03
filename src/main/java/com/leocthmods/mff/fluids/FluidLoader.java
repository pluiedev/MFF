package com.leocthmods.mff.fluids;

import com.leocthmods.mff.MyFoodFactory;
import com.leocthmods.mff.blocks.BlockLoader;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.ItemMeshDefinition;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.renderer.block.statemap.StateMapperBase;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fluids.BlockFluidBase;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.Collection;
import java.util.Iterator;
import java.util.HashSet;

public class FluidLoader {
    public static Fluid fluidMenstrual = new FluidMenstrual();

    public FluidLoader(FMLPreInitializationEvent event) {
        if (FluidRegistry.isFluidRegistered(fluidMenstrual)) {
            MyFoodFactory.LOGGER.warn("Fluid {} has been already registered, registering cancelled", fluidMenstrual.getName());
            fluidMenstrual = FluidRegistry.getFluid(fluidMenstrual.getName());
        } else {
            FluidRegistry.registerFluid(fluidMenstrual);
        }
    }

    @SideOnly(Side.CLIENT)
    public static void registerRenders()
    {
        registerFluidRender((BlockFluidBase) BlockLoader.fluidMenstrual, "menstrual_fluid");
    }

    @SideOnly(Side.CLIENT)
    public static void registerFluidRender(BlockFluidBase blockFluid, String blockStateName)
    {
        final String location = MyFoodFactory.MODID + ":" + blockStateName;
        final Item itemFluid = new ItemBlock(blockFluid);
        ModelLoader.setCustomMeshDefinition(itemFluid, stack -> new ModelResourceLocation(location, "fluid"));
        ModelLoader.setCustomStateMapper(blockFluid, new StateMapperBase()
        {
            @Override
            protected ModelResourceLocation getModelResourceLocation(IBlockState state)
            {
                return new ModelResourceLocation(location, "fluid");
            }
        });
    }
}
