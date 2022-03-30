package de.chaosmatter.xcricksprojekt.commands;

import de.chaosmatter.xcricksprojekt.Projekt;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import java.io.File;

public class SetSpawnCommand implements CommandExecutor {
    final private Projekt plugin;

    public SetSpawnCommand(Projekt plugin) {
        this.plugin = plugin;
    }
    YamlConfiguration yamlConfiguration = YamlConfiguration.loadConfiguration(new File("plugins/Projekt/config.yml"));


    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(command.getName().equalsIgnoreCase("setspawn")) {
            if (sender instanceof Player) {
                Player player = (Player) sender;
                if(player.isOp()) {
                    if(args.length == 0) {
                        yamlConfiguration.set("locations.spawn.x", player.getLocation().getBlockX());
                        yamlConfiguration.set("locations.spawn.y", player.getLocation().getBlockY());
                        yamlConfiguration.set("locations.spawn.z", player.getLocation().getBlockZ());
                        this.plugin.getData().updateConfig(yamlConfiguration);
                        player.sendMessage(this.plugin.getPrefix() + "§aSpawn gesetzt.");
                        return false;
                    }
                    if(args[0].equalsIgnoreCase("spawn")) {
                        //dort wo man spawnt wenn man das erste mal den server betritt
                        yamlConfiguration.set("locations.spawn.x", player.getLocation().getBlockX());
                        yamlConfiguration.set("locations.spawn.y", player.getLocation().getBlockY());
                        yamlConfiguration.set("locations.spawn.z", player.getLocation().getBlockZ());
                        this.plugin.getData().updateConfig(yamlConfiguration);
                        player.sendMessage(this.plugin.getPrefix() + "§aSpawn gesetzt.");
                        return false;
                    }
                    if(args[0].equalsIgnoreCase("lightfall")) {
                        yamlConfiguration.set("locations.lightfall.x", player.getLocation().getBlockX());
                        yamlConfiguration.set("locations.lightfall.y", player.getLocation().getBlockY());
                        yamlConfiguration.set("locations.lightfall.z", player.getLocation().getBlockZ());
                        this.plugin.getData().updateConfig(yamlConfiguration);
                        player.sendMessage(this.plugin.getPrefix() + "§aSpawn gesetzt. (Lightfall)");
                        return false;
                    }
                    if (args[0].equalsIgnoreCase("mantaria")) {
                        yamlConfiguration.set("locations.mantaria.x", player.getLocation().getBlockX());
                        yamlConfiguration.set("locations.mantaria.y", player.getLocation().getBlockY());
                        yamlConfiguration.set("locations.mantaria.z", player.getLocation().getBlockZ());
                        this.plugin.getData().updateConfig(yamlConfiguration);
                        player.sendMessage(this.plugin.getPrefix() + "§aSpawn gesetzt. (Mantaria)");
                        return false;
                    }
                    if (args[0].equalsIgnoreCase("nightclaw")) {
                        yamlConfiguration.set("locations.nightclaw.x", player.getLocation().getBlockX());
                        yamlConfiguration.set("locations.nightclaw.y", player.getLocation().getBlockY());
                        yamlConfiguration.set("locations.nightclaw.z", player.getLocation().getBlockZ());
                        this.plugin.getData().updateConfig(yamlConfiguration);
                        player.sendMessage(this.plugin.getPrefix() + "§aSpawn gesetzt. (Nightclaw)");
                        return false;
                    }
                    if ((args[0].equalsIgnoreCase("aymaray"))) {
                        yamlConfiguration.set("locations.aymaray.x", player.getLocation().getBlockX());
                        yamlConfiguration.set("locations.aymaray.y", player.getLocation().getBlockY());
                        yamlConfiguration.set("locations.aymaray.z", player.getLocation().getBlockZ());
                        this.plugin.getData().updateConfig(yamlConfiguration);
                        player.sendMessage(this.plugin.getPrefix() + "§aSpawn gesetzt. (Aymaray)");
                        return false;
                    }
                    if ((args[0].equalsIgnoreCase("narbo"))) {
                        yamlConfiguration.set("locations.narbo.x", player.getLocation().getBlockX());
                        yamlConfiguration.set("locations.narbo.y", player.getLocation().getBlockY());
                        yamlConfiguration.set("locations.narbo.z", player.getLocation().getBlockZ());
                        this.plugin.getData().updateConfig(yamlConfiguration);
                        player.sendMessage(this.plugin.getPrefix() + "§aSpawn gesetzt. (Narbo)");
                        return false;
                    }
                    player.sendMessage(Projekt.getInstance().getPrefix() + "§cDieses Team existiert nicht.");
                return false;
                }
                player.sendMessage("§cUnzureichende Rechte.");
            }
        }
        return false;
    }
}
