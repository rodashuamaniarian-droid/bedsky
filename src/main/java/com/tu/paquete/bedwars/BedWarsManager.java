package com.tu.paquete.bedwars;

import com.tu.paquete.common.Arena;
import com.tu.paquete.common.ArenaManager;
import com.tu.paquete.Main;
import org.bukkit.Bukkit;

import java.util.HashMap;
import java.util.Map;

/**
 * Gestor específico de BedWars.
 * Maneja arenas, equipos y lógica de partidas.
 */
public class BedWarsManager {

    private final Main plugin;
    private final ArenaManager arenaManager;

    // Mapa de arenas BedWars: nombre -> BedArena
    private final Map<String, BedArena> bedArenas;

    public BedWarsManager(Main plugin) {
        this.plugin = plugin;
        this.arenaManager = plugin.getArenaManager();
        this.bedArenas = new HashMap<>();
    }

    // --------------------
    // Gestión de arenas BedWars
    // --------------------

    /**
     * Crea una nueva arena BedWars y la registra.
     *
     * @param name Nombre de la arena
     * @return La arena creada
     */
    public BedArena createArena(String name) {
        if (bedArenas.containsKey(name)) {
            return bedArenas.get(name);
        }

        BedArena arena = new BedArena(name);
        bedArenas.put(name, arena);
        arenaManager.registerArena(arena);
        Bukkit.getLogger().info("BedWars Arena registrada: " + name);
        return arena;
    }

    /**
     * Obtiene una arena BedWars por nombre.
     *
     * @param name Nombre de la arena
     * @return BedArena o null si no existe
     */
    public BedArena getArena(String name) {
        return bedArenas.get(name);
    }

    /**
     * Elimina una arena BedWars.
     *
     * @param name Nombre de la arena
     */
    public void removeArena(String name) {
        BedArena arena = bedArenas.remove(name);
        if (arena != null) {
            arenaManager.unregisterArena(name);
            Bukkit.getLogger().info("BedWars Arena eliminada: " + name);
        }
    }

    /**
     * Obtiene todas las arenas BedWars.
     *
     * @return Mapa de arenas
     */
    public Map<String, BedArena> getBedArenas() {
        return bedArenas;
    }

    public Main getPlugin() {
        return plugin;
    }
}
