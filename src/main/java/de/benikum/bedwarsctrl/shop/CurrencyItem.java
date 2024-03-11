package de.benikum.bedwarsctrl.shop;

import net.kyori.adventure.text.Component;
import org.bukkit.Material;

public class CurrencyItem {
    private final Material type;
    private final Component name;

    public CurrencyItem(Material type, Component name) {
        this.type = type;
        this.name = name;
    }

    public Component getLore(int price) {
        return Component.text(price + "x ").append(name);
    }
}
