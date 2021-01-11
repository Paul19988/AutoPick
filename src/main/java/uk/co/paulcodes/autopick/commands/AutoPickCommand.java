package uk.co.paulcodes.autopick.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import uk.co.paulcodes.autopick.AutoPick;
import uk.co.paulcodes.autopick.utils.Variables;

public class AutoPickCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(cmd.getName().equalsIgnoreCase("autopick")) {
            if(sender.hasPermission("autopick.reload")) {
                if(args.length == 0) {
                    sender.sendMessage(Variables.PREFIX() + ChatColor.YELLOW + "Not enough args. /autopick reload");
                } else if(args.length == 1) {
                    if(args[0].equalsIgnoreCase("reload")) {
                        AutoPick.getDataHolder().reload();
                        sender.sendMessage(Variables.RELOAD());
                    }
                }
            }else{
                sender.sendMessage(Variables.NO_PERMISSION("autopick.reload"));
            }
        }
        return false;
    }
}
