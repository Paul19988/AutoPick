package uk.co.paulcodes.autopick;

import org.bukkit.plugin.java.JavaPlugin;
import uk.co.paulcodes.autopick.commands.AutoPickCommand;
import uk.co.paulcodes.autopick.listeners.MiningListener;
import uk.co.paulcodes.autopick.tabcompleter.AutoPickCompleter;
import uk.co.paulcodes.autopick.utils.DataHolder;

public class AutoPick extends JavaPlugin {

    private static DataHolder dataHolder;

    @Override
    public void onEnable() {
        dataHolder = new DataHolder(this);

        getServer().getPluginManager().registerEvents(new MiningListener(), this);

        getServer().getPluginCommand("autopick").setExecutor(new AutoPickCommand());
        getServer().getPluginCommand("autopick").setTabCompleter(new AutoPickCompleter());
    }

    @Override
    public void onDisable() {
        dataHolder = null;
    }

    public static DataHolder getDataHolder() {
        return dataHolder;
    }
}
