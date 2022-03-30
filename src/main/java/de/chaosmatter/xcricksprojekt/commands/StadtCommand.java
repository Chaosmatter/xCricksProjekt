package de.chaosmatter.xcricksprojekt.commands;

import de.chaosmatter.xcricksprojekt.Projekt;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import ru.tehkode.permissions.bukkit.PermissionsEx;

import java.io.File;

public class StadtCommand implements CommandExecutor {
    private final Projekt plugin;

    public StadtCommand(Projekt plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        YamlConfiguration yamlConfiguration = YamlConfiguration.loadConfiguration(new File("plugins/Projekt/config.yml"));
        if(command.getName().equalsIgnoreCase("stadt")) {
            if (sender instanceof Player) {
                Player player = (Player) sender;
                if(!PermissionsEx.getUser(player).inGroup("Mod") && !player.isOp()) {
                    player.sendMessage(this.plugin.getPrefix() + "§cUnzureichende Berechtigungen.");
                    return false;
                }
            }
            if(args.length == 3) {
                Player target = Bukkit.getPlayer(args[2]);
                if(target != null) {
                    if (args[1].equalsIgnoreCase("add")) {
                        if(PermissionsEx.getPermissionManager().getGroup(args[1].toLowerCase()) == null) {
                            sender.sendMessage("Diese Stadt existiert nicht.");
                            return false;
                        }
                        PermissionsEx.getUser(target).addGroup(args[0].toLowerCase());
                        PermissionsEx.getUser(target).removeGroup("default");
                        sender.sendMessage("Der Spieler " + target.getName() + " wurde der Stadt " + args[0] + " hinzugefügt.");
                        this.plugin.getTablistManager().updatePrefixes(target.getPlayer());
                        target.sendMessage(this.plugin.getPrefix() + "§eDu wurdest der Stadt §a" + args[0] + " §ehinzugefügt. Du kannst nun das für deine Stadt vorgesehene Portal passieren.");
                        return false;
                    }
                    if (args[1].equalsIgnoreCase("remove")) {
                        if(PermissionsEx.getPermissionManager().getGroup(args[0].toLowerCase()) == null) {
                            sender.sendMessage("Diese Stadt existiert nicht.");
                            return false;
                        }
                        PermissionsEx.getUser(target).removeGroup(args[1].toLowerCase());
                        PermissionsEx.getUser(target).addGroup("default");
                        sender.sendMessage("Der Spieler " + target.getName() + " wurde aus der Stadt " + args[0] + " entfernt.");
                        this.plugin.getTablistManager().updatePrefixes(target.getPlayer());
                        target.sendMessage(this.plugin.getPrefix() + "§eDu wurdest aus der Stadt §c" + args[0] + " §eentfernt. Du wirst zum Spawn teleportiert.");
                        target.teleport(new Location(Bukkit.getServer().getWorld("world"), yamlConfiguration.getInt("locations.spawn.x"), yamlConfiguration.getInt("locations.spawn.y"), yamlConfiguration.getInt("locations.spawn.z")));
                        return false;
                    }
                    sender.sendMessage("Bitte nutze /stadt <Stadt> <add/remove> <Spieler>.");
                    return false;
                }
                sender.sendMessage("Der Spieler " + args[2] + " ist nicht online/existiert nicht.");
                return false;
            }
            sender.sendMessage("Bitte nutze /stadt <Stadt> <add/remove> <Spieler>.");
        }
        return false;
    }
}
