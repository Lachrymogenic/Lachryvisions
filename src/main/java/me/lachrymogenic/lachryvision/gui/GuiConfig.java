package me.lachrymogenic.lachryvision.gui;

import cpw.mods.fml.client.config.*;
import cpw.mods.fml.client.event.ConfigChangedEvent;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.eventhandler.Event;
import me.lachrymogenic.lachryvision.Config;
import me.lachrymogenic.lachryvision.Constants;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.resources.I18n;
import net.minecraft.util.ChatComponentText;
import net.minecraftforge.common.config.ConfigElement;
import net.minecraftforge.common.config.Configuration;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import static me.lachrymogenic.lachryvision.Config.assign;
import static me.lachrymogenic.lachryvision.Config.config;

public class GuiConfig extends cpw.mods.fml.client.config.GuiConfig {

    // new ConfigElement(
    //                        config.getCategory(Configuration.CATEGORY_GENERAL)
    //                ).getChildElements()
    public GuiConfig(GuiScreen parent) {
        super(parent,
                getConfigElements(),
                Constants.MODID,
                false,
                false,
                "Lachryvisions Config Menu"
        );
        titleLine2 = "Customize your gameplay experience";
    }

    public static List<IConfigElement> getConfigElements()
    {
        List<IConfigElement> Categories = new ArrayList<IConfigElement>();
        List<IConfigElement> CategoryGeneral = new ConfigElement(config.getCategory("general")).getChildElements();
        List<IConfigElement> CategoryRegistry = new ConfigElement(config.getCategory("registry")).getChildElements();

        Categories.add(new DummyConfigElement.DummyCategoryElement("General", "me.lachryvision.config.general", CategoryGeneral));
        Categories.add(new DummyConfigElement.DummyCategoryElement("Registry", "me.lachryvision.config.registry", CategoryRegistry));

        return Categories;
    }


    @Override
    public void initGui()
    {
        // You can add buttons and initialize fields here
        super.initGui();
    }


    @Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks)
    {
        // You can do things like create animations, draw additional elements, etc. here
        super.drawScreen(mouseX, mouseY, partialTicks);
    }

    public static void checkVariables() {
        config.load();
        assign();
        Constants.checkItemConfig();
    }

    @Override
    protected void actionPerformed(GuiButton button)
    {
        if (button.id == 2000)
        {
            // DEBUG
            System.out.println("Pressed DONE button");
            boolean flag = true;
            try
            {
                if ((configID != null || this.parentScreen == null || !(this.parentScreen instanceof GuiConfig))
                        && (this.entryList.hasChangedEntry(true)))
                {
                    // DEBUG
                    System.out.println("Saving config elements");
                    boolean requiresMcRestart = this.entryList.saveConfigElements();

                    if (Loader.isModLoaded(modID))
                    {
                        ConfigChangedEvent event = new ConfigChangedEvent.OnConfigChangedEvent(modID, configID, isWorldRunning, requiresMcRestart);
                        FMLCommonHandler.instance().bus().post(event);
                        if (!event.getResult().equals(Event.Result.DENY))
                            FMLCommonHandler.instance().bus().post(new ConfigChangedEvent.PostConfigChangedEvent(modID, configID, isWorldRunning, requiresMcRestart));
                        config.save();
                        if (requiresMcRestart)
                        {
                            flag = false;
                            mc.displayGuiScreen(new GuiMessageDialog(parentScreen, "fml.configgui.gameRestartTitle",
                                    new ChatComponentText(I18n.format("fml.configgui.gameRestartRequired")), "fml.configgui.confirmRestartMessage"));
                        }

                        if (this.parentScreen instanceof GuiConfig)
                            ((GuiConfig) this.parentScreen).needsRefresh = true;
                    }
                }
            }
            catch (Throwable e)
            {
                e.printStackTrace();
            }

            if (flag)
                this.mc.displayGuiScreen(this.parentScreen);
            checkVariables();
        }
    }
}
