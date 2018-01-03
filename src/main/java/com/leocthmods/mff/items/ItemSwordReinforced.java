package com.leocthmods.mff.items;

import com.leocthmods.mff.CreativeTabsLoader;
import com.leocthmods.mff.items.material.ToolMaterialList;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;

public class ItemSwordReinforced extends ItemSword {

	protected ItemSwordReinforced() {
		super(ToolMaterialList.REINFORCED);
		this.setUnlocalizedName("reinforcedSword");
        this.setCreativeTab(CreativeTabsLoader.tabMFF);
	}
	public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn)
    {
        return new ActionResult<ItemStack>(EnumActionResult.PASS, playerIn.getHeldItem(handIn));
    }
}
