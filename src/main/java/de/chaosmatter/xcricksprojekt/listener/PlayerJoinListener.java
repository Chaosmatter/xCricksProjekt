package de.chaosmatter.xcricksprojekt.listener;

import de.chaosmatter.xcricksprojekt.PortalTeleporter;
import de.chaosmatter.xcricksprojekt.Projekt;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.scoreboard.Team;
import ru.tehkode.permissions.bukkit.PermissionsEx;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

public class PlayerJoinListener implements Listener {
    private final Projekt plugin;

    public PlayerJoinListener(Projekt plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void handlePlayerJoin(PlayerJoinEvent event) {
        if(this.plugin.getVoteManager().isVoteActive(this.plugin.getPlayerHelper().getStadt(event.getPlayer().getUniqueId()))) {
            event.getPlayer().sendMessage("§eIn deiner Stadt wird aktuell gewählt! Wähle selbst mit /vote oder stelle dich mit /vote run selbst zur Wahl.");
        }
        YamlConfiguration yamlConfigurationX = YamlConfiguration.loadConfiguration(new File("plugins/Projekt/players.yml"));
        if(!yamlConfigurationX.contains("Players." + event.getPlayer().getUniqueId().toString())) {
            yamlConfigurationX.set("Players." + event.getPlayer().getUniqueId().toString() + ".Deaths", 0);
            try {
                yamlConfigurationX.save(new File("plugins/Projekt/players.yml"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        this.plugin.getTablistManager().updatePrefixes(event.getPlayer());
        YamlConfiguration yamlConfiguration = YamlConfiguration.loadConfiguration(new File("plugins/Projekt/config.yml"));
        event.getPlayer().setGameMode(GameMode.SURVIVAL);
        if(!isInTeam(event.getPlayer())) {
            event.getPlayer().teleport(new Location(Bukkit.getServer().getWorld("world"), yamlConfiguration.getInt("locations.spawn.x"), yamlConfiguration.getInt("locations.spawn.y"), yamlConfiguration.getInt("locations.spawn.z")));
            event.getPlayer().setBedSpawnLocation(new Location(Bukkit.getServer().getWorld("world"), yamlConfiguration.getInt("locations.spawn.x"), yamlConfiguration.getInt("locations.spawn.y"), yamlConfiguration.getInt("locations.spawn.z")));
        }
    }

    public Boolean isInTeam(Player player) {
        if(PermissionsEx.getUser(player).inGroup("lightfall") || PermissionsEx.getUser(player).inGroup("mantaria") || PermissionsEx.getUser(player).inGroup("nightclaw") || PermissionsEx.getUser(player).inGroup("aymaray") || PermissionsEx.getUser(player).inGroup("narbo") || PermissionsEx.getUser(player).inGroup("abtrünniger")) {
            return true;
        }
        return false;
    }
}
