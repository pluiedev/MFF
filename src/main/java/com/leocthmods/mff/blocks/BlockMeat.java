package com.leocthmods.mff.blocks;

import java.util.Random;

import com.leocthmods.mff.CreativeTabsLoader;
import com.leocthmods.mff.MyFoodFactory;
import com.leocthmods.mff.blocks.material.MaterialList;

import net.minecraft.block.SoundType;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockMeat extends BlockEdible {
	public static PropertyInteger bites = PropertyInteger.create("bites", 0, 7);
	protected static final AxisAlignedBB[] AABB = BlockEdible.AABB;
	@SuppressWarnings("deprecation")
	public BlockMeat() {
		//TODO Let the BlockState stay when entering the game.
		super(MaterialList.MEAT);
		this.setResistance(3)
		.setUnlocalizedName("blockMeat")
		.setRegistryName(MyFoodFactory.MODID, "meat_block")
		.setHardness(0.1f)
		.setHarvestLevel("spoon", 1);
		this.slipperiness = 0.8f;
		this.setCreativeTab(CreativeTabsLoader.tabMFF);
		this.setSoundType(SoundType.SLIME);
		this.setDefaultState(this.blockState.getBaseState().withProperty(bites, Integer.valueOf(0)));
	}
	public void onEntityWalk(World worldIn, BlockPos pos, Entity entityIn)
    {
        if (Math.abs(entityIn.motionY) < 0.1D && !entityIn.isSneaking())
        {
            double slowness = 0.7D + Math.abs(entityIn.motionY) * 0.2D;
            entityIn.motionX *= slowness;
            entityIn.motionZ *= slowness;
        }

        super.onEntityWalk(worldIn, pos, entityIn);
    }
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
		return super.onBlockActivated(worldIn, pos, state, playerIn, hand, facing, hitX, hitY, hitZ, EnumBlockEdible.MEAT_BLOCK);
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
		return super.getItemDropped(state, rand, fortune);
    }
}
