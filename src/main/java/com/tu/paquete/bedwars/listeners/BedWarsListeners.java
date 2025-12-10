package com.tu.paquete.bedwars.listeners;

import com.tu.paquete.Main;
import com.tu.paquete.bedwars.BedArena;
import com.tu.paquete.bedwars.BedWarsManager;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

/**
 * Listeners específicos de BedWars.
 */
public class BedWarsListeners implements Listener {

    private final Main plugin;
    private final BedWarsManager bedWarsManager;

    public BedWarsListeners(Main plugin) {
        this.plugin = plugin;
        this.bedWarsManager = plugin.getBedWarsManager();
    }

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        ItemStack item = event.getItem();
        if (item == null) return;

        // Obtener arena del jugador
        BedArena arena = getPlayerArena(player);
        if (arena == null) return;

        // --------------------
        // Click en cama -> leave
        // --------------------
        if (item.getType() == Material.BED) {
            player.performCommand("bw leave");
            event.setCancelled(true);
            return;
        }

        // --------------------
        // Click en lana -> elegir equipo
        // --------------------
        if (item.getType() == Material.WOOL) {
            // TODO: abrir GUI de selección de equipo
            player.sendMessage("Abriendo selección de equipo (GUI pendiente)...");
            event.setCancelled(true);
        }
    }

    /**
     * Obtiene la arena BedWars del jugador
     * 
     * @param player Jugador
     * @return BedArena o null si no está en ninguna
     */
    private BedArena getPlayerArena(Player player) {
        for (BedArena arena : bedWarsManager.getBedArenas().values()) {
            if (arena.hasPlayer(player.getUniqueId())) {
                return arena;
            }
        }
        return null;
    }
}
