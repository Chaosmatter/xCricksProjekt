package de.chaosmatter.xcricksprojekt;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class PortalTeleporter {
    private final Projekt plugin;

    public PortalTeleporter(Projekt plugin, Player player) {
        this.plugin = plugin;

        Bukkit.getScheduler().runTaskTimer(this.plugin, () -> {
            if(player.getLocation().getBlockY() == 83) {
                //LightFall-Portal
                if(player.getLocation().getBlockZ() == -116) {
                    if(player.getLocation().getBlockX() == -114 || player.getLocation().getBlockX() == -113 || player.getLocation().getBlockX() == -112) {
                        //teleport to lightfall-spawnpoint
                        player.teleport(new Location(player.getLocation().getWorld(), 2741, 101, 3321, (float)66.5, (float)-10.8));
                        Bukkit.dispatchCommand((CommandSender)Bukkit.getConsoleSender(), "spawnpoint " + player.getName() + " 2741 101 3321");
                        Bukkit.dispatchCommand((CommandSender) Bukkit.getConsoleSender(), "team join Lightfall " + player.getName());
                        return;
                    }
                }

                //NightFall-Portal
                if(player.getLocation().getBlockX() == -122) {
                    if(player.getLocation().getBlockZ() == -112 || player.getLocation().getBlockZ() == -113 || player.getLocation().getBlockZ() == -114) {
                        //teleport to nightfall-spawnpoint
                        player.teleport(new Location(player.getLocation().getWorld(), -6012, 112, -4663, (float)-103.4, (float)1.2));
                        Bukkit.dispatchCommand((CommandSender)Bukkit.getConsoleSender(), "spawnpoint " + player.getName() + " -6012 112 -4663");
                        Bukkit.dispatchCommand((CommandSender) Bukkit.getConsoleSender(), "team join Nightfall " + player.getName());
                        return;
                    }
                }

                //GoldenFall-Portal
                if(player.getLocation().getBlockX() == -104) {
                    if(player.getLocation().getBlockZ() == -113 || player.getLocation().getBlockZ() == -112 ||player.getLocation().getBlockZ() == -111) {
                        //teleport to GoldenFall-Spawnpoint
                        player.teleport(new Location(player.getLocation().getWorld(), -2091, 159, -3345, (float)23.0, (float)15.0));
                        Bukkit.dispatchCommand((CommandSender)Bukkit.getConsoleSender(), "spawnpoint " + player.getName() + " -2091 159 -3345");
                        Bukkit.dispatchCommand((CommandSender) Bukkit.getConsoleSender(), "team join GoldenFall " + player.getName());
                        return;
                    }
                }
            }
        }, 200L, 200L);
    }
}
