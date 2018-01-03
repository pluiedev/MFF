package com.leocthmods.mff.items;

import java.util.HashSet;

import com.leocthmods.mff.CreativeTabsLoader;
import com.leocthmods.mff.items.material.ToolMaterialList;
import net.minecraft.item.ItemTool;

public class ItemToolSpoon extends ItemTool {

	protected ItemToolSpoon() {
		super(ToolMaterialList.CERAMIC_SPOON, new HashSet<>());
		this.setUnlocalizedName("ceramicSpoon");
        this.setCreativeTab(CreativeTabsLoader.tabMFF);
        this.setHarvestLevel("spoon", 1);
	}
}
