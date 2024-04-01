package me.lachrymogenic.lachryvision.mixin;

import me.lachrymogenic.lachryvision.Constants;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.inventory.GuiEditSign;
import net.minecraft.item.Item;
import net.minecraft.tileentity.TileEntitySign;
import net.minecraft.util.ChatAllowedCharacters;
import net.minecraft.util.ReportedException;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.lang.reflect.Field;

@Mixin(GuiEditSign.class)
public abstract class MixinSign extends GuiScreen {
    @Shadow
    private TileEntitySign tileSign;
    @Shadow
    private int editLine;
    private static int backLogInt = 0;
    private GuiButton doneBtn;


    public MixinSign(TileEntitySign p_i1097_1_)
    {
        this.tileSign = p_i1097_1_;
    }


    @Inject(method = "onGuiClosed",at = @At("HEAD"),cancellable = true)
    public void onGuiClosed(CallbackInfo ci) {
        backLogInt = 0;
        Constants.backLogInt = 0;
    }

    /** Allows you to go back and forth when editing signs. Was so annoying!**/
    public String returnString(String text, char character, boolean remove) {
        StringBuilder stringBuilder = new StringBuilder(text);
        int index = text.length() + backLogInt;
        if (index != -1) {
            if (remove) {
                if (index - 1 != -1) {
                    stringBuilder.deleteCharAt(index - 1);
                }
            }
            else {
                stringBuilder.insert(index, character);
            }
        }
        return stringBuilder.toString();
    }

    @Overwrite
    protected void keyTyped(char p_73869_1_, int p_73869_2_) throws ReportedException
    {
        char character = p_73869_1_;
        int integer = p_73869_2_;
        if (integer == 203) {
           if (backLogInt > -this.tileSign.signText[this.editLine].length()) backLogInt--;
        }
        else if (integer == 205) {
            if (backLogInt < 0) backLogInt++;
        }
        //Constants.LOGGER.info("Character: " + character + " Integer: " + integer + " Text: " + this.tileSign.signText[this.editLine] + " Backlog: " + backLogInt);
        if (integer == 200)
        {
            backLogInt = 0;
            this.editLine = this.editLine - 1 & 3;
        }

        if (integer == 208 || integer == 28 || integer == 156)
        {
            backLogInt = 0;
            this.editLine = this.editLine + 1 & 3;
        }

        if (integer == 14 && !this.tileSign.signText[this.editLine].isEmpty())
        {
            this.tileSign.signText[this.editLine] = returnString(this.tileSign.signText[this.editLine],character,true);
            //this.tileSign.signText[this.editLine] = this.tileSign.signText[this.editLine].substring(0, this.tileSign.signText[this.editLine].length() - 1);
        }

        if (ChatAllowedCharacters.isAllowedCharacter(character) && this.tileSign.signText[this.editLine].length() < Constants.signLength)
        {
            this.tileSign.signText[this.editLine] = returnString(this.tileSign.signText[this.editLine],character,false);
        }

        if (integer == 1)
        {
            backLogInt = 0;
            this.actionPerformed(this.doneBtn);
        }
        Constants.backLogInt = backLogInt;
    }
}

