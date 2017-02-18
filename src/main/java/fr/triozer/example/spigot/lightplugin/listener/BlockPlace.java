package fr.triozer.example.spigot.lightplugin.listener;

import fr.triozer.example.spigot.lightplugin.Main;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

/**
 * @author Triozer.
 */
public class BlockPlace implements Listener {
    
    @EventHandler
    public void onBlockPlace(BlockPlaceEvent event) {
        Main.getInstance().getLightPlayer(event.getPlayer().getUniqueId()).placeBlock();
    }
    
}
