package com.tu.paquete.bedwars;

import com.tu.paquete.common.Arena;
import com.tu.paquete.common.GameState;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * Clase que representa una arena de BedWars.
 */
public class BedArena extends Arena {

    // Equipos: nombre -> jugadores
    private final Map<String, Map<UUID, Player>> teams;

    public BedArena(String name) {
        super(name);
        this.teams = new HashMap<>();
        // Ejemplo: equipos rojo, azul, amarillo, verde
        teams.put("RED", new HashMap<>());
        teams.put("BLUE", new HashMap<>());
        teams.put("YELLOW", new HashMap<>());
        teams.put("GREEN", new HashMap<>());
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
        // TODO: permitir setup con comandos
    }

    @Override
    public void startGame() {
        setState(GameState.INGAME);
        // TODO: teletransportar jugadores, iniciar generadores y scoreboard
        givePlayerItems();
    }

    @Override
    public void resetGame() {
        setState(GameState.RESETTING);
        // TODO: resetear mapa con WorldEdit
        // Vaciar jugadores, limpiar inventarios
        getPlayers().clear();
    }

    // --------------------
    // Items especiales para jugadores
    // --------------------
    private void givePlayerItems() {
        for (UUID uuid : getPlayers()) {
            Player player = org.bukkit.Bukkit.getPlayer(uuid);
            if (player != null) {
                // Item para salir de la partida (leave)
                ItemStack leaveItem = new ItemStack(Material.BED);
                player.getInventory().setItem(8, leaveItem); // slot 9
                // Item para elegir equipo
                ItemStack teamItem = new ItemStack(Material.WOOL, 1);
                player.getInventory().setItem(0, teamItem); // slot 1
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
