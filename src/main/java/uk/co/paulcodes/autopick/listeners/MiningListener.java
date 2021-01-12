package uk.co.paulcodes.autopick.listeners;

import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;

public class MiningListener implements Listener {

    @EventHandler
    private void onBlockBreak(BlockBreakEvent e) {
        Player p = e.getPlayer();
        if(p.getGameMode() == GameMode.SURVIVAL) {
            if(p.hasPermission("autopickup.item.*") || p.hasPermission("autopickup.item." + e.getBlock().getType().toString().toUpperCase())) {
                for(ItemStack items : e.getBlock().getDrops()) {
                    if(p.getInventory().firstEmpty() == -1) {
                        e.getBlock().getLocation().getWorld().dropItem(e.getBlock().getLocation(), items);
                    } else {
                        p.getInventory().addItem(items);
                    }
                }
                e.setCancelled(true);
                if(p.hasPermission("autopickup.xp")) {
                    e.setExpToDrop(0);
                    p.giveExp(e.getExpToDrop());
                }
                e.getBlock().setType(Material.AIR, true);
            }
        }
    }

}
