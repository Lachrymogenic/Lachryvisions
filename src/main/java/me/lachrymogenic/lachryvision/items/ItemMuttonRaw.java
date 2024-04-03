package me.lachrymogenic.lachryvision.items;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemFood;

public class ItemMuttonRaw extends ItemFood {
    public ItemMuttonRaw() {
        super(2,0.3F,true);
        setCreativeTab(CreativeTabs.tabFood);
        setTextureName("mutton_raw");
        setUnlocalizedName("mutton_raw");
    }
}
