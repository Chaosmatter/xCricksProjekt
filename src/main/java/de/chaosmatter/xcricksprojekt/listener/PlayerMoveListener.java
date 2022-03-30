package de.chaosmatter.xcricksprojekt.listener;

import de.chaosmatter.xcricksprojekt.Projekt;
import net.minecraft.server.v1_7_R4.Material;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import ru.tehkode.permissions.bukkit.PermissionsEx;

import java.io.File;

public class PlayerMoveListener implements Listener {
    private final Projekt plugin;
    private  Location lightfallPortalX = new Location(Bukkit.getWorld("world"), 333, 71, 915);
    private Location lightfallPortalY = new Location(Bukkit.getWorld("world"), 332, 71, 915);
    Location mantariaPortalX = new Location(Bukkit.getWorld("world"), 340, 71, 905);
    Location mantariaPortalY = new Location(Bukkit.getWorld("world"), 340, 71, 906);
    Location nightclawPortalX = new Location(Bukkit.getWorld("world"), 340, 71, 910);
    Location nightclawPortalY = new Location(Bukkit.getWorld("world"), 340, 71, 911);
    Location aymarayPortalX = new Location(Bukkit.getWorld("world"), 321, 71, 914);
    Location aymarayPortalY = new Location(Bukkit.getWorld("world"), 320, 71, 914);
    Location narboPortalX = new Location(Bukkit.getWorld("world"), 317, 71, 911);
    Location narboPortalY = new Location(Bukkit.getWorld("world"), 317, 71, 910);

