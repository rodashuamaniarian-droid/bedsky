package com.tu.paquete.skywars;

import com.tu.paquete.Main;
import com.tu.paquete.common.ArenaManager;
import org.bukkit.Bukkit;

import java.util.HashMap;
import java.util.Map;

/**
 * Gestor específico de SkyWars.
 */
public class SkyWarsManager {

    private final Main plugin;
    private final ArenaManager arenaManager;
    private final Map<String, SkyArena> skyArenas;

    public SkyWarsManager(Main plugin) {
        this.plugin = plugin;
        this.arenaManager = plugin.getArenaManager();
        this.skyArenas = new HashMap<>();
    }

    public SkyArena createArena(String name) {
        if (skyArenas.containsKey(name)) return skyArenas.get(name);

        SkyArena arena = new SkyArena(name);
        skyArenas.put(name, arena);
        arenaManager.registerArena(arena);
        Bukkit.getLogger().info("SkyWars Arena registrada: " + name);
        return arena;
    }

    public SkyArena getArena(String name) {
        return skyArenas.get(name);
    }

    public void removeArena(String name) {
        SkyArena arena = skyArenas.remove(name);
        if (arena != null) {
            arenaManager.unregisterArena(name);
            Bukkit.getLogger().info("SkyWars Arena eliminada: " + name);
        }
    }

    public Map<String, SkyArena> getSkyArenas() {
        return skyArenas;
    }

    public Main getPlugin() {
        return plugin;
    }
}
