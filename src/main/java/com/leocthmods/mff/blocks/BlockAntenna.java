package com.leocthmods.mff.blocks;

import java.util.Random;

import com.leocthmods.mff.CreativeTabsLoader;
import com.leocthmods.mff.MyFoodFactory;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockAntenna extends Block {

	public BlockAntenna() {
		super(Material.IRON);
		this.setCreativeTab(CreativeTabsLoader.tabMFF)
		.setUnlocalizedName("antenna")
		.setRegistryName(MyFoodFactory.MODID, "antenna");
		this.setSoundType(SoundType.METAL);
	}
	@Override
    public boolean isFullCube(IBlockState state)
    {
        return false;
    }

    @Override
    public boolean isOpaqueCube(IBlockState state)
    {
        return false;
    }
    @Override
    public boolean isNormalCube(IBlockState state) {
    		return false;
    }
    @Override
    public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos)
	{
	    return new AxisAlignedBB(0.1875, 0.0, 0.1875, 0.8125, 1.0, 0.8125);
	}
    public Item getItemDropped(IBlockState state, Random rand, int fortune) {
		return Item.getItemFromBlock(this);
	}
    public void onNeighborChange(IBlockAccess world, BlockPos pos, BlockPos neighbor){
    		if (world.isAirBlock(pos.down())) {
    			Block b = world.getBlockState(pos).getBlock();
    			b.dropBlockAsItem((World) world, pos, b.getDefaultState(), 1);
    		}
    }
    
}
