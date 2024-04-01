package me.lachrymogenic.lachryvision.mixin;

import me.lachrymogenic.lachryvision.Constants;
import net.minecraft.block.BlockFarmland;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

import java.util.Objects;
import java.util.Random;

@Mixin(BlockFarmland.class)
public abstract class MixinBlockFarmland {
    @Overwrite
    public void onFallenUpon(World world, int x, int y, int z, Entity entity, float p_149746_6_)
    {
        if (!world.isRemote && world.rand.nextFloat() < p_149746_6_ - 0.5F)
        {
            if (!(entity instanceof EntityPlayer) && !world.getGameRules().getGameRuleBooleanValue("mobGriefing"))
            {
                return;
            }
            if (entity instanceof EntityPlayer) {
                if (((EntityPlayer) entity).getCurrentArmor(0) != null) {
                    if (Objects.equals(((EntityPlayer) entity).getCurrentArmor(0).getItem().getUnlocalizedName(), "item.bootsCloth")) {
                        ((EntityPlayer) entity).getCurrentArmor(0).attemptDamageItem(1,new Random());
                        if (
                                ((EntityPlayer) entity).getCurrentArmor(0).getItemDamage() >=
                                ((EntityPlayer) entity).getCurrentArmor(0).getMaxDamage()
                        ) {
                            ((EntityPlayer) entity).renderBrokenItemStack(((EntityPlayer) entity).getCurrentArmor(0));
                            ((EntityPlayer) entity).setCurrentItemOrArmor(1,null);
                        }
                        return;
                    }
                }
            }
            world.setBlock(x, y, z, Blocks.dirt);
        }
    }

}
