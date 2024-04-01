package me.lachrymogenic.lachryvision.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockSlab;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.world.World;

import java.util.Random;

public class LachrySlab extends BlockSlab {
    private String name;

    public LachrySlab(String name, boolean double_slab, Material materialIn) {
        super(double_slab,materialIn);
        this.name = name;
        this.setBlockName(name);
        if (!double_slab) {
            this.setCreativeTab(CreativeTabs.tabBlock);
        }
    }

    @Override
    public String func_150002_b(int meta) {
        return this.name;
    }
}
