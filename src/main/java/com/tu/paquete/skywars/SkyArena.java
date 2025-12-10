package com.tu.paquete.skywars;

import com.tu.paquete.common.Arena;
import com.tu.paquete.common.GameState;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * Clase que representa una arena de SkyWars.
 */
public class SkyArena extends Arena {

    // Equipos: nombre -> jugadores (modo team o solo)
    private final Map<String, Map<UUID, Player>> teams;

    public SkyArena(String name) {
        super(name);
        this.teams = new HashMap<>();
        // Ejemplo: equipo para modo 2 jugadores o modo solo
        teams.put("TEAM1", new HashMap<>());
        teams.put("TEAM2", new HashMap<>());
    }

    // --------------------
    // Métodos abstractos de Arena
    // --------------------
    @Override
    public void setupGui() {
        // TODO: abrir GUI para configurar spawn, generadores, equipos
    }

    @Override
    public void setupCommands() {
        // TODO: setup por comandos
    }

    @Override
    public void startGame() {
        setState(GameState.INGAME);
        givePlayerItems();
    }

    @Override
    public void resetGame() {
        setState(GameState.RESETTING);
        getPlayers().clear();
    }

    // --------------------
    // Items especiales
    // --------------------
    private void givePlayerItems() {
        for (UUID uuid : getPlayers()) {
            Player player = org.bukkit.Bukkit.getPlayer(uuid);
            if (player != null) {
                // Item leave (wood red)
                ItemStack leaveItem = new ItemStack(Material.RED_WOOL);
                player.getInventory().setItem(8, leaveItem); // slot 9
                // Item para elegir equipo (lana)
                ItemStack teamItem = new ItemStack(Material.WOOL, 1);
                player.getInventory().setItem(0, teamItem);
            }
        }
    }

    // --------------------
    // Gestión de equipos
    // --------------------
    public void addPlayerToTeam(String team, Player player) {
        Map<UUID, Player> teamPlayers = teams.get(team.toUpperCase());
        if (teamPlayers != null) {
            teamPlayers.put(player.getUniqueId(), player);
        }
    }

    public void removePlayerFromTeam(String team, Player player) {
        Map<UUID, Player> teamPlayers = teams.get(team.toUpperCase());
        if (teamPlayers != null) {
            teamPlayers.remove(player.getUniqueId());
        }
    }

    public Map<String, Map<UUID, Player>> getTeams() {
        return teams;
    }
}
