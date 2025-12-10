package com.tu.paquete.bedwars.setup;

import com.tu.paquete.bedwars.BedArena;
import org.bukkit.entity.Player;

/**
 * Setup de BedWars mediante comandos.
 */
public class BedSetupCommands {

    private final BedArena arena;

    public BedSetupCommands(BedArena arena) {
        this.arena = arena;
    }

    /**
     * Método para ejecutar comandos de setup.
     * Aquí se manejarán comandos como:
     * /bw pos1, /bw pos2, /bw setgenerator, etc.
     *
     * @param player Jugador que ejecuta el comando
     * @param args Argumentos del comando
     */
    public void execute(Player player, String[] args) {
        // TODO: lógica de setup por comandos
        player.sendMessage("Setup por comandos de BedWars (pendiente).");
    }
}
