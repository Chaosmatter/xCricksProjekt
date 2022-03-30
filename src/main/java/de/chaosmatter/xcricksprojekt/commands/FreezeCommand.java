package de.chaosmatter.xcricksprojekt.commands;

import de.chaosmatter.xcricksprojekt.Projekt;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import ru.tehkode.permissions.bukkit.PermissionsEx;

import java.io.File;

public class FreezeCommand implements CommandExecutor {
    private final Projekt plugin;

    public FreezeCommand(Projekt plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(command.getName().equalsIgnoreCase("freeze")) {
            if(sender instanceof Player) {
                Player player = (Player) sender;
                if(args.length == 0) {
                    player.sendMessage(this.plugin.getPrefix() + "§cBitte nutze /freeze <Spieler>.");
                    return false;
                }
                if(PermissionsEx.getUser(player).inGroup("Mod") || player.isOp()) {
                    Player target = Bukkit.getPlayer(args[0]);
                    if(target != null) {
                        if(target.isOp() || target.hasPermission("*")) {
                            player.sendMessage("§cDieser Spieler kann nicht gefreezed werden.");
                        }
                            if(target.hasPermission("freezed")) {
                                PermissionsEx.getUser(target).removePermission("freezed");
                            player.sendMessage(this.plugin.getPrefix() + "§aDer Spieler " + target.getName() + " ist nun nicht mehr gefreezed.");
                        } else {PermissionsEx.getUser(target).addPermission("freezed");
                            player.sendMessage(this.plugin.getPrefix() + "§aDer Spieler " + target.getName() + " ist nun gefreezed.");
                        }
                        return false;
                    }
                    player.sendMessage(this.plugin.getPrefix() + "§cDieser Spieler existiert nicht.");
                    return false;
                }
                player.sendMessage(this.plugin.getPrefix() + "§cUnzureichende Berechtigung.");
            }
        }
        return false;
    }
}
