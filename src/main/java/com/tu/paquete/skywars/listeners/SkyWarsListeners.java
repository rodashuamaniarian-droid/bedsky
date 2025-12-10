package com.tu.paquete.skywars.listeners;

import com.tu.paquete.Main;
import com.tu.paquete.skywars.SkyArena;
import com.tu.paquete.skywars.SkyWarsManager;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

public class SkyWarsListeners implements Listener {

    private final Main plugin;
    private final SkyWarsManager skyWarsManager;

    public SkyWarsListeners(Main plugin) {
        this.plugin = plugin;
        this.skyWarsManager = plugin.getSkyWarsManager();
    }

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        ItemStack item = event.getItem();
        if (item == null) return;

        SkyArena arena = getPlayerArena(player);
        if (arena == null) return;

        // Item leave (red wool)
        if (item.getType() == Material.RED_WOOL) {
            player.performCommand("sw leave");
            event.setCancelled(true);
        }

        // Item elegir equipo (wool)
        if (item.getType() == Material.WOOL) {
            player.sendMessage("Abriendo selección de equipo SkyWars (GUI pendiente)...");
            event.setCancelled(true);
        }
    }

    private SkyArena getPlayerArena(Player player) {
        for (SkyArena arena : skyWarsManager.getSkyArenas().values()) {
            if (arena.hasPlayer(player.getUniqueId())) {
                return arena;
            }
        }
        return null;
    }
}
