package com.tu.paquete.commands;

import com.tu.paquete.Main;
import com.tu.paquete.skywars.SkyArena;
import com.tu.paquete.skywars.SkyWarsManager;
import com.tu.paquete.skywars.setup.SkySetupCommands;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SWCommand implements CommandExecutor {

    private final Main plugin;
    private final SkyWarsManager skyWarsManager;

    public SWCommand() {
        this.plugin = Main.getInstance();
        this.skyWarsManager = plugin.getSkyWarsManager();
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("Este comando solo puede ser ejecutado por jugadores.");
            return true;
        }

        Player player = (Player) sender;

        if (args.length == 0) {
            player.sendMessage("Usa /sw help para ver los comandos disponibles.");
            return true;
        }

        String sub = args[0].toLowerCase();

        switch (sub) {
            case "join":
                player.sendMessage("Se unira a una arena de SkyWars (pendiente).");
                break;

            case "leave":
                player.sendMessage("Has salido de la arena de SkyWars.");
                break;

            case "help":
                player.sendMessage("---- Comandos SkyWars ----");
                player.sendMessage("/sw join - Unirse a una arena");
                player.sendMessage("/sw leave - Salir de la arena");
                player.sendMessage("/sw help - Ver esta ayuda");
                break;

            // Admin/OP
            case "pos1":
            case "pos2":
            case "setgenerator":
            case "save":
            case "enable":
            case "setteam":
            case "delete":
                if (!player.isOp()) {
                    player.sendMessage("No tienes permisos para este comando.");
                    return true;
                }
                SkyArena arena = null;
                if (args.length > 1) {
                    arena = skyWarsManager.getArena(args[1]);
                }
                SkySetupCommands setupCommands = arena != null ? new SkySetupCommands(arena) : null;
                if (setupCommands != null) {
                    setupCommands.execute(player, args);
                } else {
                    player.sendMessage("Arena no encontrada.");
                }
                break;

            default:
                player.sendMessage("Comando no reconocido. Usa /sw help");
        }

        return true;
    }
}
