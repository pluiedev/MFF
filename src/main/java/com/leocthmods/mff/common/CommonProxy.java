package com.leocthmods.mff.common;

import com.leocthmods.mff.CreativeTabsLoader;
import com.leocthmods.mff.EventHandler;
import com.leocthmods.mff.blocks.BlockLoader;
import com.leocthmods.mff.fluids.FluidLoader;
import com.leocthmods.mff.items.ItemLoader;
import com.leocthmods.mff.recipes.RecipeLoader;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class CommonProxy {
	public void preInit(FMLPreInitializationEvent e) {
		new CreativeTabsLoader(e);
        new FluidLoader(e);
		new BlockLoader(e);
		new ItemLoader(e);

	}
	public void init(FMLInitializationEvent e) {
	    System.out.println("initialize");
		new RecipeLoader(e);
        MinecraftForge.EVENT_BUS.register(new EventHandler());
	}
	public void postInit(FMLPostInitializationEvent e) {}
}
