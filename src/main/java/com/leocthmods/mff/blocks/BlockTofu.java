package com.leocthmods.mff.blocks;

import java.util.Random;

import com.leocthmods.mff.CreativeTabsLoader;
import com.leocthmods.mff.MyFoodFactory;
import com.leocthmods.mff.blocks.material.MaterialList;

import net.minecraft.block.SoundType;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockTofu extends BlockEdible {
	public static PropertyInteger bites = PropertyInteger.create("bites", 0, 7);
	protected static final AxisAlignedBB[] AABB = BlockEdible.AABB;
	
	@SuppressWarnings("deprecation")
	public BlockTofu() {
		super(MaterialList.TOFU);
		this.setResistance(2)
		.setUnlocalizedName("blockTofu")
		.setRegistryName(MyFoodFactory.MODID, "tofu_block")
		.setHardness(0.05f)
		.setHarvestLevel("spoon", 1);
		this.slipperiness = 0.9f;
		this.setCreativeTab(CreativeTabsLoader.tabMFF);
		this.setSoundType(SoundType.CLOTH);
		this.setDefaultState(this.blockState.getBaseState().withProperty(bites, Integer.valueOf(0)));
	}
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
		return super.onBlockActivated(worldIn, pos, state, playerIn, hand, facing, hitX, hitY, hitZ, EnumBlockEdible.TOFU_BLOCK);
	}
	protected BlockStateContainer createBlockState() {
		return super.createBlockState();
	}
	public int getMetaFromState(IBlockState state)
	{
		return super.getMetaFromState(state);
	}
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos)
	{
	    return super.getBoundingBox(state, source, pos);
	}
	public boolean isFullCube(IBlockState state)
	{
	    return false;
	}
	public boolean isOpaqueCube(IBlockState state)
	{
		return false;
	}
	public Item getItemDropped(IBlockState state, Random rand, int fortune)
    {
		return super.getItemDropped(state, rand, fortune, EnumBlockEdible.TOFU_BLOCK);
    }
}
