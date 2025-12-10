package com.tu.paquete.skywars;

import com.tu.paquete.Main;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.*;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * Scoreboard específico de SkyWars
 */
public class SkyScoreboard {

    private final Main plugin;
    private final Map<UUID, Scoreboard> activeScoreboards;

    public SkyScoreboard(Main plugin) {
        this.plugin = plugin;
        this.activeScoreboards = new HashMap<>();
    }

    public void createScoreboard(Player player) {
        ScoreboardManager manager = Bukkit.getScoreboardManager();
        if (manager == null) return;

        Scoreboard board = manager.getNewScoreboard();
        Objective obj = board.registerNewObjective("swGame", "dummy", "%sw_scoreboard_title%");
        obj.setDisplaySlot(DisplaySlot.SIDEBAR);

        Score line1 = obj.getScore(" ");
        line1.setScore(3);
        Score line2 = obj.getScore("Jugadores: 0");
        line2.setScore(2);
        Score line3 = obj.getScore("Equipos activos: 0");
        line3.setScore(1);

        player.setScoreboard(board);
        activeScoreboards.put(player.getUniqueId(), board);
    }

    public void updateScoreboard(Player player, int playersRestantes, int equiposActivos) {
        Scoreboard board = activeScoreboards.get(player.getUniqueId());
        if (board == null) return;

        Objective obj = board.getObjective("swGame");
        if (obj == null) return;

        obj.getScore("Jugadores: 0").setScore(playersRestantes);
        obj.getScore("Equipos activos: 0").setScore(equiposActivos);
    }

    public void removeScoreboard(Player player) {
        player.setScoreboard(Bukkit.getScoreboardManager().getNewScoreboard());
        activeScoreboards.remove(player.getUniqueId());
    }
}
