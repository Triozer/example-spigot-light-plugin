package fr.triozer.example.spigot.lightplugin.listener;

import fr.triozer.example.spigot.lightplugin.Main;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

/**
 * @author Triozer.
 */
public class PlayerChat implements Listener {
    
    @EventHandler
    public void onPlayerChat(AsyncPlayerChatEvent event) {
        for (int i = 0; i < event.getMessage().split(" ").length; i++)
            Main.getInstance().getLightPlayer(event.getPlayer().getUniqueId()).addWord();
    }
    
}
