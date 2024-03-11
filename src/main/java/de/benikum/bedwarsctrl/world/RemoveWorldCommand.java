package de.benikum.bedwarsctrl.world;

import de.benikum.bedwarsctrl.Main;
import net.kyori.adventure.text.Component;
import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.WorldCreator;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.io.File;

public class RemoveWorldCommand implements CommandExecutor {
    Main mainInstance;
    
    public RemoveWorldCommand(Main mainInstance) {
        this.mainInstance = mainInstance;
    }
    
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, String[] args) {
        if (!(sender instanceof Player)) {
            return false;
        }
        Player player = (Player) sender;
        if (args.length == 0) {
            player.sendMessage("§cError: No world name given");
            return true;
        }
        Bukkit.broadcast(Component.text("§c§lREMOVING WORLD"));
        
        String worldName = args[0];
        
        Bukkit.unloadWorld(worldName, true);
        mainInstance.removeFromConfig("worlds", worldName);
        Bukkit.reload();
        
        Bukkit.broadcast(Component.text("§a§lREMOVED " + worldName.toUpperCase()));
        Bukkit.broadcast(Component.text("§7/importworld " + worldName + " §rto add it back"));
        return true;
    }
}