package com.leocthmods.mff.blocks;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public abstract class BlockEdible extends Block {
	
	public static PropertyInteger bites = PropertyInteger.create("bites", 0, 7);
	private static IProperty<?>[] property = new IProperty[] {bites}; 
	protected static final AxisAlignedBB[] AABB = 
	new AxisAlignedBB[] {
	new AxisAlignedBB(0.0D,    0D, 0D, 1D, 1D, 1D),
	new AxisAlignedBB(0.125D,  0D, 0D, 1D, 1D, 1D), 
	new AxisAlignedBB(0.25D,   0D, 0D, 1D, 1D, 1D), 
	new AxisAlignedBB(0.375D,  0D, 0D, 1D, 1D, 1D), 
	new AxisAlignedBB(0.5D,    0D, 0D, 1D, 1D, 1D), 
	new AxisAlignedBB(0.625D,  0D, 0D, 1D, 1D, 1D), 
	new AxisAlignedBB(0.75D,   0D, 0D, 1D, 1D, 1D), 
	new AxisAlignedBB(0.875D,  0D, 0D, 1D, 1D, 1D)};
	public enum EnumBlockEdible {
		MEAT_BLOCK,
		TOFU_BLOCK
	}
	public BlockEdible(Material materialIn) {
		super(materialIn);
	}
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ, EnumBlockEdible type)
	{
		if (!worldIn.isRemote && playerIn.isSneaking() && playerIn instanceof EntityPlayerMP)
		{
			if (type.equals(EnumBlockEdible.MEAT_BLOCK))
				return this.eat(worldIn, pos, state, playerIn, 4);
			else if (type.equals(EnumBlockEdible.TOFU_BLOCK))
				return this.eat(worldIn, pos, state, playerIn, 3);
			else
				return false;
		}
		else
		{	
			return false;
		}
	}
	private boolean eat(World worldIn, BlockPos pos, IBlockState state, EntityPlayer player, int foodlevel)
    {
        if (!player.getFoodStats().needFood() && player instanceof EntityPlayerMP)
        {
            return false;
        }
        else
        {
            player.getFoodStats().addStats(foodlevel, 0.2F);
            int i = ((Integer)state.getValue(bites)).intValue();

            if (i < 7)
            {
                worldIn.setBlockState(pos, state.withProperty(bites, Integer.valueOf(i + 1)), 3);
            }
            else
            {
                worldIn.setBlockToAir(pos);
            }

            return true;
        }
    }
	protected BlockStateContainer createBlockState()
	 {
		 return new BlockStateContainer(this, property);
	 }
	public int getMetaFromState(IBlockState state)
	{
		return ((Integer)state.getValue(bites)).intValue();
	}
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos)
	{
	    return AABB[((Integer)state.getValue(bites)).intValue()];
	}
	public boolean isFullCube(IBlockState state)
	{
	    return false;
	}
	public boolean isOpaqueCube(IBlockState state)
	{
	    return false;
	}
	public Item getItemDropped(IBlockState state, Random rand, int fortune, EnumBlockEdible type) {
		if (((Integer) state.getValue(bites)) > 0) {
			return Items.AIR;
		}
		if (type.equals(EnumBlockEdible.MEAT_BLOCK)) {
			return Item.getItemFromBlock(BlockLoader.meatBlock);
		}	
		else if (type.equals(EnumBlockEdible.TOFU_BLOCK)) {
			return Item.getItemFromBlock(BlockLoader.tofuBlock);
		}
		return Items.AIR;
	}
}
