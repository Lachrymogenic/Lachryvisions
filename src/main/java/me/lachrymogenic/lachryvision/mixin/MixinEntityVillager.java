package me.lachrymogenic.lachryvision.mixin;

import net.minecraft.entity.passive.EntityVillager;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

@Mixin(EntityVillager.class)
public abstract class MixinEntityVillager {
    @Overwrite
    public boolean allowLeashing()
    {
        return true;
    }
}
