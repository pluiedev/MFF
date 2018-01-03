package com.leocthmods.mff;

import com.leocthmods.mff.items.ItemLoader;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class CreativeTabsLoader {
	public static CreativeTabs tabMFF;
	public CreativeTabsLoader(FMLPreInitializationEvent e) {
		tabMFF = new MFFTab();
	}
	public class MFFTab extends CreativeTabs {

		public MFFTab() {
			super("mff");
		}

		@Override
		public ItemStack getTabIconItem() {
			return new ItemStack(ItemLoader.framingIngot);
		}
		
	}
}
