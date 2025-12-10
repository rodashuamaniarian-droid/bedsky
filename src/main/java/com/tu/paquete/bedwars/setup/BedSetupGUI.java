package com.tu.paquete.bedwars.setup;

import com.tu.paquete.bedwars.BedArena;
import org.bukkit.entity.Player;

/**
 * Setup de BedWars mediante GUI.
 */
public class BedSetupGUI {

    private final BedArena arena;

    public BedSetupGUI(BedArena arena) {
        this.arena = arena;
    }

    /**
     * Abre el menú GUI para configurar la arena.
     *
     * @param player Jugador que abre la GUI
     */
    public void open(Player player) {
        // TODO: crear inventario con botones para:
        // - Posición de spawn
        // - Generadores
        // - Equipos
        // - Otros settings
        player.sendMessage("GUI de setup de BedWars abierta (pendiente).");
    }
}
