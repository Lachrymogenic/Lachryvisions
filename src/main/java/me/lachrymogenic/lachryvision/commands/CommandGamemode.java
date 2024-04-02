package me.lachrymogenic.lachryvision.commands;

import me.lachrymogenic.lachryvision.Constants;
import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.world.World;
import net.minecraft.world.WorldSettings;

public class CommandGamemode extends CommandBase {
    WorldSettings.GameType gameType;
    public CommandGamemode(WorldSettings.GameType gameType) {
        this.gameType = gameType;
    }
    @Override
    public String getCommandName() {

        switch(gameType) {
            case CREATIVE:
                return "gmc";
            case SURVIVAL:
                return "gms";
            case ADVENTURE:
                return "gma";
        };

        return null;
    }

    public int getRequiredPermissionLevel()
    {
        return 2;
    }

    @Override
    public String getCommandUsage(ICommandSender sender) {
        return "commands." + getCommandName() + ".usage";
    }

    @Override
    public void processCommand(ICommandSender sender, String[] args) {
        EntityPlayerMP entityPlayerMP = args.length >= 1 ? getPlayer(sender, args[0]) : getCommandSenderAsPlayer(sender);
        ChatComponentTranslation chatcomponenttranslation = new ChatComponentTranslation("gameMode." + gameType.getName(), new Object[0]);
        entityPlayerMP.setGameType(gameType);
        entityPlayerMP.fallDistance = 0.0F;
        func_152374_a(sender, this, 1, "commands.gamemode.success.self", new Object[] {chatcomponenttranslation});
    }
}
