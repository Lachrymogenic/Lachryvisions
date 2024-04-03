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

@Mod(modid = Constants.MODID, version = Constants.VERSION)
public class Main
{
    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        BlockRegistry.registerBlocks();
        CraftingRegistry.register();
        ItemRegistry.register();
    }
    @EventHandler
    public void onServerStart(FMLServerStartingEvent event) {
        /** Commands**/
        //ServerCommandManager commandManager = (ServerCommandManager) MinecraftServer.getServer().getCommandManager();
        event.registerServerCommand(new CommandGamemode(WorldSettings.GameType.CREATIVE));
        event.registerServerCommand(new CommandGamemode(WorldSettings.GameType.SURVIVAL));
        event.registerServerCommand(new CommandGamemode(WorldSettings.GameType.ADVENTURE));
        event.registerServerCommand(new CommandFill());
    }
    @EventHandler
    public void init(FMLInitializationEvent event)
    {
        Items.snowball.setMaxStackSize(64);
        Items.egg.setMaxStackSize(64);
        Items.sign.setMaxStackSize(64);
        Items.ender_pearl.setMaxStackSize(64);
        Items.experience_bottle.setMaxStackSize(64);
        Items.golden_sword.setNoRepair();
        MinecraftForge.EVENT_BUS.register(new me.lachrymogenic.lachryvision.events.RightClickBlockEvent());
        GameRegistry.addSmelting(ItemRegistry.raw_mutton,new ItemStack(ItemRegistry.cooked_mutton,1),30);

    }
}
