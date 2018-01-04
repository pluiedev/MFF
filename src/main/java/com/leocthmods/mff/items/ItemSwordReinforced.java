package com.leocthmods.mff.items;

import com.leocthmods.mff.CreativeTabsLoader;
import com.leocthmods.mff.MyFoodFactory;
import com.leocthmods.mff.gui.GuiHandler;
import com.leocthmods.mff.items.material.ToolMaterialList;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class ItemSwordReinforced extends ItemSword {

	protected ItemSwordReinforced() {
		super(ToolMaterialList.REINFORCED);
		this.setUnlocalizedName("reinforcedSword");
        this.setCreativeTab(CreativeTabsLoader.tabMFF);
	}
	public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn)
    {
        if (!worldIn.isRemote)
        {
            if (playerIn.isSneaking() && playerIn.world.isRainingAt(playerIn.getPosition()) && new ItemStack(Blocks.TNT).isItemEqual(playerIn.getHeldItemOffhand()))
            {
                System.out.println("onItemRightClick from ItemSwordReinforced");
                BlockPos pos = playerIn.getPosition();
                int id = GuiHandler.GUI_COMPRESSOR;
                playerIn.openGui(MyFoodFactory.instance, id, worldIn, pos.getX(), pos.getY(), pos.getZ());
                return new ActionResult<>(EnumActionResult.SUCCESS, playerIn.getHeldItem(handIn));
            }
        }
    	return new ActionResult<>(EnumActionResult.PASS, playerIn.getHeldItem(handIn));
    }
}
