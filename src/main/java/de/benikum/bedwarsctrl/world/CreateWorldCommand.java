package de.benikum.bedwarsctrl.world;

import de.benikum.bedwarsctrl.Main;
import net.kyori.adventure.text.Component;
import org.bukkit.*;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class CreateWorldCommand implements CommandExecutor {
    Main mainInstance;
    
    public CreateWorldCommand(Main mainInstance) {
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
        Bukkit.broadcast(Component.text("§c§lSERVER MAY LAG WHILE GENERATING NEW WORLD"));
        player.sendMessage("§9You get teleportet automatically");
        
        String worldName = args[0];
        
        WorldCreator worldCreator = new WorldCreator(worldName);
        worldCreator.generator(new EmptyChunkGenerator());
        World newWorld = Bukkit.createWorld(worldCreator);
        assert newWorld != null;
        
        mainInstance.addToConfig("worlds", worldName);
        Bukkit.reload();
        
        newWorld.setType(0, 0, 0, Material.BEDROCK);
        newWorld.setType(0, 62, 0, Material.GRASS_BLOCK);
        newWorld.setType(0, 99, 0, Material.GLASS);
        newWorld.setSpawnLocation(new Location(newWorld, 0, 100, 0));
        
        player.teleport(newWorld.getSpawnLocation());
        Bukkit.broadcast(Component.text("§a§lGENERATING NEW WORLD DONE"));
        return true;
    }
}