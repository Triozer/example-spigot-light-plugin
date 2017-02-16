package fr.triozer.example.spigot.lightplugin.command;

import fr.triozer.api.command.AbstractCommand;
import fr.triozer.example.spigot.lightplugin.Main;
import org.bukkit.Bukkit;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Triozer.
 */
public class LightPluginCommand extends AbstractCommand {
    public LightPluginCommand() {
        super("lightplugin", "use.lightplugin", false, 0);
    }
    
    @Override
    protected void execute(Player player, String[] args) {
        if (args.length == 0) {
            Main.getInstance().getLightplayer(player.getUniqueId()).sendInfo(player, player);
        } else if (args.length == 1) {
            Player target = Bukkit.getPlayerExact(args[0]);
            Main.getInstance().getLightplayer(target.getUniqueId()).sendInfo(player, target);
        }
    }
    
    @Override
    public void displayHelp(Player player) {
        
    }
    
    @Override
    protected List<String> tabCompleter(Player player, String[] args) {
        List<String> list = new ArrayList<>();
        Bukkit.getOnlinePlayers().forEach(HumanEntity::getName);
        return list;
    }
}
