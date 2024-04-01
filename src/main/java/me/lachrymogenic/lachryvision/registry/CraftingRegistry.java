package me.lachrymogenic.lachryvision.registry;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

import java.util.ArrayList;
import java.util.List;

public class CraftingRegistry {
    public static List<Block> blockList = new ArrayList<Block>();
    /** Adds blocks to the list and then creates recipes based on their index*/
    public static void register() {
        blockList.add(Blocks.stone);
        blockList.add(Blocks.sandstone);
        blockList.add(Blocks.planks);
        blockList.add(Blocks.cobblestone);
        blockList.add(Blocks.brick_block);
        blockList.add(Blocks.stonebrick);
        blockList.add(Blocks.nether_brick);
        blockList.add(Blocks.quartz_block);
        /** Crafting slabs back into blocks*/
        for (Block block : blockList)
        {
            GameRegistry.addShapelessRecipe(new ItemStack(block,1),
                    new ItemStack(Blocks.stone_slab,1,blockList.indexOf(block)),
                    new ItemStack(Blocks.stone_slab,1,blockList.indexOf(block)))
            ;
        }

        for (int i = 0; i < 7; i++) {
            GameRegistry.addShapelessRecipe(new ItemStack(Blocks.planks,1,i),
                    new ItemStack(Blocks.wooden_slab,1,i),
                    new ItemStack(Blocks.wooden_slab,1,i));
        }
        /** Log Slabs*/
        for (int i = 0; i < 6; i++) {
            if (i == 4 || i == 5) {
                GameRegistry.addRecipe(new ItemStack(BlockRegistry.LogSlab,6,i),
                        new Object[] {"###", '#', new ItemStack(Blocks.log2,1,i - 4)});
                GameRegistry.addRecipe(new ItemStack(Blocks.log2,1,i - 4),
                        new Object[] {"#", "#", '#', new ItemStack(BlockRegistry.LogSlab,1,i)});
            }
            else {
                GameRegistry.addRecipe(new ItemStack(BlockRegistry.LogSlab,6,i),
                        new Object[] {"###", '#', new ItemStack(Blocks.log,1,i)});
                GameRegistry.addRecipe(new ItemStack(Blocks.log,1,i),
                        new Object[] {"#", "#", '#', new ItemStack(BlockRegistry.LogSlab,1,i)});
            }
        }

    }

}
