package de.benikum.bedwarsctrl.team;

import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;

import java.util.Set;

public class TeamController {
    private String teamName;
    private ItemStack teamLogo;
    private Set<Player> teamMembers;
    
    public TeamController(String teamName) {
        this.teamName = teamName;
    }
    
    public String getTeamName() {
        return teamName;
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
    public void addMember(Player player) {
        if (teamMembers.isEmpty()) {
            setTeamLogo(player);
        }
        teamMembers.add(player);
    }
    public void removeMember(Player player) {
        teamMembers.remove(player);
    }
}
