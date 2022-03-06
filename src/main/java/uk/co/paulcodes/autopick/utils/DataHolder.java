package uk.co.paulcodes.autopick.utils;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import uk.co.paulcodes.autopick.AutoPick;

import java.util.logging.Level;

public class DataHolder {

    private AutoPick autoPick;

    public DataHolder(AutoPick autoPick) {
        this.autoPick = autoPick;

        populateMessages();
        if(!autoPick.getConfig().isBoolean("dropFull")) {
            autoPick.getConfig().set("dropFull", true);
            autoPick.saveConfig();
        }
    }

    public String loadMessage(String messageType) {
        if(messageType.equalsIgnoreCase("no_permission")) {
            if(autoPick.getConfig().isString(messageType)) {
                return autoPick.getConfig().getString(messageType);
            }else{
                String msg = "&cYou do not have permission for this command. ({permission})";
                autoPick.getConfig().set(messageType, msg);
                autoPick.saveConfig();
                return msg;
            }
        }else if(messageType.equalsIgnoreCase("prefix")) {
            if(autoPick.getConfig().isString(messageType)) {
                return autoPick.getConfig().getString(messageType);
            }else{
                String msg = "&c&lAutoPick &8&l> &a";
                autoPick.getConfig().set(messageType, msg);
                autoPick.saveConfig();
                return msg;
            }
        }else if(messageType.equalsIgnoreCase("reload_message")) {
            if(autoPick.getConfig().isString(messageType)) {
                return autoPick.getConfig().getString(messageType);
            }else{
                String msg = "&eSuccessfully reloaded configurations.";
                autoPick.getConfig().set(messageType, msg);
                autoPick.saveConfig();
                return msg;
            }
        }
        return "MESSAGE MISSING";
    }

    public void populateMessages() {
        Variables.SET_NO_PERMISSION(ChatColor.translateAlternateColorCodes('&', loadMessage("no_permission")));
        Variables.SET_PREFIX(ChatColor.translateAlternateColorCodes('&', loadMessage("prefix")));
        Variables.SET_RELOAD(ChatColor.translateAlternateColorCodes('&', loadMessage("reload_message")));
    }

    public boolean reload() {
        Bukkit.getLogger().log(Level.INFO, "Reloading..");
        autoPick.reloadConfig();
        Bukkit.getLogger().log(Level.INFO, "Successfully reloaded.");
        return true;
    }

}
