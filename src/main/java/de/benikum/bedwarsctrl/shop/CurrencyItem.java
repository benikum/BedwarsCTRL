package de.benikum.bedwarsctrl.shop;

import net.kyori.adventure.text.Component;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Item;

public class CurrencyItem {
    Material type;
    Component name;
    Item item;
    public CurrencyItem(Material type, Component name) {
        this.type = type;
        this.name = name;
    }
}
