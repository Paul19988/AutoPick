package uk.co.paulcodes.autopick;

import org.bukkit.plugin.java.JavaPlugin;

/**
 * Created by paulb on 23/04/2018.
 */
public class Core extends JavaPlugin {

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(new MiningListener(), this);
    }

    @Override
    public void onDisable() {

    }
}
