package de.chaosmatter.xcricksprojekt;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import ru.tehkode.permissions.bukkit.PermissionsEx;

import java.util.UUID;

public class PlayerHelper {
    private final Projekt plugin;

    public PlayerHelper(Projekt plugin) {
        this.plugin = plugin;
    }

    public String getStadt(UUID uuid) {
        if(PermissionsEx.getUser(Bukkit.getPlayer(uuid)).inGroup("lightfall")) {
            return "lightfall";
        }
        if(PermissionsEx.getUser(Bukkit.getPlayer(uuid)).inGroup("mantaria")) {
            return "mantaria";
        }
        if(PermissionsEx.getUser(Bukkit.getPlayer(uuid)).inGroup("aymaray")) {
            return "aymaray";
        }
        if(PermissionsEx.getUser(Bukkit.getPlayer(uuid)).inGroup("nightclaw")) {
            return "nightclaw";
        }if(PermissionsEx.getUser(Bukkit.getPlayer(uuid)).inGroup("narbo")) {
            return "narbo";
        }
        return null;
    }
}
