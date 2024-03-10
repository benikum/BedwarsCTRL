package de.benikum.bedwarsctrl.world;

import de.benikum.bedwarsctrl.Main;
import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.io.File;

public class JoinWorldCommand implements CommandExecutor {
    Main mainInstance;
    
    public JoinWorldCommand(Main mainInstance) {
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
        player.sendMessage("§9You get teleportet automatically");
        
        String worldName = args[0];
        
        World world = Bukkit.getWorld(worldName);
        
        if (world == null) {
            player.sendMessage("§cWorld not found");
            return true;
        }
        player.sendMessage("§7You are now in " + worldName);
        player.teleport(world.getSpawnLocation());
        return true;
    }
}