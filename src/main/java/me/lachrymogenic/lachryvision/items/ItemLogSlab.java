package me.lachrymogenic.lachryvision.items;

import me.lachrymogenic.lachryvision.registry.BlockRegistry;
import net.minecraft.block.Block;
import net.minecraft.item.ItemSlab;

public class ItemLogSlab extends ItemSlab {
    public ItemLogSlab(Block block) {
        super(block, BlockRegistry.LogSlab, BlockRegistry.DoubleLogSlab, (block == BlockRegistry.DoubleLogSlab));
        this.setUnlocalizedName("log_slab");
    }
}
