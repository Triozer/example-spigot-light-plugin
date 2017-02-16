package fr.triozer.example.spigot.lightplugin.listener;

import fr.triozer.example.spigot.lightplugin.Main;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

/**
 * @author Triozer.
 */
public class PlayerQuit implements Listener {
    
    @EventHandler
    public void onQuit(PlayerQuitEvent event) {
        Main.getInstance().remove(event.getPlayer().getUniqueId());
    }
    
}
