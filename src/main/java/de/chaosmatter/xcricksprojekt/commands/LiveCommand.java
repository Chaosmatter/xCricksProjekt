package de.chaosmatter.xcricksprojekt.commands;

import de.chaosmatter.xcricksprojekt.Projekt;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import ru.tehkode.permissions.bukkit.PermissionsEx;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LiveCommand implements CommandExecutor {
    private final Projekt plugin;

    public LiveCommand(Projekt plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(command.getName().equalsIgnoreCase("live")) {
            if(sender instanceof Player) {
                Player player = (Player) sender;
                if(args.length == 1) {
                    if(PermissionsEx.getUser(player).inGroup("live")) {
                        PermissionsEx.getUser(player).removeGroup("live");
                        this.plugin.getTablistManager().updatePrefixes(player);
                        player.sendMessage(this.plugin.getPrefix() + "§eDu bist nun nicht mehr als Live gelistet!");
                        return false;
                    }
                    for (Player all : Bukkit.getServer().getOnlinePlayers()) {
                        all.sendMessage(this.plugin.getPrefix() + "§5" + player.getName() + " §7ist nun Live auf Twitch! Schaltet gerne ein: §9 " + args[0]);
                    }
                }
                if(PermissionsEx.getUser(player).inGroup("live")) {
                    PermissionsEx.getUser(player).removeGroup("live");
                    this.plugin.getTablistManager().updatePrefixes(player);
                    player.sendMessage(this.plugin.getPrefix() + "§eDu bist nun nicht mehr als Live gelistet!");
                    return false;
                }
                PermissionsEx.getUser(player).addGroup("live");
                this.plugin.getTablistManager().updatePrefixes(player);
                player.sendMessage(this.plugin.getPrefix() + "§eDu bist nun als Live gelistet!");
            }
        }
        return false;
    }

    public boolean isLive(Player player) {
        return PermissionsEx.getUser(player).inGroup("live");
    }
}
