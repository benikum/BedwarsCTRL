package de.benikum.bedwarsctrl.shop;

import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.List;

public class ShopPage {
    private List<ListingItem> listings;
    private ItemStack pageIcon;

    public ShopPage(ItemStack pageIcon) {
        this.listings = new ArrayList<>();
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

    public Inventory getShopPage(Inventory shopPage) {
        int dragger = 0;
        for (int i = 0; i < listings.size(); i++) {
            while ((i + dragger) % 9 < 2) {
                dragger++;
            }
            shopPage.setItem((i + dragger), listings.get(i).getListingIcon());
        }
        return shopPage;
    }
}
