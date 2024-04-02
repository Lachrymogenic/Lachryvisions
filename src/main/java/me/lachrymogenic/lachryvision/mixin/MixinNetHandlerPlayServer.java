package me.lachrymogenic.lachryvision.mixin;

import me.lachrymogenic.lachryvision.Constants;
import net.minecraft.network.NetHandlerPlayServer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;

@Mixin(NetHandlerPlayServer.class)
public class MixinNetHandlerPlayServer {
    @ModifyConstant(method = "processUpdateSign", constant = @Constant(intValue = 15))
    private int modifyInteger(int original) {
        return Constants.signLength;
    }
}
