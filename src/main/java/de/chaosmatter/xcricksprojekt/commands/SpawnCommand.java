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

public class SpawnCommand implements CommandExecutor {
    final private Projekt plugin;

    public SpawnCommand(Projekt plugin) {
        this.plugin = plugin;
    }
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        YamlConfiguration yamlConfiguration = YamlConfiguration.loadConfiguration(new File("plugins/Projekt/config.yml"));
        if(command.getName().equalsIgnoreCase("spawn")) {
            if(sender instanceof Player) {
                Player player = (Player) sender;
                if(player.isOp() || PermissionsEx.getUser(player).inGroup("Mod")) {
                    if(args.length == 0) {
                        player.teleport(new Location(Bukkit.getServer().getWorld("world"), yamlConfiguration.getInt("locations.spawn.x"), yamlConfiguration.getInt("locations.spawn.y"), yamlConfiguration.getInt("locations.spawn.z")));
                        return false;
                    }
                    if(args[0].equalsIgnoreCase("lightfall")) {
                        player.teleport(new Location(Bukkit.getServer().getWorld("world"), yamlConfiguration.getInt("locations.lightfall.x"), yamlConfiguration.getInt("locations.lightfall.y"), yamlConfiguration.getInt("locations.lightfall.z")));
                        return false;
                    }
                    if (args[0].equalsIgnoreCase("mantaria")) {
                        player.teleport(new Location(Bukkit.getServer().getWorld("world"), yamlConfiguration.getInt("locations.mantaria.x"), yamlConfiguration.getInt("locations.mantaria.y"), yamlConfiguration.getInt("locations.mantaria.z")));
                        return false;
                    }
                    if (args[0].equalsIgnoreCase("nightclaw")) {
                        player.teleport(new Location(Bukkit.getServer().getWorld("world"), yamlConfiguration.getInt("locations.nightclaw.x"), yamlConfiguration.getInt("locations.nightclaw.y"), yamlConfiguration.getInt("locations.nightclaw.z")));
                        return false;
                    }
                    if (args[0].equalsIgnoreCase("aymaray")) {
                        player.teleport(new Location(Bukkit.getServer().getWorld("world"), yamlConfiguration.getInt("locations.aymaray.x"), yamlConfiguration.getInt("locations.aymaray.y"), yamlConfiguration.getInt("locations.aymaray.z")));
                        return false;
                    }
                    if (args[0].equalsIgnoreCase("narbo")) {
                        player.teleport(new Location(Bukkit.getServer().getWorld("world"), yamlConfiguration.getInt("locations.narbo.x"), yamlConfiguration.getInt("locations.narbo.y"), yamlConfiguration.getInt("locations.narbo.z")));
                        return false;
                    }
                    player.teleport(new Location(Bukkit.getServer().getWorld("world"), yamlConfiguration.getInt("locations.spawn.x"), yamlConfiguration.getInt("locations.spawn.y"), yamlConfiguration.getInt("locations.spawn.z")));
                    return false;
                }
                player.sendMessage(this.plugin.getPrefix() + "§cUnzureichende Rechte.");
            }
        }
        return false;
    }
}
