package uk.co.paulcodes.autopick.tabcompleter;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;

import java.util.ArrayList;
import java.util.List;

public class AutoPickCompleter implements TabCompleter {

    private static List<String> responses = new ArrayList<>();

    @Override
    public List<String> onTabComplete(CommandSender sender, Command cmd, String label, String[] args) {
        if(cmd.getName().equalsIgnoreCase("autopick")) {
            if(sender.hasPermission("autopickup.reload")) {
                if(args[0].startsWith("r")) {
                    responses.add("reload");
                } else {
                    responses.clear();
                }
            }else{
                responses.clear();
            }
        }
        return responses;
    }
}
