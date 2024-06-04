package me.lachrymogenic.lachryvision.mixin;

import me.lachrymogenic.lachryvision.Config;
import me.lachrymogenic.lachryvision.registry.ItemRegistry;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.passive.EntitySheep;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.concurrent.ThreadLocalRandom;

@Mixin(EntitySheep.class)
public abstract class MixinSheep extends EntityAnimal {

    public MixinSheep(World p_i1691_1_) {
        super(p_i1691_1_);
    }

    @Inject(method = "dropFewItems",at=@At("HEAD"),cancellable = true)
    protected void newDrop(boolean p_70628_1_, int p_70628_2_, CallbackInfo ci)
    {
        if (Config.RegisterCustomItems) {
            this.entityDropItem(new ItemStack(ItemRegistry.raw_mutton, ThreadLocalRandom.current().nextInt(1, 3) + p_70628_2_),0.0F);
        }
    }
}