    public PlayerMoveListener(Projekt plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void handlePlayerMove(PlayerMoveEvent event) {
        YamlConfiguration yamlConfiguration = YamlConfiguration.loadConfiguration(new File("plugins/Projekt/config.yml"));
        Player player = event.getPlayer();


        if(player.getLocation().getBlockX() == 333 && player.getLocation().getBlockY() == 71 && player.getLocation().getBlockZ() == 915) {
            if(PermissionsEx.getUser(player).inGroup("lightfall") || player.isOp() || PermissionsEx.getUser(player).inGroup("Mod")) {
                player.teleport(new Location(Bukkit.getServer().getWorld("world"), yamlConfiguration.getInt("locations.lightfall.x"), yamlConfiguration.getInt("locations.lightfall.y"), yamlConfiguration.getInt("locations.lightfall.z")));
            }
        }
        if(player.getLocation().getBlockX() == 332 && player.getLocation().getBlockY() == 71 && player.getLocation().getBlockZ() == 915) {
            if(PermissionsEx.getUser(player).inGroup("lightfall") || player.isOp() || PermissionsEx.getUser(player).inGroup("Mod")) {
                player.teleport(new Location(Bukkit.getServer().getWorld("world"), yamlConfiguration.getInt("locations.lightfall.x"), yamlConfiguration.getInt("locations.lightfall.y"), yamlConfiguration.getInt("locations.lightfall.z")));
            }
        }

        if(player.getLocation().getBlockX() == 340 && player.getLocation().getBlockY() == 71 && player.getLocation().getBlockZ() == 905) {
            if(PermissionsEx.getUser(player).inGroup("mantaria") || player.isOp() || PermissionsEx.getUser(player).inGroup("Mod")) {
                player.teleport(new Location(Bukkit.getServer().getWorld("world"), yamlConfiguration.getInt("locations.mantaria.x"), yamlConfiguration.getInt("locations.mantaria.y"), yamlConfiguration.getInt("locations.mantaria.z")));
            }
        }
        if(player.getLocation().getBlockX() == 340 && player.getLocation().getBlockY() == 71 && player.getLocation().getBlockZ() == 906) {
            if(PermissionsEx.getUser(player).inGroup("mantaria") || player.isOp() || PermissionsEx.getUser(player).inGroup("Mod")) {
                player.teleport(new Location(Bukkit.getServer().getWorld("world"), yamlConfiguration.getInt("locations.mantaria.x"), yamlConfiguration.getInt("locations.mantaria.y"), yamlConfiguration.getInt("locations.mantaria.z")));
            }
        }

        if(player.getLocation().getBlockX() == 340 && player.getLocation().getBlockY() == 71 && player.getLocation().getBlockZ() == 910) {
            if(PermissionsEx.getUser(player).inGroup("nightclaw") || player.isOp() || PermissionsEx.getUser(player).inGroup("Mod")) {
                player.teleport(new Location(Bukkit.getServer().getWorld("world"), yamlConfiguration.getInt("locations.nightclaw.x"), yamlConfiguration.getInt("locations.nightclaw.y"), yamlConfiguration.getInt("locations.nightclaw.z")));
            }
        }
        if(player.getLocation().getBlockX() == 340 && player.getLocation().getBlockY() == 71 && player.getLocation().getBlockZ() == 911) {
            if(PermissionsEx.getUser(player).inGroup("nightclaw") || player.isOp() || PermissionsEx.getUser(player).inGroup("Mod")) {
                player.teleport(new Location(Bukkit.getServer().getWorld("world"), yamlConfiguration.getInt("locations.nightclaw.x"), yamlConfiguration.getInt("locations.nightclaw.y"), yamlConfiguration.getInt("locations.nightclaw.z")));
            }
        }

        if(player.getLocation().getBlockX() == 321 && player.getLocation().getBlockY() == 72 && player.getLocation().getBlockZ() == 914) {
            if(PermissionsEx.getUser(player).inGroup("aymaray") || player.isOp() || PermissionsEx.getUser(player).inGroup("Mod")) {
                player.teleport(new Location(Bukkit.getServer().getWorld("world"), yamlConfiguration.getInt("locations.aymaray.x"), yamlConfiguration.getInt("locations.aymaray.y"), yamlConfiguration.getInt("locations.aymaray.z")));
            }
        }
        if(player.getLocation().getBlockX() == 320 && player.getLocation().getBlockY() == 72 && player.getLocation().getBlockZ() == 914) {
            if(PermissionsEx.getUser(player).inGroup("aymaray") || player.isOp() || PermissionsEx.getUser(player).inGroup("Mod")) {
                player.teleport(new Location(Bukkit.getServer().getWorld("world"), yamlConfiguration.getInt("locations.aymaray.x"), yamlConfiguration.getInt("locations.aymaray.y"), yamlConfiguration.getInt("locations.aymaray.z")));
            }
        }

        if(player.getLocation().getBlockX() == 317 && player.getLocation().getBlockY() == 72 && player.getLocation().getBlockZ() == 911) {
            if(PermissionsEx.getUser(player).inGroup("narbo") || player.isOp() || PermissionsEx.getUser(player).inGroup("Mod")) {
                player.teleport(new Location(Bukkit.getServer().getWorld("world"), yamlConfiguration.getInt("locations.narbo.x"), yamlConfiguration.getInt("locations.narbo.y"), yamlConfiguration.getInt("locations.narbo.z")));
            }
        }
        if(player.getLocation().getBlockX() == 317 && player.getLocation().getBlockY() == 72 && player.getLocation().getBlockZ() == 910) {
            if(PermissionsEx.getUser(player).inGroup("narbo") || player.isOp() || PermissionsEx.getUser(player).inGroup("Mod")) {
                player.teleport(new Location(Bukkit.getServer().getWorld("world"), yamlConfiguration.getInt("locations.narbo.x"), yamlConfiguration.getInt("locations.narbo.y"), yamlConfiguration.getInt("locations.narbo.z")));
            }
        }


        if(player.isOp() || player.hasPermission("*")) {
            event.setCancelled(false);
            return;
        }
            if(player.hasPermission("freezed")) {
            event.setCancelled(true);
        }
    }
}
