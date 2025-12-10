package com.tu.paquete.common;

/**
 * Enum que define los estados de una arena.
 */
public enum GameState {
    WAITING,   // Esperando jugadores
    STARTING,  // Contando para iniciar
    INGAME,    // Partida en curso
    ENDING,    // Partida terminada, mostrando resultados
    RESETTING  // Reseteando la arena
}
