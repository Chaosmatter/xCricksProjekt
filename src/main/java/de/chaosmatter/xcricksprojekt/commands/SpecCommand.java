package de.chaosmatter.xcricksprojekt.commands;

import de.chaosmatter.xcricksprojekt.Projekt;
import lombok.Getter;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import ru.tehkode.permissions.bukkit.PermissionsEx;

import java.util.ArrayList;
import java.util.List;

public class SpecCommand implements CommandExecutor {
    private final Projekt plugin;

    public SpecCommand(Projekt plugin) {
        this.plugin = plugin;
    }
    @Getter
    private List<Player> specs = new ArrayList<>();

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(command.getName().equalsIgnoreCase("spec") || command.getName().equalsIgnoreCase("spectate")) {
            if(sender instanceof Player) {
                Player player = (Player) sender;
                if(player.hasPermission("*") || player.isOp() || PermissionsEx.getUser(player).inGroup("Mod")) {
                    if(this.specs.contains(player)) {
                        //make player visible
                        player.setAllowFlight(false);
                        player.setFlying(false);
                        for(Player all : Bukkit.getServer().getOnlinePlayers()) {
                            all.showPlayer(player);
                        }
                        player.sendMessage(this.plugin.getPrefix() + "§aDu bist nun nicht mehr im Specator-Mode.");
                        return false;
                    }
                    //make player invisible
                    player.setAllowFlight(true);
                    player.setFlying(true);
                    for(Player all : Bukkit.getServer().getOnlinePlayers()) {
                        all.hidePlayer(player);
                    }
                    this.specs.add(player);
                    player.sendMessage(this.plugin.getPrefix() + "§aDu bist nun im Specator-Mode.");
                    return false;
                }
                player.sendMessage(this.plugin.getPrefix() + "§cUnzureichende Berechtigung.");
            }
        }
        return false;
    }
}
