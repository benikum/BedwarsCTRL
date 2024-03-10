package de.benikum.bedwarsctrl.shop;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;

public class BuyItemButton {
    private Material currency;
    private Material type;
    private int cost;
    private int amount;
    private ItemStack listingIcon;
    
    public BuyItemButton(Material type, int amount, Material currency, int cost) {
        this.currency = currency;
        this.type = type;
        this.cost = cost;
        this.amount = amount;
        updateListingIcon();
    }
    
    private void updateListingIcon() {
        listingIcon = new ItemStack(type);
        ItemMeta iconMeta = listingIcon.getItemMeta();
        iconMeta.setLore(Arrays.asList(cost + "x " + new ItemStack(currency).displayName()));
        listingIcon.setItemMeta(iconMeta);
        listingIcon.setAmount(amount);
    }
    
    public Material getCurrency() {
        return currency;
    }
    public Material getType() {
        return type;
    }
    public int getCost() {
        return cost;
    }
    public int getAmount() {
        return amount;
    }
    public ItemStack getListingIcon() {
        return listingIcon;
    }
}