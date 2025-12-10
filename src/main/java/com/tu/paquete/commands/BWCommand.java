package com.tu.paquete.commands;

import com.tu.paquete.Main;
import com.tu.paquete.bedwars.BedArena;
import com.tu.paquete.bedwars.BedWarsManager;
import com.tu.paquete.bedwars.setup.BedSetupCommands;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/**
 * Comando principal /bw
 */
public class BWCommand implements CommandExecutor {

    private final Main plugin;
    private final BedWarsManager bedWarsManager;

    public BWCommand() {
        this.plugin = Main.getInstance();
        this.bedWarsManager = plugin.getBedWarsManager();
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (!(sender instanceof Player)) {
            sender.sendMessage("Este comando solo puede ser ejecutado por jugadores.");
            return true;
        }

        Player player = (Player) sender;

        if (args.length == 0) {
            player.sendMessage("Usa /bw help para ver los comandos disponibles.");
            return true;
        }

        String sub = args[0].toLowerCase();

        switch (sub) {
            // -------------------- Jugadores normales --------------------
            case "join":
                // TODO: agregar jugador a arena
                player.sendMessage("Se unira a una arena de BedWars (pendiente).");
                break;

            case "leave":
                // TODO: remover jugador de arena
                player.sendMessage("Has salido de la arena de BedWars.");
                break;

            case "stats":
                // TODO: mostrar stats del jugador
                player.sendMessage("Tus estadísticas de BedWars (pendiente).");
                break;

            case "help":
                player.sendMessage("---- Comandos BedWars ----");
                player.sendMessage("/bw join - Unirse a una arena");
                player.sendMessage("/bw leave - Salir de la arena");
                player.sendMessage("/bw stats - Ver tus estadísticas");
                player.sendMessage("/bw help - Ver esta ayuda");
                break;

            // -------------------- Admin/OP --------------------
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
                BedArena arena = null;
                if (args.length > 1) {
                    arena = bedWarsManager.getArena(args[1]);
                }
                BedSetupCommands setupCommands = arena != null ? new BedSetupCommands(arena) : null;
                if (setupCommands != null) {
                    setupCommands.execute(player, args);
                } else {
                    player.sendMessage("Arena no encontrada.");
                }
                break;

            default:
                player.sendMessage("Comando no reconocido. Usa /bw help");
        }

        return true;
    }
}
