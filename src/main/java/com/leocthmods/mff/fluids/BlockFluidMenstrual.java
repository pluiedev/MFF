package com.leocthmods.mff.fluids;

import com.leocthmods.mff.CreativeTabsLoader;
import com.leocthmods.mff.MyFoodFactory;
import net.minecraft.block.material.Material;
import net.minecraftforge.fluids.BlockFluidClassic;

public class BlockFluidMenstrual extends BlockFluidClassic {
    public BlockFluidMenstrual() {
        super(FluidLoader.fluidMenstrual, Material.WATER);
        this.setUnlocalizedName("fluidMenstrual");
        this.setCreativeTab(CreativeTabsLoader.tabMFF);
        this.setRegistryName(MyFoodFactory.MODID + ":" + "menstrual_fluid");
    }
}
