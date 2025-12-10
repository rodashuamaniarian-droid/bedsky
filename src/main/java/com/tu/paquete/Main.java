package com.tu.paquete;

import com.tu.paquete.bedwars.BedWarsManager;
import com.tu.paquete.commands.BWCommand;
import com.tu.paquete.commands.SWCommand;
import com.tu.paquete.common.ArenaManager;
import com.tu.paquete.common.CommonListeners;
import com.tu.paquete.placeholder.BedWarsPlaceholders;
import com.tu.paquete.placeholder.SkyWarsPlaceholders;
import com.tu.paquete.skywars.SkyWarsManager;
import com.tu.paquete.skywars.listeners.SkyWarsListeners;
import com.tu.paquete.bedwars.listeners.BedWarsListeners;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    private static Main instance;

    private ArenaManager arenaManager;
    private BedWarsManager bedWarsManager;
    private SkyWarsManager skyWarsManager;

    @Override
    public void onEnable() {
        instance = this;

        // -------------------------
        // Inicializar managers
        // -------------------------
        arenaManager = new ArenaManager(this);
        bedWarsManager = new BedWarsManager(this);
        skyWarsManager = new SkyWarsManager(this);

        // -------------------------
        // Registrar comandos
        // -------------------------
        getCommand("bw").setExecutor(new BWCommand());
        getCommand("sw").setExecutor(new SWCommand());

        // -------------------------
        // Registrar listeners
        // -------------------------
        Bukkit.getPluginManager().registerEvents(new BedWarsListeners(this), this);
        Bukkit.getPluginManager().registerEvents(new SkyWarsListeners(this), this);
        Bukkit.getPluginManager().registerEvents(new CommonListeners(), this);

        // -------------------------
        // Registrar placeholders
        // -------------------------
        if (Bukkit.getPluginManager().isPluginEnabled("PlaceholderAPI")) {
            new BedWarsPlaceholders(this).register();
            new SkyWarsPlaceholders(this).register();
        }

        // -------------------------
        // Hooks externos
        // -------------------------
        VaultHook.setupEconomy(this);

        getLogger().info("Plugin habilitado correctamente.");
    }

    @Override
    public void onDisable() {
        getLogger().info("Plugin deshabilitado.");
    }

    public static Main getInstance() {
        return instance;
    }

    public ArenaManager getArenaManager() {
        return arenaManager;
    }

    public BedWarsManager getBedWarsManager() {
        return bedWarsManager;
    }

    public SkyWarsManager getSkyWarsManager() {
        return skyWarsManager;
    }
}
