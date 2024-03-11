package de.benikum.bedwarsctrl.shop;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

// TODO temporary class while I dont have villager seller

public class OpenShopCommand implements CommandExecutor {
    ShopManager shopManager;

    public OpenShopCommand(ShopManager shopManager) {
        this.shopManager = shopManager;
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command cmd, @NotNull String var3, @NotNull String[] args) {
        Player player = (Player) sender;
        shopManager.openShopGUI(player, 0);
        return true;
    }
}
