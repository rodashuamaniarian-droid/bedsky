package com.tu.paquete.skywars.setup;

import com.tu.paquete.skywars.SkyArena;
import org.bukkit.entity.Player;

public class SkySetupCommands {

    private final SkyArena arena;

    public SkySetupCommands(SkyArena arena) {
        this.arena = arena;
    }

    public void execute(Player player, String[] args) {
        // TODO: lógica de setup por comandos
        player.sendMessage("Setup por comandos de SkyWars (pendiente).");
    }
}
