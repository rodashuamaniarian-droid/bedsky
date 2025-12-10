package com.tu.paquete.placeholder;

import com.tu.paquete.Main;
import me.clip.placeholderapi.expansion.PlaceholderExpansion;
import org.bukkit.entity.Player;

public class SkyWarsPlaceholders extends PlaceholderExpansion {

    private final Main plugin;

    public SkyWarsPlaceholders(Main plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean persist() {
        return true;
    }

    @Override
    public boolean canRegister() {
        return true;
    }

    @Override
    public String getIdentifier() {
        return "sw";
    }

    @Override
    public String getAuthor() {
        return "TuNombre";
    }

    @Override
    public String getVersion() {
        return "1.0";
    }

    @Override
    public String onPlaceholderRequest(Player player, String identifier) {
        if (player == null) return "";

        switch (identifier.toLowerCase()) {
            case "scoreboard_title":
                return "SkyWars Arena";
            case "players_remaining":
                return "0";
            case "teams_active":
                return "0";
            default:
                return null;
        }
    }
}
