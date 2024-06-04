package me.lachrymogenic.lachryvision;

import net.minecraft.init.Items;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

// In a separate class so we can safely reference it in coremod code without triggering the mod class to load early
public class Constants {
    public static final String MODID = "lachryvision";
    public static final String GUIFACTORY = "me.lachrymogenic.lachryvision.gui.GuiFactory";
    public static final String VERSION = "1.2";
    public static final Logger LOGGER = LogManager.getLogger(MODID);

    public static int backLogInt;
    public static int signLength = 16;
    
    public static void checkItemConfig() {
        if (Config.Stack16To64) {
            Constants.itemStack(64);
        }
        else {
            Constants.itemStack(16);
        }
    }
    public static void itemStack(int num) {
        Items.snowball.setMaxStackSize(num);
        Items.egg.setMaxStackSize(num);
        Items.sign.setMaxStackSize(num);
        Items.ender_pearl.setMaxStackSize(num);
        Items.experience_bottle.setMaxStackSize(num);
    }


}
