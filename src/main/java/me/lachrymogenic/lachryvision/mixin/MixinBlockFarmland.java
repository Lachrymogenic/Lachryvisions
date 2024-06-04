package me.lachrymogenic.lachryvision.mixin;

import me.lachrymogenic.lachryvision.Config;
import me.lachrymogenic.lachryvision.Constants;
import net.minecraft.block.BlockFarmland;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.server.MinecraftServer;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Objects;
import java.util.Random;

@Mixin(BlockFarmland.class)
public abstract class MixinBlockFarmland {
    @Inject(method = "onFallenUpon",at = @At("HEAD"),cancellable = true)
    public void onFallenUpon(World world, int x, int y, int z, Entity entity, float p_149746_6_, CallbackInfo ci)
    {
        if (!Config.NoTramplingCrops) {
            if (Config.LeatherBootsProtectCrops) {
                if (!world.isRemote && world.rand.nextFloat() < p_149746_6_ - 0.5F)
                {
                    if (!(entity instanceof EntityPlayer) && !world.getGameRules().getGameRuleBooleanValue("mobGriefing"))
                    {
                        ci.cancel();
                        return;
                    }
                    if (entity instanceof EntityPlayer) {
                        EntityPlayer player = ((EntityPlayer) entity);
                        if (player.getCurrentArmor(0) != null) {
                            if ((Objects.equals(player.getCurrentArmor(0).getItem().getUnlocalizedName(), "item.bootsCloth")) &&
                                    Config.LeatherBootsProtectCrops) {
                                if (!player.capabilities.isCreativeMode) player.getCurrentArmor(0).attemptDamageItem(1,new Random());
                                if (
                                        player.getCurrentArmor(0).getItemDamage() >=
                                                player.getCurrentArmor(0).getMaxDamage()
                                ) {
                                    player.renderBrokenItemStack(((EntityPlayer) entity).getCurrentArmor(0));
                                    player.setCurrentItemOrArmor(1,null);
                                }
                                ci.cancel();
                                return;
                            }
                        }
                    }
                    world.setBlock(x, y, z, Blocks.dirt);
                }
                ci.cancel();
            }
        }
    }

}
