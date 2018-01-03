package com.leocthmods.mff;

import com.leocthmods.mff.common.CommonProxy;

import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.*;
import org.apache.logging.log4j.Logger;

@Mod(modid = MyFoodFactory.MODID,name = MyFoodFactory.NAME, version = MyFoodFactory.VERSION)
public class MyFoodFactory {
	static {
		FluidRegistry.enableUniversalBucket();
	}
	public static final String MODID = "mff";
	public static final String NAME = "My Food Factory";
	public static final String VERSION = "1.0.0";
	public static Logger LOGGER;
	@Mod.Instance(MyFoodFactory.MODID)
    public static MyFoodFactory instance;
	
	@SidedProxy(clientSide = "com.leocthmods.mff.client.ClientProxy", serverSide = "com.leocthmods.mff.common.CommonProxy")
	public static CommonProxy proxy; 
	@EventHandler
	public void preInit(FMLPreInitializationEvent e) { LOGGER = e.getModLog(); proxy.preInit(e); }
	@EventHandler
	public void init(FMLInitializationEvent e) {
		proxy.init(e);
	}
	@EventHandler
	public void postInit(FMLPostInitializationEvent e) {
		proxy.postInit(e);
	}
}
