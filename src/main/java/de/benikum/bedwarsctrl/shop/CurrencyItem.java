package de.benikum.bedwarsctrl.shop;

import net.kyori.adventure.text.Component;
import org.bukkit.Material;

public class CurrencyItem {
    private final Material type;
    private final String name;
    
    public CurrencyItem(Material type, String name) {
        this.type = type;
        this.name = name;
    }

    public Material getType() {
        return type;
    }
    public Component getLore(int price) {
        return Component.text(price + "x " + name);
    }
}
