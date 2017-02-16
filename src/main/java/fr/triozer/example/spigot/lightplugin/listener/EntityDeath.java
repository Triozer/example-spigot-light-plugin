package fr.triozer.example.spigot.lightplugin.listener;

import fr.triozer.example.spigot.lightplugin.Main;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;

/**
 * @author Triozer.
 */
public class EntityDeath implements Listener {
    
    @EventHandler
    public void onEntityDeath(EntityDeathEvent event) {
        if (!(event.getEntity() instanceof Player) && event.getEntity().getKiller() != null)
            Main.getInstance().getLightplayer(event.getEntity().getKiller().getUniqueId()).killMob();
    }
    
}
