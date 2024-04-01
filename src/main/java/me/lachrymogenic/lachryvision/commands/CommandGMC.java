package me.lachrymogenic.lachryvision.commands;

import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.world.WorldSettings;

public class CommandGMC extends CommandBase {
    @Override
    public String getCommandName() {
        return "gmc";
    }

    public int getRequiredPermissionLevel()
    {
        return 2;
    }

    @Override
    public String getCommandUsage(ICommandSender p_71518_1_)
    {
        return "commands.gmc.usage";
    }

    @Override
    public void processCommand(ICommandSender p_71515_1_, String[] p_71515_2_) {
        WorldSettings.GameType gameType = WorldSettings.GameType.CREATIVE;
        EntityPlayerMP entityPlayerMP = getCommandSenderAsPlayer(p_71515_1_);
        ChatComponentTranslation chatcomponenttranslation = new ChatComponentTranslation("gameMode." + gameType.getName(), new Object[0]);
        entityPlayerMP.setGameType(gameType);
        func_152374_a(p_71515_1_, this, 1, "commands.gamemode.success.self", new Object[] {chatcomponenttranslation});
    }
}
