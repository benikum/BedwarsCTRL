package de.benikum.bedwarsctrl.world;

import de.benikum.bedwarsctrl.Main;
import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public class ActiveWorldsTabCompleter implements TabCompleter {
    Main mainInstance;
    
    public ActiveWorldsTabCompleter(Main mainInstance) {
        this.mainInstance = mainInstance;
    }
    
    @Override
    public @Nullable List<String> onTabComplete(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] args) {
        if (args.length == 0) {
            List<String> activeWorlds = new ArrayList<>();
            for (World w : Bukkit.getWorlds()) {
                activeWorlds.add(w.getName());
            }
            return activeWorlds;
        }
        return null;
    }
}
