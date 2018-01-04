package com.leocthmods.mff.fluids;

import com.leocthmods.mff.CreativeTabsLoader;
import com.leocthmods.mff.MyFoodFactory;
import net.minecraft.block.material.Material;
import net.minecraftforge.fluids.BlockFluidFinite;

public class BlockFluidBlood extends BlockFluidFinite {
    public BlockFluidBlood() {
        super(FluidLoader.blood, Material.WATER);
        this.setUnlocalizedName("blood");
        this.setCreativeTab(CreativeTabsLoader.tabMFF);
        this.setRegistryName(MyFoodFactory.MODID + ":" + "blood");
    }
}
