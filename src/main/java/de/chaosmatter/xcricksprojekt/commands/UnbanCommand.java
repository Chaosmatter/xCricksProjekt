package de.chaosmatter.xcricksprojekt.commands;

import de.chaosmatter.xcricksprojekt.Projekt;
import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import ru.tehkode.permissions.bukkit.PermissionsEx;

public class UnbanCommand implements CommandExecutor {
    private final Projekt plugin;

    public UnbanCommand(Projekt plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(command.getName().equalsIgnoreCase("unban")) {
            if(sender instanceof Player) {
                Player player = (Player) sender;
                if (!PermissionsEx.getUser(player).inGroup("Mod") && !player.isOp()) {
                    player.sendMessage(this.plugin.getPrefix() + "§cUnzureichende Berechtigungen.");
                    return false;
                }
            }
            if (args.length == 1) {
                OfflinePlayer target = Bukkit.getPlayer(args[0]);
                if (target != null) {
                    if(target.isBanned()) {
                        target.setBanned(false);
                        sender.sendMessage("Der Spieler " + target.getName() + " ist nun nicht mehr gebannt.");
                        return false;
                    }
                    sender.sendMessage("Dieser Spieler ist nicht gebannt.");
                    return false;
                }
                sender.sendMessage("Dieser Spieler existiert nicht.");
                return false;
            }
            sender.sendMessage("Bitte nutze /unban <Spieler>.");
        }
        return false;
    }
}
