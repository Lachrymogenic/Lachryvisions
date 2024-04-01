package me.lachrymogenic.lachryvision.mixin;

import me.lachrymogenic.lachryvision.Constants;
import net.minecraft.network.INetHandler;
import net.minecraft.network.Packet;
import net.minecraft.network.PacketBuffer;
import net.minecraft.network.play.INetHandlerPlayServer;
import net.minecraft.network.play.client.C12PacketUpdateSign;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;

import java.io.IOException;


@Mixin(C12PacketUpdateSign.class)
public abstract class MixinC12PacketUpdateSign extends Packet {
    @ModifyConstant(method = "readPacketData", constant = @Constant(intValue = 15))
    private int modifyInteger(int original) {
        return Constants.signLength;
    }

}
