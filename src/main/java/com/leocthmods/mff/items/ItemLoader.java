package com.leocthmods.mff.items;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemSword;
import net.minecraft.item.ItemTool;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemLoader {
	public static Item      framingIngot 	  	  = new ItemFramingIngot();
	public static Item	    conductorAlloyIngot   = new ItemConductorAlloyIngot();
	public static Item	    crystalEV             = new ItemEVCrystal(); //Electrovibratum Crystal
	public static Item	    forgingHammer         = new ItemForgingHammer();
	public static Item		bucketBlood			  = new ItemBucketBlood();
	public static ItemFood  tofu         	   	  = new ItemTofu();
	public static ItemTool  toolSpoon    	      = new ItemToolSpoon();
	public static ItemSword reinforcedSword     = new ItemSwordReinforced();
	public static Item[]    items = new Item[1024];
	
	public ItemLoader(FMLPreInitializationEvent e) {
		init();
		for (int i = 0; items[i] != null; i++) {
			register(items[i]);
		}
	}
	@SideOnly(Side.CLIENT)
	public static void registerRenders() {
		for (int i = 0; items[i] != null; i++) {
			registerRender(items[i]);
		}
	}
	private static void register(Item item) {
		ForgeRegistries.ITEMS.register(item);
	}

	@SideOnly(Side.CLIENT)
	private static void registerRender(Item item) {
		ModelResourceLocation model = new ModelResourceLocation(item.getRegistryName(), "inventory");
		ModelLoader.setCustomModelResourceLocation(item, 0, model);
	}
	private void init() {
		items[0] = (framingIngot.setRegistryName("mff:framing_ingot"));
		items[1] = (conductorAlloyIngot.setRegistryName("mff:conductor_alloy_ingot"));
		items[2] = (crystalEV.setRegistryName("mff:ev_crystal"));
		items[3] = (forgingHammer.setRegistryName("mff:forging_hammer"));
		items[4] = (tofu.setRegistryName("mff:tofu"));
		items[5] = (toolSpoon.setRegistryName("mff:spoon"));
		items[6] = (reinforcedSword.setRegistryName("mff:reinforced_sword"));
		items[7] = (bucketBlood.setRegistryName("bucket_blood"));
	}
}
