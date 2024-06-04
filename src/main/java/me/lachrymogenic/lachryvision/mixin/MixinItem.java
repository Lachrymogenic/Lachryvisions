package me.lachrymogenic.lachryvision.mixin;

import me.lachrymogenic.lachryvision.Constants;
import net.minecraft.entity.Entity;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.injection.*;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import static net.minecraft.item.Item.ToolMaterial.*;

@Mixin(Item.class)
public abstract class MixinItem {

//    @Inject(method = "<clinit>", at = @At("RETURN"))
//    private static void modifyGoldToolMaterial(CallbackInfo ci) {
//        try {
//            Field field = Item.ToolMaterial.class.getDeclaredField("damageVsEntity");
//            field.setAccessible(true);
//            field.set(GOLD, 2.5F);
//        } catch (NoSuchFieldException | IllegalAccessException e) {
//            e.printStackTrace();
//        }
//    }

    @Overwrite(remap = false)
    public boolean isValidArmor(ItemStack stack, int armorType, Entity entity)
    {
        if (stack.getItem() instanceof ItemArmor)
        {
            return ((ItemArmor) stack.getItem()).armorType == armorType;
        }

        if (armorType == 0)
        {
            return stack.getItem() == Item.getItemFromBlock(Blocks.pumpkin) ||
                    stack.getItem() == Item.getItemFromBlock(Blocks.lit_pumpkin) ||
                    stack.getItem() == Item.getItemFromBlock(Blocks.dispenser) ||
                    stack.getItem() == Item.getItemFromBlock(Blocks.dropper) ||
                    stack.getItem() == Item.getItemFromBlock(Blocks.glass) ||
                    stack.getItem() == Item.getItemFromBlock(Blocks.stained_glass) ||
                    stack.getItem() == Items.skull;
        }

        return false;
    }

}
