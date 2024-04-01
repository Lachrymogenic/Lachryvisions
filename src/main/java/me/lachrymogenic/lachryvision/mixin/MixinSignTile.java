package me.lachrymogenic.lachryvision.mixin;

import me.lachrymogenic.lachryvision.Constants;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntitySign;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;

@Mixin(TileEntitySign.class)
public abstract class MixinSignTile extends TileEntity {
    @ModifyConstant(method = "readFromNBT", constant = @Constant(intValue = 15))
    private int modifyInteger(int original) {
        return Constants.signLength;
    }
}
