package me.lachrymogenic.lachryvision.mixin;

import net.minecraft.client.gui.GuiFlatPresets;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.FlatLayerInfo;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

@Mixin(GuiFlatPresets.class)
public abstract class MixinGuiFlatPresets {

    @Inject(method = "<clinit>",at = @At("TAIL"),cancellable = true)
    private static void inject(CallbackInfo ci) {
        try {
            Method method = GuiFlatPresets.class.getDeclaredMethod("func_146421_a",
                    String.class, Item.class, BiomeGenBase.class, List.class, FlatLayerInfo[].class);
            method.setAccessible(true);

            method.invoke(null,"The Void",
                    Items.skull, BiomeGenBase.plains,
                    Arrays.asList(new String[] {"village", "biome_1"}),
                    new FlatLayerInfo[] {
                            new FlatLayerInfo(1, Blocks.air),
                            new FlatLayerInfo(3, Blocks.air),
                            new FlatLayerInfo(2, Blocks.air)
            });

            method.invoke(null,"The Nether",
                    Items.blaze_powder, BiomeGenBase.hell,
                    Arrays.asList(new String[] {"lava_lake"}),
                    new FlatLayerInfo[] {
                            new FlatLayerInfo(20, Blocks.netherrack),
                    });

            method.invoke(null,"The End",
                    Items.ender_eye, BiomeGenBase.sky,
                    Arrays.asList(new String[] {"village"}),
                    new FlatLayerInfo[] {
                            new FlatLayerInfo(20, Blocks.end_stone),
                    });
        }
        catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
             e.printStackTrace();
        }
    }

}
