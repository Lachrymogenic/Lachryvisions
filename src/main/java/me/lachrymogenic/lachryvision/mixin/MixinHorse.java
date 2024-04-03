package me.lachrymogenic.lachryvision.mixin;

import cpw.mods.fml.common.ObfuscationReflectionHelper;
import me.lachrymogenic.lachryvision.Constants;
import net.minecraft.entity.Entity;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.passive.EntityHorse;
import net.minecraft.inventory.IInvBasic;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

@Mixin(EntityHorse.class)
public abstract class MixinHorse extends EntityAnimal implements IInvBasic {
    public MixinHorse(World p_i1681_1_) {
        super(p_i1681_1_);
    }
    @ModifyConstant(method = "getHurtSound", constant = @Constant(intValue = 3))
    private int modifyInteger(int original) {
        return 999;
    }

}
