package de.benikum.bedwarsctrl;

import de.benikum.bedwarsctrl.shop.OpenShopCommand;
import de.benikum.bedwarsctrl.shop.ShopManager;
import de.benikum.bedwarsctrl.world.*;
import org.bukkit.Bukkit;
import org.bukkit.WorldCreator;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.List;

public class Main extends JavaPlugin {
    private ShopManager shopManager = new ShopManager();
    
    @Override
    public void onEnable() {
        saveDefaultConfig();
        
        // load all custom worlds
        List<String> worldNames = getStringList("worlds");
        for (String w : worldNames) {
            WorldCreator worldCreator = new WorldCreator(w);
            Bukkit.createWorld(worldCreator);
        }
        
        // set commands
        getCommand("createworld").setExecutor(new CreateWorldCommand(this));
        
        getCommand("importworld").setExecutor(new ImportWorldCommand(this));
        
        getCommand("removeworld").setExecutor(new RemoveWorldCommand(this));
        getCommand("removeworld").setTabCompleter(new ActiveWorldsTabCompleter(this));
        
        getCommand("joinworld").setExecutor(new JoinWorldCommand(this));
        getCommand("joinworld").setTabCompleter(new ActiveWorldsTabCompleter(this));
        
        getCommand("openshop").setExecutor(new OpenShopCommand(shopManager));
        
        // register events
        getServer().getPluginManager().registerEvents(new ShopManager(), this);
    }
    
    public void addToConfig(String path, String value) {
        FileConfiguration config = getConfig();
        if (!config.isList(path)) {
            config.set(path, new ArrayList<>());
        }
        List<String> list = config.getStringList(path);
        list.add(value);
        config.set(path, list);
        saveConfig();
    }
    public void removeFromConfig(String path, String value) {
        FileConfiguration config = getConfig();
        if (!config.isList(path)) {
            return;
        }
        List<String> list = config.getStringList(path);
        list.remove(value);
        config.set(path, list);
        saveConfig();
    }
    public List<String> getStringList(String path) {
        FileConfiguration config = getConfig();
        if (config.isList(path)) {
            return config.getStringList(path);
        }
        return new ArrayList<>();
    }
}