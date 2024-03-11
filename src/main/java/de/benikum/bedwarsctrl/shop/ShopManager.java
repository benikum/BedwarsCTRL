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
    private Inventory shopInventory;
    private List<ShopPage> shopPageList;
    
    public ShopManager() {
        shopPageList = new ArrayList<>();
        // TODO implement shop config reader

        shopInventory = Bukkit.createInventory(null, 5*9, Component.text("Shop"));
        ItemStack decoGlass = new ItemStack(Material.GRAY_STAINED_GLASS_PANE);

        ItemMeta glassMeta = decoGlass.getItemMeta();
        glassMeta.displayName(Component.text("§7Page <-> Listing"));
        decoGlass.setItemMeta(glassMeta);

        for (int i = 1; i<38; i+=9) {
            shopInventory.setItem(i, decoGlass);
        }

        ShopPage shopPage0 = new ShopPage(new ItemStack(Material.OAK_PLANKS));
        ShopPage shopPage1 = new ShopPage(new ItemStack(Material.TNT));
        CurrencyItem ironCurrency = new CurrencyItem(Material.IRON_INGOT, "§fIron");
        CurrencyItem goldCurrency = new CurrencyItem(Material.GOLD_INGOT, "§6Gold");
        CurrencyItem diamondCurrency = new CurrencyItem(Material.DIAMOND, "§bDiamond");
        CurrencyItem emeraldCurrency = new CurrencyItem(Material.EMERALD, "§2Emerald");
        shopPage0.addListing(new ListingItem(Material.WHITE_WOOL, 16, ironCurrency, 4));
        shopPage0.addListing(new ListingItem(Material.BEACON, 1, goldCurrency, 5));
        shopPage0.addListing(new ListingItem(Material.STICK, 32, diamondCurrency, 12));
        shopPage1.addListing(new ListingItem(Material.DIAMOND_CHESTPLATE, 1, emeraldCurrency, 4));
        shopPage1.addListing(new ListingItem(Material.ORANGE_CONCRETE, 3, ironCurrency, 8));
        addShopPage(shopPage0);
        addShopPage(shopPage1);
    }

    public void addShopPage(ShopPage shopPage) {
        if (shopPageList.size() >= 5) return;
        shopInventory.setItem(shopPageList.size() * 9, shopPage.getPageIcon());
        shopPageList.add(shopPage);
    }
    public void openShopGUI(Player player, int page) {
        if (!shopPageList.isEmpty()) {
            player.openInventory(shopPageList.get(page).getShopPage(shopInventory));
        }
    }
    
    @EventHandler
    public void onShopClick(InventoryClickEvent event) {
        if (!event.getView().title().equals(Component.text("Shop"))) return;
        // correct inventory
        if (event.getCurrentItem() == null) return;
        // not empty slot
        event.setCancelled(true);

        Player player = (Player) event.getWhoClicked();
        int slot = event.getSlot();
        int column = slot % 9;

        if (column == 0) {
            int row = slot / 9;
            openShopGUI(player, row);
        } else if (column >= 2) {
            player.sendMessage(event.getCurrentItem().getType().name());
            //ListingItem listingItem =
        }
    }
}
