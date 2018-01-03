package com.leocthmods.mff.blocks;

import com.leocthmods.mff.fluids.BlockFluidBlood;
import com.leocthmods.mff.fluids.FluidLoader;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.registries.GameData;

public class BlockLoader {
	public static Block meatBlock 			= new BlockMeat();
	public static Block tofuBlock 			= new BlockTofu();
	public static Block antennaBlock		= new BlockAntenna();
	public static Block mechanicFrameBlock	= new BlockMechanicFrame();
	public static Block fluidBlood      = new BlockFluidBlood();

	public BlockLoader(FMLPreInitializationEvent event)
    {
        register(meatBlock, new ItemBlock(meatBlock));
        register(tofuBlock, new ItemBlock(tofuBlock));
        register(antennaBlock, new ItemBlock(antennaBlock));
        register(mechanicFrameBlock, new ItemBlock(mechanicFrameBlock));
        register(fluidBlood, new ItemBlock(fluidBlood));
    }

    @SideOnly(Side.CLIENT)
    public static void registerRenders()
    {
        registerDefaultRender(antennaBlock);
        registerDefaultRender(meatBlock);
        registerDefaultRender(tofuBlock);
        registerDefaultRender(mechanicFrameBlock);
        FluidLoader.registerRenders();
    }

    private static void register(Block b, ItemBlock iB)
    {
    		ForgeRegistries.BLOCKS.register(b);
    		ForgeRegistries.ITEMS.register(iB.setRegistryName(b.getRegistryName()));
    		GameData.getBlockItemMap().put(b, iB);
    }
    @SideOnly(Side.CLIENT)
    private static void registerDefaultRender(Block b) {
    		ModelResourceLocation model = new ModelResourceLocation(b.getRegistryName(), "inventory");
    		ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(b), 0, model);
    }
}
