package com.gigavoid.supermod.chat;

import com.gigavoid.supermod.entity.EntityRope;
import net.minecraft.command.ICommand;
import net.minecraft.command.ICommandSender;
import net.minecraft.command.WrongUsageException;

import java.util.List;

/**
 * Created by ineentho on 2014-11-06.
 */
public class SpawnLineCommand implements ICommand {
    @Override
    public String getCommandName() {
        return "spawnline";
    }

    @Override
    public String getCommandUsage(ICommandSender p_71518_1_) {
        return "/spawnline x1 y1 z1 x2 y2 z2";
    }

    @Override
    public List getCommandAliases() {
        return null;
    }

    @Override
    public void processCommand(ICommandSender sender, String[] args) {
        double x1, y1, z1, x2, y2, z2;
        try {
            x1 = Double.parseDouble(args[0]);
            y1 = Double.parseDouble(args[1]);
            z1 = Double.parseDouble(args[2]);
            x2 = Double.parseDouble(args[3]);
            y2 = Double.parseDouble(args[4]);
            z2 = Double.parseDouble(args[5]);
        }
        catch(Exception e) {
            throw new WrongUsageException(getCommandUsage(sender), new Object[0]);
        }

        EntityRope newRope = new EntityRope(sender.getEntityWorld(), x1, y1, z1, x2, y2, z2);
        sender.getEntityWorld().spawnEntityInWorld(newRope);
    }

    @Override
    public boolean canCommandSenderUseCommand(ICommandSender p_71519_1_) {
        return true;
    }

    @Override
    public List addTabCompletionOptions(ICommandSender p_71516_1_, String[] p_71516_2_) {
        return null;
    }

    @Override
    public boolean isUsernameIndex(String[] p_82358_1_, int p_82358_2_) {
        return false;
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }
}
