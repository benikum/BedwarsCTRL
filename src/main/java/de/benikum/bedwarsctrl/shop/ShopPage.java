package de.benikum.bedwarsctrl.shop;

import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.List;

public class ShopPage {
    private List<ListingItem> listings = new ArrayList<>();
    private ItemStack pageIcon;

    public ShopPage(ItemStack pageIcon) {
        this.pageIcon = pageIcon;
    }

    public boolean addListing(ListingItem item) {
        if (listings.size() < 35) {
            listings.add(item);
            return true;
        }
        return false;
    }
    public void removeListing(ListingItem item) {
        listings.remove(item);
    }
    public List<ListingItem> getListings() {
        return listings;
    }

    public ItemStack getPageIcon() {
        return pageIcon;
    }

    public Inventory fillShopTemplate(Inventory shopPage) {
        int dragger = 0;
        for (int i = 0; i < listings.size(); i++) {
            int column = i % 9;
            while (column + dragger < 2) {
                dragger++;
            }
            shopPage.setItem((i + dragger), listings.get(i).getListingIcon());
        }
        return shopPage;
    }
}
