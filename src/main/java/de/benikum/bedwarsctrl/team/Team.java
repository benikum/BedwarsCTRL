package de.benikum.bedwarsctrl.team;

import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;

import java.util.Set;

public class Team {
    private String teamName;
    private Color teamColor;
    private ItemStack teamLogo;
    private Set<Player> teamMembers;
    
    public Team(String teamName, Color teamColor) {
        this.teamName = teamName;
        this.teamColor = teamColor;
    }
    
    public String getTeamName() {
        return teamName;
    }
    public Color getTeamColor() {
        return teamColor;
    }
    public ItemStack getTeamLogo() {
        return teamLogo;
    }
    public Set<Player> getTeamMembers() {
        return teamMembers;
    }
    
    public void setTeamLogo(Player player) {
        teamLogo = new ItemStack(Material.PLAYER_HEAD);
        SkullMeta skullMeta = (SkullMeta) teamLogo.getItemMeta();
        skullMeta.setOwningPlayer(player);
        teamLogo.setItemMeta(skullMeta);
    }
    public void addTeamMember(Player player) {
        if (teamMembers.isEmpty()) {
            setTeamLogo(player);
        }
        teamMembers.add(player);
    }
    public void removeTeamMember(Player player) {
        teamMembers.remove(player);
    }
//    public int size() {
//        return teamMembers.size();
//    }
}
