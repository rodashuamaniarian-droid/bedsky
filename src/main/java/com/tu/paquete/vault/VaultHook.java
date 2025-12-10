package com.tu.paquete.common;

import net.milkbowl.vault.economy.Economy;
import org.bukkit.Bukkit;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

public class VaultHook {

    private static Economy econ = null;

    public static void setupEconomy(JavaPlugin plugin) {
        if (plugin.getServer().getPluginManager().getPlugin("Vault") == null) {
            plugin.getLogger().warning("Vault no encontrado, economía deshabilitada.");
            return;
        }

        RegisteredServiceProvider<Economy> rsp = plugin.getServer().getServicesManager().getRegistration(Economy.class);
        if (rsp == null) {
            plugin.getLogger().warning("No se pudo registrar Vault Economy.");
            return;
        }

        econ = rsp.getProvider();
        plugin.getLogger().info("Vault hook cargado correctamente.");
    }

    public static Economy getEconomy() {
        return econ;
    }
}
