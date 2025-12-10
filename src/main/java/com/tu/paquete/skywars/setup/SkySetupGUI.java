package com.tu.paquete.skywars.setup;

import com.tu.paquete.skywars.SkyArena;
import org.bukkit.entity.Player;

public class SkySetupGUI {

    private final SkyArena arena;

    public SkySetupGUI(SkyArena arena) {
        this.arena = arena;
    }

    public void open(Player player) {
        // TODO: GUI de setup SkyWars
        player.sendMessage("GUI de setup de SkyWars abierta (pendiente).");
    }
}
