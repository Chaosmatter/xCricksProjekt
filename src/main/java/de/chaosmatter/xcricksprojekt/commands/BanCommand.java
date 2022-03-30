package de.chaosmatter.xcricksprojekt.commands;

import de.chaosmatter.xcricksprojekt.Projekt;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import ru.tehkode.permissions.bukkit.PermissionsEx;

public class BanCommand implements CommandExecutor {
    private final Projekt plugin;

    public BanCommand(Projekt plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(command.getName().equalsIgnoreCase("ban")) {
            if(sender instanceof Player) {
                Player player = (Player) sender;
                if (!PermissionsEx.getUser(player).inGroup("Mod") && !player.isOp()) {
                    player.sendMessage(this.plugin.getPrefix() + "§cUnzureichende Berechtigungen.");
                    return false;
                }
            }
            if(args.length == 1) {
                Player target = Bukkit.getPlayer(args[0]);
                if(target != null) {
                    if(target.isOp()) {
                        sender.sendMessage(this.plugin.getPrefix() + "§cUnzureichende Berechtigungen. (adminbypass)");
                        return false;
                    }
                    target.kickPlayer("§cDu wurdest aus dem Projekt ausgeschlossen.");
                    target.setBanned(true);
                    sender.sendMessage(target.getName() + " wurde vom Projekt ausgeschlossen.");
                    return false;
                }
                sender.sendMessage("Der Spieler " + args[0] + " ist nicht online/existiert nicht.");
                return false;
            }
            sender.sendMessage("Bitte nutze /ban <Spieler>.");
        }
        return false;
    }
}
