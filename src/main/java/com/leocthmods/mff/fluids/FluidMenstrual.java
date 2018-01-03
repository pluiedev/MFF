package com.leocthmods.mff.fluids;

import com.leocthmods.mff.MyFoodFactory;
import net.minecraft.block.material.Material;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fluids.BlockFluidClassic;
import net.minecraftforge.fluids.Fluid;

public class FluidMenstrual extends Fluid {

    public static final ResourceLocation still = new ResourceLocation(MyFoodFactory.MODID + ":" + "fluid/menstrual_fluid_still");
    public static final ResourceLocation flowing = new ResourceLocation(MyFoodFactory.MODID + ":" + "fluid/menstrual_fluid_flowing");

    public FluidMenstrual() {
        super("menstrual_fluid", still, flowing);
        this.setUnlocalizedName("fluidMenstrual"/*"theDisgustingStuffYouMightHaveIfThereIsNoSex"*/);
        this.setDensity(1060 /* Data from WolframAlpha: 1.06g/cm^3 */);
        this.setViscosity(3300 /* from WolframAlpha: 3.3centipoise*/);
        this.setLuminosity(0);
        this.setTemperature(300  /* Unknown, use default values */);
        this.setGaseous(false /* BLOOD IS NOT GASEOUS! */);
    }
}

