package de.benikum.bedwarsctrl.shop;

import net.kyori.adventure.text.Component;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class ListingItem {
    private Material type;
    private int amount;
    private CurrencyItem currency;
    private int price;

    private ItemStack listingIcon;
    
    public ListingItem(Material type, int amount, CurrencyItem currency, int price) {
        this.type = type;
        this.amount = amount;
        this.currency = currency;
        this.price = price;
        updateListingIcon();
    }
    
    private void updateListingIcon() {
        listingIcon = new ItemStack(type);
        ItemMeta iconMeta = listingIcon.getItemMeta();
        //iconMeta.displayName(Component.text(" "));

        List<Component> iconLore = new ArrayList<>();
        iconLore.add(currency.getLore(price));
        iconMeta.lore(iconLore);

        listingIcon.setItemMeta(iconMeta);
        listingIcon.setAmount(amount);
    }
    
    public CurrencyItem getCurrencyItem() {
        return currency;
    }
    public Material getType() {
        return type;
    }
    public int getPrice() {
        return price;
    }
    public int getAmount() {
        return amount;
    }
    public ItemStack getListingIcon() {
        return listingIcon;
    }
}