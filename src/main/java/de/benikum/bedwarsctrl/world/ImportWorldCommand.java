package de.benikum.bedwarsctrl.world;

import de.benikum.bedwarsctrl.Main;
import net.kyori.adventure.text.Component;
import org.bukkit.*;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.io.File;

public class ImportWorldCommand implements CommandExecutor {
    Main mainInstance;
    
    public ImportWorldCommand(Main mainInstance) {
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
        Bukkit.broadcast(Component.text("§c§lSERVER MAY LAG WHILE IMPORTING NEW WORLD"));
        player.sendMessage("§9You get teleportet automatically");
        
        String worldName = args[0];
        File worldFolder = new File(Bukkit.getWorldContainer(), worldName);
        if (!worldFolder.exists() || !worldFolder.isDirectory()) {
            sender.sendMessage("§cDer angegebene Weltenordner existiert nicht!");
            return true;
        }
        
        WorldCreator worldCreator = new WorldCreator(worldName);
        World newWorld = Bukkit.createWorld(worldCreator);
        assert newWorld != null;
        
        mainInstance.addToConfig("worlds", worldName);
        Bukkit.reload();
        
        player.teleport(newWorld.getSpawnLocation());
        Bukkit.broadcast(Component.text("§a§lGENERATING NEW WORLD DONE"));
        return true;
    }
}