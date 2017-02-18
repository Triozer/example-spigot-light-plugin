package fr.triozer.example.spigot.lightplugin;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.text.SimpleDateFormat;
import java.util.UUID;

/**
 * @author Triozer.
 */
public class LightPlayer {
    private Player player;
    
    private long connection;
    
    private int breakedBlocks;
    private int placedBlocks;
    
    private int killedMobs;
    private int killedPlayers;
    private int deaths;
    
    private int words;
    
    public LightPlayer(UUID uuid) {
        this.player = Bukkit.getPlayer(uuid);
        Main.getInstance().add(uuid, this);
        
        connection = System.currentTimeMillis();
    }
    
    public void sendInfo(Player player, Player target) {
        player.sendMessage("");
        player.sendMessage("§b[LightPlayer] §rInformations sur §6§l" + target.getName());
        player.sendMessage("");
        
        long time = System.currentTimeMillis() - connection;
        
        SimpleDateFormat dateFormat = new SimpleDateFormat("mm:ss");
        
        if (time > 60)
            dateFormat = new SimpleDateFormat("mm:ss");
        else if (time > 3600000)
            dateFormat = new SimpleDateFormat("hh:mm:ss");
        
        player.sendMessage("Données reccueillies du joueur depuis: §a" + dateFormat.format(time));
        player.sendMessage("");
        player.sendMessage("Vie du joueur: §c" + target.getHealth());
        player.sendMessage("Niveau de nourriture du joueur: §6" + target.getFoodLevel());
        player.sendMessage("Blocs cassés: §a" + breakedBlocks);
        player.sendMessage("Blocs placés: §a" + placedBlocks);
        
        if (killedMobs + killedPlayers > 1)
            player.sendMessage("Entités tuées: §e" + (killedMobs + killedPlayers) + " §7(" + killedMobs + " entités et " + killedPlayers + " joueurs)");
        else
            player.sendMessage("Entité tuée: §e" + (killedMobs + killedPlayers) + " §7(" + killedMobs + " entité et " + killedPlayers + " joueur)");
        
        player.sendMessage("Morts: §e" + deaths);
        player.sendMessage("Mots envoyés: §e" + words);
        player.sendMessage("");
    }
    
    public void breakBlock() {
        this.breakedBlocks++;
    }
    
    public void placeBlock() {
        this.placedBlocks++;
    }
    
    public void killMob() {
        this.killedMobs++;
    }
    
    public void killPlayer() {
        this.killedPlayers++;
    }
    
    public void addDeath() {
        this.deaths++;
    }
    
    public void addWord() {
        this.words++;
    }
    
    public Player getPlayer() {
        return player;
    }
}
