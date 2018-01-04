package com.leocthmods.mff.gui;

import com.leocthmods.mff.MyFoodFactory;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;
import net.minecraftforge.fml.common.network.NetworkRegistry;

public class GuiHandler implements IGuiHandler{

    public static final int GUI_COMPRESSOR = 1;

    public GuiHandler()
    {
        NetworkRegistry.INSTANCE.registerGuiHandler(MyFoodFactory.instance, this);
    }

    @Override
    public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z)
    {
        switch (ID) {
            case GUI_COMPRESSOR:
                return new CompressorInterface();
            default:
                return null;
        }
    }

    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z)
    {
        switch (ID) {
            case GUI_COMPRESSOR:
                return new GuiCompressor(new CompressorInterface());
            default:
                return null;
        }
    }
}
