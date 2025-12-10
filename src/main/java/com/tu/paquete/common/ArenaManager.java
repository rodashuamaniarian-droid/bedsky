package com.tu.paquete.common;

import org.bukkit.plugin.Plugin;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Clase que gestiona todas las arenas del plugin.
 * Permite registrar, obtener y listar arenas de cualquier modo.
 */
public class ArenaManager {

    private final Plugin plugin;

    // Mapa de arenas: nombre -> arena
    private final Map<String, Arena> arenas;

    public ArenaManager(Plugin plugin) {
        this.plugin = plugin;
        this.arenas = new ConcurrentHashMap<>();
    }

    // --------------------
    // Gestión de arenas
    // --------------------

    /**
     * Registra una arena en el manager.
     *
     * @param arena La arena a registrar
     */
    public void registerArena(Arena arena) {
        arenas.put(arena.getName(), arena);
    }

    /**
     * Obtiene una arena por su nombre.
     *
     * @param name Nombre de la arena
     * @return Arena o null si no existe
     */
    public Arena getArena(String name) {
        return arenas.get(name);
    }

    /**
     * Elimina una arena del manager.
     *
     * @param name Nombre de la arena
     */
    public void unregisterArena(String name) {
        arenas.remove(name);
    }

    /**
     * Obtiene todas las arenas registradas.
     *
     * @return Mapa de arenas
     */
    public Map<String, Arena> getArenas() {
        return arenas;
    }

    /**
     * Obtiene el plugin asociado.
     *
     * @return Plugin
     */
    public Plugin getPlugin() {
        return plugin;
    }
}
