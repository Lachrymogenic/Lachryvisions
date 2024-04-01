package me.lachrymogenic.lachryvision.mixin;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityBoat;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import org.spongepowered.asm.lib.Opcodes;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.injection.*;

import java.util.List;

@Mixin(EntityBoat.class)
public abstract class MixinEntityBoat extends Entity {

    public MixinEntityBoat(World p_i1582_1_) {
        super(p_i1582_1_);
    }
    @ModifyConstant(method = "onUpdate", constant = @Constant(doubleValue = 0.2D))
    private double modifyCollisionThreshold(double original) {
        return Double.MAX_VALUE;
    }

}
