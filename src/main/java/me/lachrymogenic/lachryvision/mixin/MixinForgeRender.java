package me.lachrymogenic.lachryvision.mixin;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiIngame;
import net.minecraftforge.client.GuiIngameForge;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(GuiIngameForge.class)
public class MixinForgeRender extends GuiIngame {
    public MixinForgeRender(Minecraft p_i1036_1_) {
        super(p_i1036_1_);
    }

    @Inject(method = "renderCrosshairs",at = @At("HEAD"), cancellable = true,remap = false)
    private void renderCrosshairs(int width, int height, CallbackInfo cir) {
        if (Minecraft.getMinecraft().gameSettings.thirdPersonView > 0) {
            cir.cancel();
        }
    }
}
