package uk.co.paulcodes.autopick;

import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;

/**
 * Created by paulb on 23/04/2018.
 */
public class MiningListener implements Listener {

    @EventHandler
    private void onBlockBreak(BlockBreakEvent e) {
        Player p = e.getPlayer();
        if (p.hasPermission("autopickup.*")) {
            if (p.getGameMode() == GameMode.SURVIVAL) {
                for (ItemStack items : e.getBlock().getDrops()) {
                    if (p.getInventory().firstEmpty() == -1) {
                        e.getBlock().getLocation().getWorld().dropItem(e.getBlock().getLocation(), items);
                    } else {
                        p.getInventory().addItem(items);
                    }
                }
                p.giveExp(e.getExpToDrop());
                e.setCancelled(true);
                e.setExpToDrop(0);
                e.getBlock().setType(Material.AIR);
            }
        }else{
            p.sendMessage(ChatColor.RED + "");
        }
    }

}
