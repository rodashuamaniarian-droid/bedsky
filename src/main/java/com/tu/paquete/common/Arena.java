package com.tu.paquete.common;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

/**
 * Clase base para todas las arenas (BedWars, SkyWars, etc.)
 * Contiene jugadores, estado del juego y métodos abstractos para cada modo.
 */
public abstract class Arena {

    private final String name;
    private final Set<UUID> players;
    private GameState state;

    public Arena(String name) {
        this.name = name;
        this.players = new HashSet<>();
        this.state = GameState.WAITING;
    }

    // --------------------
    // Getters y Setters
    // --------------------
    public String getName() {
        return name;
    }

    public Set<UUID> getPlayers() {
        return players;
    }

    public GameState getState() {
        return state;
    }

    public void setState(GameState state) {
        this.state = state;
    }

    // --------------------
    // Gestión de jugadores
    // --------------------
    public void addPlayer(UUID uuid) {
        players.add(uuid);
    }

    public void removePlayer(UUID uuid) {
        players.remove(uuid);
    }

    public boolean hasPlayer(UUID uuid) {
        return players.contains(uuid);
    }

    public int getPlayerCount() {
        return players.size();
    }

    // --------------------
    // Métodos abstractos
    // Cada modo implementará su propia lógica
    // --------------------
    
    /** Setup de la arena mediante GUI (menus) */
    public abstract void setupGui();

    /** Setup de la arena mediante comandos */
    public abstract void setupCommands();

    /** Inicia el juego en esta arena */
    public abstract void startGame();

    /** Resetea la arena (WorldEdit o restauración) */
    public abstract void resetGame();
}
