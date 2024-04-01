package me.lachrymogenic.lachryvision.registry;

import cpw.mods.fml.common.registry.GameRegistry;
import me.lachrymogenic.lachryvision.blocks.LogSlab;
import me.lachrymogenic.lachryvision.items.ItemLogSlab;
import net.minecraft.block.Block;
import net.minecraft.block.BlockSlab;
import net.minecraft.command.ServerCommandManager;

import java.util.ArrayList;
import java.util.List;

public class BlockRegistry {
    public static List<Block> blockList=new ArrayList<Block>();
    public static List<Block> blockSlabList=new ArrayList<Block>();
    public static BlockSlab LogSlab = new LogSlab("log_slab",false);
    public static BlockSlab DoubleLogSlab = new LogSlab("double_log_slab",true);
    public static void registerBlocks() {
        blockSlabList.add(LogSlab);
        blockSlabList.add(DoubleLogSlab);
        for(Block block:blockSlabList) {
            GameRegistry.registerBlock(block, ItemLogSlab.class,block.getUnlocalizedName().substring(5));
        }
        for(Block block:blockList) {
            GameRegistry.registerBlock(block,block.getUnlocalizedName());
        }
    }

}
