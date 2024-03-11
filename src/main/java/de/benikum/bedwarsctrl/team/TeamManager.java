package de.benikum.bedwarsctrl.team;

import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class TeamManager {
    private List<TeamController> teamList = new ArrayList<>();

    public void addTeam(Player player) {
        TeamController newTeam = new TeamController(player.getName());
    }
    public void removeTeam() {

    }
}
