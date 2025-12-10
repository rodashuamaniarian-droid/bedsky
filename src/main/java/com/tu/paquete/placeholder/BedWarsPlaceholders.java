package com.tu.paquete.placeholder;

import com.tu.paquete.Main;
import me.clip.placeholderapi.expansion.PlaceholderExpansion;
import org.bukkit.entity.Player;

/**
 * Placeholders específicos de BedWars
 */
public class BedWarsPlaceholders extends PlaceholderExpansion {

    private final Main plugin;

    public BedWarsPlaceholders(Main plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean persist() {
        return true; // Mantener esta expansión activa
    }

    @Override
    public boolean canRegister() {
        return true;
    }

    @Override
    public String getIdentifier() {
        return "bw"; // Prefijo de los placeholders: %bw_%
    }

    @Override
    public String getAuthor() {
        return "TuNombre";
    }

    @Override
    public String getVersion() {
        return "1.0";
    }

    /**
     * Aquí se retornan los valores de los placeholders
     *
     * @param player Jugador
     * @param identifier Identificador del placeholder (sin bw_)
     * @return Valor del placeholder
     */
    @Override
    public String onPlaceholderRequest(Player player, String identifier) {

        if (player == null) return "";

        switch (identifier.toLowerCase()) {
            case "scoreboard_title":
                return "BedWars Arena"; // TODO: puedes hacerlo dinámico según arena
            case "players_remaining":
                // TODO: retornar jugadores restantes en la arena del jugador
                return "0";
            case "teams_active":
                // TODO: retornar cantidad de equipos activos
                return "0";
            default:
                return null;
        }
    }
}
