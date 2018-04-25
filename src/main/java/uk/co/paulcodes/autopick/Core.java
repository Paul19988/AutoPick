package uk.co.paulcodes.autopick;

import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * Created by paulb on 23/04/2018.
 */
public class Core extends JavaPlugin {

    public static String prefix;
    public static String nopermission;

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(new MiningListener(), this);
        if(getConfig().getString("prefix") != null) {
            prefix = ChatColor.translateAlternateColorCodes('&', getConfig().getString("prefix"));
            nopermission = ChatColor.translateAlternateColorCodes('&', getConfig().getString("nopermission"));
        }else{
            getConfig().set("prefix", "&aAutoPick &8>");
            getConfig().set("nopermission", "&cSorry but you do not have the correct permission for this.");
            saveConfig();
            reloadConfig();
        }
    }

    @Override
    public void onDisable() {

    }
}
