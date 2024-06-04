package me.lachrymogenic.lachryvision;

import net.minecraftforge.common.config.Configuration;

import java.io.File;
import java.io.IOException;
import java.util.Stack;
import java.util.regex.Pattern;

public class Config {
    public static Configuration config;
    public static boolean NoBoatCrashing;
    public static boolean BetterSignEditing;
    public static boolean Stack16To64;
    public static boolean NoHorseRearing;
    public static String CropTrampling;
    public static String[] CropTramplingChoices = {"Crops trample","Crops protected by Leather Boots","Crops never trample"};
    public static boolean LeashableVillagers = true;

    public static boolean RegisterCustomBlocks;
    public static boolean RegisterCustomItems;

    public static boolean RegisterCustomCommands;
    public static boolean CrosshairVisibleThirdPerson;

    public static void assign() {
        CropTrampling = config.get("General","Crop Trampling",CropTramplingChoices[1],"" +
                "Decides whether or not crops should be trampled and the circumstance. If this value is set to Crops trample, " +
                "then crops will trample. If set to Crops never trample, then crops will never trample. " +
                "If set to Protected by Leather Boots then Crops trample without Leather Boots but not while wearing Leather Boots",
                CropTramplingChoices).getString();

        // EVERYTHING ELSE
        NoBoatCrashing = config.get("General", "No Boat Crashing", true,"" +
                "In 1.7.10, boats crash into walls, which can be annoying. When No Boat Crashing is enabled, this no longer" +
                " occurs.").getBoolean();

        BetterSignEditing = config.get("General", "Better Sign Editing", true,"" +
                "When BetterSignEditing is enabled, you can press left and right arrow keys to cycle in between" +
                " the lines, allowing you to fix mistakes. You can also right click signs to edit them.").getBoolean();
        CrosshairVisibleThirdPerson = config.get("General", "Crosshair Visible Third Person", true,"" +
                "By default, your crosshair is not hidden when you press F5. But when this variable is enabled, your crosshair " +
                "will be hidden in third person.").getBoolean();
        Stack16To64 = config.get("General", "Stack 16 to 64", true,"" +
                "All 16 stack items are converted to 64 stack items when this variable is enabled.").getBoolean();
        NoHorseRearing = config.get("General", "No Horse Rearing", true,"" +
                "By default, Horses rear when they take damage, which makes them a pain to use. " +
                "When this variable is enabled, Horses no longer rear.").getBoolean();
        LeashableVillagers = config.get("General", "Leashable Villagers", true,"" +
                "Toggles the ability to leash villagers.").getBoolean();

        RegisterCustomBlocks = config.get("Registry", "Register Custom Blocks", true,"" +
                "Toggles custom blocks like Log Slabs. Requires restart to take effect.").getBoolean();
        RegisterCustomItems = config.get("Registry", "Register Custom Items", true,"" +
                "Toggles custom items like Mutton. Requires restart to take effect.").getBoolean();
        RegisterCustomCommands = config.get("Registry", "Register Custom Commands", true,"" +
                "Toggles custom commands like /gmc and /fill").getBoolean();
    }


    public static void init(File location) {
        File newFile = new File(location + "/lachryvision/lachryvision.cfg");
        try  { newFile.createNewFile(); } catch (IOException var3) {}

        config = new Configuration(newFile);
        config.load();
        assign();
        config.save();
    }
}
