package me.lachrymogenic.lachryvision.blocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import me.lachrymogenic.lachryvision.Constants;
import me.lachrymogenic.lachryvision.registry.BlockRegistry;
import net.minecraft.block.BlockWoodSlab;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

import java.util.List;
import java.util.Random;

public class LogSlab extends BlockWoodSlab {
    public LogSlab(String name, boolean double_slab) {
        super(double_slab);
        this.setBlockName(name);
        this.setHardness(2.0F);
        this.setStepSound(soundTypeWood);
        this.useNeighborBrightness = true;
        this.setResistance(2.0F);
        if (!double_slab) {
            this.setCreativeTab(CreativeTabs.tabBlock);
        }
    }

    @Override
    public ItemStack getPickBlock(MovingObjectPosition target, World world, int x, int y, int z, EntityPlayer player) {
        return new ItemStack(Item.getItemFromBlock(BlockRegistry.LogSlab),1,world.getBlockMetadata(x,y,z));
    }

    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int side, int blockID)
    {
        //Constants.LOGGER.info("BlockID is " + blockID);
        /** 5 and 13 are Dark Oak Slabs, which require a different system due to texture mismatch*/
        if (blockID == 5 || blockID == 13)  {
            if (side == 0) {
                return Blocks.log.getIcon(5, blockID & 7);
            }
            else if (side == 1) {
                return Blocks.log.getIcon(5, blockID & 7);
            }
            else { return Blocks.log.getIcon(1, blockID & 7); }
        }
        /** 4 and 12 are Acacia Slabs, which require a different system due to texture and block mismatch*/
        else if (blockID == 4 || blockID == 12) {
            if (side == 0) {
                return Blocks.log2.getIcon(5, blockID & 7);
            }
            else if (side == 1) {
                return Blocks.log2.getIcon(5, blockID & 7);
            }
            else { return Blocks.log2.getIcon(1, blockID & 7); }
        }
        else {
            /** Default code */
            return Blocks.log.getIcon(side, blockID & 7);
        }
    }
    public Item getItemDropped(int p_149650_1_, Random p_149650_2_, int p_149650_3_)
    {
        return Item.getItemFromBlock(BlockRegistry.LogSlab);
    }

    /**
     * Returns an item stack containing a single instance of the current block type. 'i' is the block's subtype/damage
     * and is ignored for blocks which do not support subtypes. Blocks which cannot be harvested should return null.
     */
    protected ItemStack createStackedBlock(int p_149644_1_)
    {
        return new ItemStack(Item.getItemFromBlock(BlockRegistry.LogSlab), 2, p_149644_1_ & 7);
    }
    @SideOnly(Side.CLIENT)
    public void getSubBlocks(Item p_149666_1_, CreativeTabs p_149666_2_, List p_149666_3_)
    {
        if (p_149666_1_ != Item.getItemFromBlock(BlockRegistry.DoubleLogSlab))
        {
            for (int i = 0; i < field_150005_b.length; ++i)
            {
                p_149666_3_.add(new ItemStack(p_149666_1_, 1, i));
            }
        }
    }
}
