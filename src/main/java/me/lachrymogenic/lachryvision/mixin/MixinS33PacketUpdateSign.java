package me.lachrymogenic.lachryvision.mixin;

import me.lachrymogenic.lachryvision.Constants;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S33PacketUpdateSign;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;

@Mixin(S33PacketUpdateSign.class)
public abstract class MixinS33PacketUpdateSign extends Packet {
    @ModifyConstant(method = "readPacketData", constant = @Constant(intValue = 15))
    private int modifyInteger(int original) {
        return Constants.signLength;
    }
}
