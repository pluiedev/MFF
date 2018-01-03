package com.leocthmods.mff.blocks;

import com.leocthmods.mff.CreativeTabsLoader;
import com.leocthmods.mff.MyFoodFactory;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockMechanicFrame extends Block {
	public BlockMechanicFrame() {
		super(Material.IRON);
		this.setUnlocalizedName("mechanicFrame");
		this.setRegistryName(MyFoodFactory.MODID, "mechanic_frame");
		this.setCreativeTab(CreativeTabsLoader.tabMFF);
		this.setHarvestLevel("pickaxe", 2);
		this.setHardness(5);
		this.setSoundType(SoundType.METAL);
		
	}

	@SideOnly(Side.CLIENT)
    public BlockRenderLayer getBlockLayer()
    {
        return BlockRenderLayer.CUTOUT;
    }

    public boolean isFullCube(IBlockState state)
    {
    		return false;
    }
    public boolean isOpaqueCube(IBlockState state)
    {
    		return false;
    }
    
    public boolean isNormalCube(IBlockState state)
    {
    		return false;
    }
    public void onBlockHarvested(World worldIn, BlockPos pos, IBlockState state, EntityPlayer player)
    {
    		while (worldIn.getBlockState(pos).getBlock() == this) {
    			worldIn.playSound((EntityPlayer)null, pos, SoundEvents.BLOCK_METAL_BREAK, SoundCategory.BLOCKS, 0.5F, worldIn.rand.nextFloat() * 0.1F + 0.9F);
    			worldIn.destroyBlock(pos, true);
			pos = pos.up();
		}
    }
    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ)
    {
    		if (playerIn instanceof EntityPlayerMP && (playerIn.getHeldItem(hand).getItem() == Item.getItemFromBlock(BlockLoader.mechanicFrameBlock))) {
    			while (worldIn.getBlockState(pos).getBlock() == this) {
    					pos = pos.up();
    			}
    			if (worldIn.getBlockState(pos).getBlock().isReplaceable(worldIn, pos)) {
    				worldIn.setBlockState(pos, state);
    				playerIn.getHeldItem(hand).grow(-1);
    				return true;
    			}
    			
    		}
    		return false;
    }
    public boolean isLadder(IBlockState state, IBlockAccess world, BlockPos pos, EntityLivingBase entity)
    {
    		 return true;
    }
}
