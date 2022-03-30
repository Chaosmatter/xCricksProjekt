package de.chaosmatter.xcricksprojekt.listener;

import de.chaosmatter.xcricksprojekt.Projekt;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

import java.io.File;
import java.io.IOException;

public class PlayerDeathListener implements Listener {
    private final Projekt plugin;

    public PlayerDeathListener(Projekt plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void handlePlayerDeath(PlayerDeathEvent event) {
        YamlConfiguration yamlConfigurationX = YamlConfiguration.loadConfiguration(new File("plugins/Projekt/config.yml"));
        Player player = event.getEntity().getPlayer();
        YamlConfiguration yamlConfiguration = YamlConfiguration.loadConfiguration(new File("plugins/Projekt/players.yml"));
        int deaths = yamlConfiguration.getInt("Players." + player.getUniqueId().toString() + ".Deaths");
        yamlConfiguration.set("Players." + player.getUniqueId().toString() + ".Deaths", deaths+1);
        try {
            yamlConfiguration.save(new File("plugins/Projekt/players.yml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        event.setDeathMessage(event.getDeathMessage() + "§7[§c" + yamlConfiguration.getInt("Players." + player.getUniqueId().toString() + ".Deaths") + "§7]");
    }
}
