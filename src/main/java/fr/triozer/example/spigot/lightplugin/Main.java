package fr.triozer.example.spigot.lightplugin;

import fr.triozer.example.spigot.lightplugin.command.LightPluginCommand;
import fr.triozer.example.spigot.lightplugin.listener.*;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @author Triozer.
 */
public class Main extends JavaPlugin {
    private static Main                   instance;
    private        Map<UUID, LightPlayer> lightPlayers;
    
    public static Main getInstance() {
        return instance;
    }
    
    @Override
    public void onEnable() {
        instance = this;
        lightPlayers = new HashMap<>();
        
        registerListeners();
        registerCommands();
    }
    
    private void registerCommands() {
        new LightPluginCommand().register(this);
    }
    
    private void registerListeners() {
        Bukkit.getPluginManager().registerEvents(new BlockBreak(), this);
        Bukkit.getPluginManager().registerEvents(new BlockPlace(), this);
        Bukkit.getPluginManager().registerEvents(new EntityDeath(), this);
        Bukkit.getPluginManager().registerEvents(new PlayerChat(), this);
        Bukkit.getPluginManager().registerEvents(new PlayerDeath(), this);
        Bukkit.getPluginManager().registerEvents(new PlayerJoin(), this);
        Bukkit.getPluginManager().registerEvents(new PlayerQuit(), this);
    }
    
    public void add(UUID uuid, LightPlayer lightPlayer) {
        lightPlayers.put(uuid, lightPlayer);
    }
    
    public void remove(UUID uuid) {
        lightPlayers.remove(uuid);
    }
    
    public LightPlayer getLightplayer(UUID uuid) {
        return lightPlayers.get(uuid);
    }
}