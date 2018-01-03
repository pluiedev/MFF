package com.leocthmods.mff.client;

import com.leocthmods.mff.blocks.BlockRenderLoader;
import com.leocthmods.mff.common.CommonProxy;
import com.leocthmods.mff.items.ItemRenderLoader;

import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class ClientProxy extends CommonProxy {
	@Override
	public void preInit(FMLPreInitializationEvent e) {
		super.preInit(e);
		new BlockRenderLoader();
		new ItemRenderLoader();
	}
	@Override
	public void init(FMLInitializationEvent e) {
		
	}
	@Override
	public void postInit(FMLPostInitializationEvent e) {
		
	}
}
