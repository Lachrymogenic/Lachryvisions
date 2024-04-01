package me.lachrymogenic.lachryvision;

import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartingEvent;
import me.lachrymogenic.lachryvision.commands.CommandGMA;
import me.lachrymogenic.lachryvision.commands.CommandGMC;
import me.lachrymogenic.lachryvision.commands.CommandGMS;
import me.lachrymogenic.lachryvision.mixin.MixinItem;
import me.lachrymogenic.lachryvision.registry.BlockRegistry;
import me.lachrymogenic.lachryvision.registry.CraftingRegistry;
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
import net.minecraftforge.common.MinecraftForge;

@Mod(modid = Constants.MODID, version = Constants.VERSION)
public class Main
{
    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        BlockRegistry.registerBlocks();
        CraftingRegistry.register();
    }
    @EventHandler
    public void onServerStart(FMLServerStartingEvent event) {
        /** Commands**/
        ServerCommandManager commandManager = (ServerCommandManager) MinecraftServer.getServer().getCommandManager();
        commandManager.registerCommand(new CommandGMC());
        commandManager.registerCommand(new CommandGMS());
        commandManager.registerCommand(new CommandGMA());
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
        Items.golden_sword.setMaxDamage(20);
		// some example code
        //Constants.LOGGER.info("DIRT BLOCK >> "+Blocks.dirt.getUnlocalizedName());

    }
}
