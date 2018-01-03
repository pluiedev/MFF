package com.leocthmods.mff.items;

import com.leocthmods.mff.CreativeTabsLoader;

import net.minecraft.item.ItemFood;

public class ItemTofu extends ItemFood {

	public ItemTofu() {
		super(3, false);
		this.setUnlocalizedName("tofu");
		this.setCreativeTab(CreativeTabsLoader.tabMFF);
	}

}
