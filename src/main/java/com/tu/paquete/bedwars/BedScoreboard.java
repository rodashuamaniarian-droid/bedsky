package com.tu.paquete.bedwars;

import com.tu.paquete.Main;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.*;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * Scoreboard específico de BedWars.
 */
public class BedScoreboard {

    private final Main plugin;

    // Scoreboards activos: jugador UUID -> scoreboard
    private final Map<UUID, Scoreboard> activeScoreboards;

    public BedScoreboard(Main plugin) {
        this.plugin = plugin;
        this.activeScoreboards = new HashMap<>();
    }

    /**
     * Inicializa el scoreboard de un jugador.
     *
     * @param player Jugador a quien asignar el scoreboard
     */
    public void createScoreboard(Player player) {
        ScoreboardManager manager = Bukkit.getScoreboardManager();
        if (manager == null) return;

        Scoreboard board = manager.getNewScoreboard();
        Objective objective = board.registerNewObjective("bwGame", "dummy", "%bw_scoreboard_title%");
        objective.setDisplaySlot(DisplaySlot.SIDEBAR);

        // Ejemplo de líneas iniciales
        Score line1 = objective.getScore(" ");
        line1.setScore(3);

        Score line2 = objective.getScore("Jugadores: 0");
        line2.setScore(2);

        Score line3 = objective.getScore("Equipos activos: 0");
        line3.setScore(1);

        player.setScoreboard(board);
        activeScoreboards.put(player.getUniqueId(), board);
    }

    /**
     * Actualiza el scoreboard de un jugador.
     * Aquí se pueden poner stats dinámicas como jugadores restantes, equipo, kills, etc.
     *
     * @param player Jugador
     * @param playersRestantes Número de jugadores restantes
     * @param equiposActivos Número de equipos activos
     */
    public void updateScoreboard(Player player, int playersRestantes, int equiposActivos) {
        Scoreboard board = activeScoreboards.get(player.getUniqueId());
        if (board == null) return;

        Objective objective = board.getObjective("bwGame");
        if (objective == null) return;

        // Actualizar líneas
        objective.getScore("Jugadores: 0").setScore(playersRestantes);
        objective.getScore("Equipos activos: 0").setScore(equiposActivos);
    }

    /**
     * Elimina el scoreboard de un jugador
     *
     * @param player Jugador
     */
    public void removeScoreboard(Player player) {
        player.setScoreboard(Bukkit.getScoreboardManager().getNewScoreboard());
        activeScoreboards.remove(player.getUniqueId());
    }
}
