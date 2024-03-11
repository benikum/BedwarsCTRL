package de.benikum.bedwarsctrl.shop;

import net.kyori.adventure.text.Component;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class ListingItem {
    private Material type;
    private int amount;
    private CurrencyItem currency;
    private int price;
    
    public ListingItem(Material type, int amount, CurrencyItem currency, int price) {
        this.type = type;
        this.amount = amount;
        this.currency = currency;
        this.price = price;
        updateListingIcon();
    }
    
    private void updateListingIcon() {
    }
    
    public CurrencyItem getCurrencyItem() {
        return currency;
    }
    public Material getType() {
        return type;
    }
    public ItemStack getListingIcon() {
        ItemStack listingIcon = new ItemStack(type);
        ItemMeta iconMeta = listingIcon.getItemMeta();

        List<Component> iconLore = new ArrayList<>();
        iconLore.add(currency.getLore(price));
        iconMeta.lore(iconLore);

        listingIcon.setItemMeta(iconMeta);
        listingIcon.setAmount(amount);
        return listingIcon;
    }
    public boolean buyListing(Player player) {
        Inventory inventory = player.getInventory();
        if (!inventory.contains(currency.getType(), price)) return false;
        inventory.remove(new ItemStack(currency.getType(), price));
        inventory.addItem(new ItemStack(type, amount));
        return true;
    }
}
