package com.tu.paquete.common;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

/**
 * Listeners comunes para ambos modos
 */
public class CommonListeners implements Listener {

    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent event) {
        // TODO: remover jugador de cualquier arena al desconectarse
        event.getPlayer().sendMessage("Se ha desconectado de la arena (pendiente).");
    }
}
