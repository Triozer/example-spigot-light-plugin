package fr.triozer.example.spigot.lightplugin.listener;

import fr.triozer.example.spigot.lightplugin.Main;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

/**
 * @author Triozer.
 */
public class BlockBreak implements Listener {
    
    @EventHandler
    public void onBlockBreack(BlockBreakEvent event) {
        Main.getInstance().getLightPlayer(event.getPlayer().getUniqueId()).breakBlock();
    }
    
}
