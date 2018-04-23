package uk.co.paulcodes.autopick;

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
        if(p.getItemInHand().getType() == Material.WOOD_PICKAXE || p.getItemInHand().getType() == Material.STONE_PICKAXE || p.getItemInHand().getType() == Material.IRON_PICKAXE || p.getItemInHand().getType() == Material.GOLD_PICKAXE || p.getItemInHand().getType() == Material.DIAMOND_PICKAXE) {
            for (ItemStack items : e.getBlock().getDrops()) {
                p.getInventory().addItem(items);
            }
            p.setExp(e.getExpToDrop());
            e.setCancelled(true);
            e.setExpToDrop(0);
            e.getBlock().setType(Material.AIR);
        }
    }

}
