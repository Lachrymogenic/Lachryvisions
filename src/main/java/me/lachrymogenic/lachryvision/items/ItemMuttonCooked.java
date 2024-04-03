package me.lachrymogenic.lachryvision.items;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemFood;

public class ItemMuttonCooked extends ItemFood {
    public ItemMuttonCooked() {
        super(6,0.8F,true);
        setCreativeTab(CreativeTabs.tabFood);
        setTextureName("mutton_cooked");
        setUnlocalizedName("mutton_cooked");
    }
}
