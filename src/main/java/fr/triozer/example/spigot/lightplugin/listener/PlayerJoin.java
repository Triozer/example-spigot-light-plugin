package fr.triozer.example.spigot.lightplugin.listener;

import fr.triozer.example.spigot.lightplugin.LightPlayer;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

/**
 * @author Triozer.
 */
public class PlayerJoin implements Listener {
    
    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        new LightPlayer(event.getPlayer().getUniqueId());
    }
    
}