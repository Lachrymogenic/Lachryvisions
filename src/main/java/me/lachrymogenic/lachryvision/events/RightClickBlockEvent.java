package me.lachrymogenic.lachryvision.events;

import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.ObfuscationReflectionHelper;
import cpw.mods.fml.common.eventhandler.EventPriority;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.network.handshake.NetworkDispatcher;
import cpw.mods.fml.relauncher.ReflectionHelper;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import me.lachrymogenic.lachryvision.Config;
import me.lachrymogenic.lachryvision.Constants;
import net.minecraft.block.Block;
import net.minecraft.block.BlockSign;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiEditSign;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetHandlerPlayServer;
import net.minecraft.server.MinecraftServer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntitySign;
import net.minecraft.util.Vec3;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;

import java.lang.reflect.Field;
import java.util.Arrays;

import static net.minecraft.item.Item.ToolMaterial.GOLD;

public class RightClickBlockEvent {
    public boolean test = true;
    

    @SubscribeEvent(priority = EventPriority.LOWEST)
    public void onRightClickBlock(PlayerInteractEvent event) {
        /** Singleplayer for now, for multiplayer, I'd have to set up permissions and stuff.
         * It took me a long time just to get this to work, but I got it in the end. **/

            if (MinecraftServer.getServer().isSinglePlayer()) {
                EntityPlayer player = MinecraftServer.getServer().getEntityWorld().getPlayerEntityByName(event.entityPlayer.getDisplayName());;
                //EntityPlayer player = event.entityPlayer.worldObj.getPlayerEntityByName(event.entityPlayer.getDisplayName());
                //Constants.LOGGER.info("Player: " + event.entityPlayer.worldObj.getPlayerEntityByName(event.entityPlayer.getDisplayName()));
                //Constants.LOGGER.info("Player: " + player);
                TileEntity entity = event.world.getTileEntity(event.x, event.y, event.z);
                boolean check = true;
                if (player instanceof EntityPlayerMP) {
                    if (player.getCurrentEquippedItem() != null) {
                        if (player.getCurrentEquippedItem().getItem() == Items.sign ||
                                player.getCurrentEquippedItem().getItem() == Items.bow) {
                            check = false;
                        }
                    }

                    if (player.onGround && !player.isSneaking() && check) {
                        if (entity instanceof TileEntitySign && Config.BetterSignEditing) {
                            ObfuscationReflectionHelper.setPrivateValue(TileEntitySign.class, (TileEntitySign) entity, player, "field_145917_k");
                            ObfuscationReflectionHelper.setPrivateValue(TileEntitySign.class, (TileEntitySign) entity, true, "field_145916_j");
                            FMLClientHandler.instance().displayGuiScreen(event.entityPlayer,new GuiEditSign((TileEntitySign) entity));
                        }
                    }
                }
            }
    }
}

