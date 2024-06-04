package me.lachrymogenic.lachryvision;

import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartingEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import me.lachrymogenic.lachryvision.commands.*;
import me.lachrymogenic.lachryvision.events.RightClickBlockEvent;
import me.lachrymogenic.lachryvision.mixin.MixinItem;
import me.lachrymogenic.lachryvision.registry.BlockRegistry;
import me.lachrymogenic.lachryvision.registry.CraftingRegistry;
import me.lachrymogenic.lachryvision.registry.ItemRegistry;
import net.minecraft.client.Minecraft;
import net.minecraft.command.ICommand;
import net.minecraft.command.ICommandManager;
import net.minecraft.command.ServerCommandManager;
import net.minecraft.init.Blocks;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.server.MinecraftServer;
import net.minecraft.world.WorldSettings;
import net.minecraftforge.common.MinecraftForge;

@Mod(modid = Constants.MODID, version = Constants.VERSION,guiFactory = Constants.GUIFACTORY)
public class Main
{
    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        Config.init(event.getModConfigurationDirectory());
        BlockRegistry.registerBlocks();
        CraftingRegistry.register();
        ItemRegistry.register();
    }
    @EventHandler
    public void onServerStart(FMLServerStartingEvent event) {
        /** Commands**/
        //ServerCommandManager commandManager = (ServerCommandManager) MinecraftServer.getServer().getCommandManager();
        if (Config.RegisterCustomCommands) {
            event.registerServerCommand(new CommandGamemode(WorldSettings.GameType.CREATIVE));
            event.registerServerCommand(new CommandGamemode(WorldSettings.GameType.SURVIVAL));
            event.registerServerCommand(new CommandGamemode(WorldSettings.GameType.ADVENTURE));
            event.registerServerCommand(new CommandFill());
        }
    }
    @EventHandler
    public void init(FMLInitializationEvent event)
    {
        Constants.checkItemConfig();
        //Items.golden_sword.setNoRepair();
        MinecraftForge.EVENT_BUS.register(new me.lachrymogenic.lachryvision.events.RightClickBlockEvent());
        GameRegistry.addSmelting(ItemRegistry.raw_mutton,new ItemStack(ItemRegistry.cooked_mutton,1),30);

    }
}
