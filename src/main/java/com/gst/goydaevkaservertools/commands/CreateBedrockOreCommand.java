package com.gst.goydaevkaservertools.commands;

import com.gst.goydaevkaservertools.ntm.BedrockOreOperator;
import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.command.WrongUsageException;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;

public class CreateBedrockOreCommand extends CommandBase {
    @Override
    public String getCommandName() {
        return "gtgo";
    }

    @Override
    public String getCommandUsage(ICommandSender sender) {
        return "gtgo LM HM RE ACT NM CR";
    }

    @Override
    public void processCommand(ICommandSender sender, String[] args) {
        if (args.length < 6)
        {
            throw new WrongUsageException("commands.gtgo.usage", new Object[0]);
        }
        EntityPlayerMP entityplayermp = getCommandSenderAsPlayer(sender);
        ItemStack bedrockOre = BedrockOreOperator.CreateBedrockOreWithLevels(1,
            Float.parseFloat(args[0]),Float.parseFloat(args[1]),Float.parseFloat(args[2]),Float.parseFloat(args[3]),Float.parseFloat(args[4]),Float.parseFloat(args[5]));

        EntityItem entityitem = entityplayermp.dropPlayerItemWithRandomChoice(bedrockOre, false);
        entityitem.delayBeforeCanPickup = 0;
    }
}
