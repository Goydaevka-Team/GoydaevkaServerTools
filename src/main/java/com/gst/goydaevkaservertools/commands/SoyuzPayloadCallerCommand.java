package com.gst.goydaevkaservertools.commands;

import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.command.WrongUsageException;
import net.minecraft.entity.player.EntityPlayerMP;

import com.gst.goydaevkaservertools.CORE;

import cpw.mods.fml.common.network.internal.FMLNetworkHandler;

public class SoyuzPayloadCallerCommand extends CommandBase {

    @Override
    public String getCommandName() {
        return "csp";
    }

    @Override
    public String getCommandUsage(ICommandSender sender) {
        return "csp X Y Z";
    }

    @Override
    public void processCommand(ICommandSender sender, String[] args) {
        if (args.length < 3) {
            throw new WrongUsageException("commands.gtgo.usage", new Object[0]);
        }

        EntityPlayerMP entityplayermp = getCommandSenderAsPlayer(sender);

        int x = (int) func_110666_a(sender, entityplayermp.posX, args[0]);
        int y = (int) func_110666_a(sender, entityplayermp.posY, args[1]);
        int z = (int) func_110666_a(sender, entityplayermp.posZ, args[2]);

        FMLNetworkHandler.openGui(entityplayermp, CORE.instance, 0, sender.getEntityWorld(), x, y, z);
    }

    @Override

    public int getRequiredPermissionLevel() {
        return 2;
    }
}
