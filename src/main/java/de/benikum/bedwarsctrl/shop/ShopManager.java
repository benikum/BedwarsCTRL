package de.benikum.bedwarsctrl.shop;

import net.kyori.adventure.text.Component;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class ShopManager implements Listener {
    private Inventory shopGUI;

    public ShopManager() {
        createGUI();
    }

    private void createGUI() {
        shopGUI = Bukkit.createInventory(null, 5*9, Component.text("Shop"));
        
        ItemStack decoGlass = new ItemStack(Material.ORANGE_STAINED_GLASS_PANE);
        ItemMeta glassMeta = decoGlass.getItemMeta();
        
        glassMeta.displayName(Component.text(" "));
        
        List<Component> decoLore = new ArrayList<>();
        decoLore.add(Component.text("§6Zeile 1"));
        decoLore.add(Component.text("§9Zeile 2"));
        glassMeta.lore(decoLore);
        
        decoGlass.setItemMeta(glassMeta);

        for (int i = 9; i<18; i++) {
            shopGUI.setItem(i,decoGlass);
        }

        shopGUI.setItem(0, new ItemStack(Material.DIAMOND_SWORD, 63));
        shopGUI.setItem(4, new ItemStack(Material.APPLE, 5));
        shopGUI.setItem(8, new ItemStack(Material.BOW, 1));
    }
    public void openShopGUI(Player player) {
        player.openInventory(shopGUI);
    }

    @EventHandler
    public void onShopClick(InventoryClickEvent event) {
        Player player = (Player) event.getWhoClicked();
        if (event.getView().title().equals(Component.text("Shop"))) {
            if (event.getCurrentItem() == null) return;
            event.setCancelled(true);
            player.sendMessage(event.getCurrentItem().getType().name());
        }
    }
}
