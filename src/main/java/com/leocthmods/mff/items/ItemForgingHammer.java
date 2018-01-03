package com.leocthmods.mff.items;

import com.leocthmods.mff.CreativeTabsLoader;

import net.minecraft.item.Item;

public class ItemForgingHammer extends Item {
	public ItemForgingHammer() {
		this.setUnlocalizedName("forgingHammer");
		this.setCreativeTab(CreativeTabsLoader.tabMFF);
		this.setMaxDamage(100);
	}
}
