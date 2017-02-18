package fr.triozer.example.spigot.lightplugin.listener;

import fr.triozer.example.spigot.lightplugin.Main;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

/**
 * @author Triozer.
 */
public class PlayerDeath implements Listener {
    
    @EventHandler
    public void onDeathOrKill(PlayerDeathEvent event) {
        Main.getInstance().getLightPlayer(event.getEntity().getUniqueId()).addDeath();
        
        if (event.getEntity().getKiller() != null)
            Main.getInstance().getLightPlayer(event.getEntity().getKiller().getUniqueId()).killPlayer();
    }
    
}
