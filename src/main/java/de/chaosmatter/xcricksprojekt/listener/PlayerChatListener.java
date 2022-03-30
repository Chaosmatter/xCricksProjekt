package de.chaosmatter.xcricksprojekt.listener;

import de.chaosmatter.xcricksprojekt.Projekt;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import ru.tehkode.permissions.bukkit.PermissionsEx;

public class PlayerChatListener implements Listener {
    private final Projekt plugin;

    public PlayerChatListener(Projekt plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void handlePlayerChat(AsyncPlayerChatEvent event) {
        Player player = event.getPlayer();
        if(PermissionsEx.getUser(player).getGroups().length == 1 && PermissionsEx.getUser(player).inGroup("default")) {
            event.setCancelled(false);
            return;
        }
        if(event.getMessage().startsWith("@all")) {
            if(PermissionsEx.getUser(player).inGroup("lightfall")) {
                event.setFormat("§8[§e@all§8] §b" + player.getName() + " §7» §f" + event.getMessage().replace("@all", ""));
            }
            if(PermissionsEx.getUser(player).inGroup("mantaria")) {
                event.setFormat("§8[§e@all§8] §a" + player.getName() + " §7» §f" + event.getMessage().replace("@all", ""));
            }
            if(PermissionsEx.getUser(player).inGroup("nightclaw")) {
                event.setFormat("§8[§e@all§8] §0" + player.getName() + " §7» §f" + event.getMessage().replace("@all", ""));
            }
            if(PermissionsEx.getUser(player).inGroup("aymaray")) {
                event.setFormat("§8[§e@all§8] §6" + " §7» §f" + event.getMessage().replace("@all", ""));
            }
            if(PermissionsEx.getUser(player).inGroup("narbo")) {
                event.setFormat("§8[§e@all§8] §3" + player.getName() + " §7» §f" + event.getMessage().replace("@all", ""));
            }
            return;
        }
        if(event.getMessage().startsWith("@a")) {
            if(PermissionsEx.getUser(player).inGroup("lightfall")) {
                event.setFormat("§8[§e@all§8] §b" + player.getName() + " §7» §f" + event.getMessage().replace("@a", ""));
            }
            if(PermissionsEx.getUser(player).inGroup("mantaria")) {
                event.setFormat("§8[§e@all§8] §a" + player.getName() + " §7» §f" + event.getMessage().replace("@a", ""));
            }
            if(PermissionsEx.getUser(player).inGroup("nightclaw")) {
                event.setFormat("§8[§e@all§8] §0" + player.getName() + " §7» §f" + event.getMessage().replace("@a", ""));
            }
            if(PermissionsEx.getUser(player).inGroup("aymaray")) {
                event.setFormat("§8[§e@all§8] §6" + player.getName() + " §7» §f" + event.getMessage().replace("@a", ""));
            }
            if(PermissionsEx.getUser(player).inGroup("narbo")) {
                event.setFormat("§8[§e@all§8] §3"+ player.getName() + " §7» §f" + event.getMessage().replace("@a", ""));
            }
            return;
        }
        event.setCancelled(true);
        if(PermissionsEx.getUser(player).inGroup("lightfall")) {
            for(Player all : Bukkit.getServer().getOnlinePlayers()) {
                if (PermissionsEx.getUser(all).inGroup("lightfall")) {
                        all.sendMessage("§8[§e@team§8] §b" + player.getName() + " §7» §f" + event.getMessage());
                    return;
                }
            }
        }
        if(PermissionsEx.getUser(player).inGroup("mantaria")) {
            for(Player all : Bukkit.getServer().getOnlinePlayers()) {
                if (PermissionsEx.getUser(all).inGroup("mantaria")) {
                    all.sendMessage("§8[§e@team§8] §a" + player.getName() + " §7» §f" + event.getMessage());
                    return;
                }
            }        }
        if(PermissionsEx.getUser(player).inGroup("nightclaw")) {
            for(Player all : Bukkit.getServer().getOnlinePlayers()) {
                event.setCancelled(true);
                if (PermissionsEx.getUser(all).inGroup("nightclaw")) {
                    all.sendMessage("§8[§e@team§8] §0" + player.getName() + " §7» §f" + event.getMessage());
                    return;
                }
            }
        }
        if(PermissionsEx.getUser(player).inGroup("aymaray")) {
            for(Player all : Bukkit.getServer().getOnlinePlayers()) {
                if (PermissionsEx.getUser(all).inGroup("aymaray")) {
                    all.sendMessage("§8[§e@team§8] §6" + player.getName() + " §7» §f" + event.getMessage());
                    return;
                }
            }
        }
        if(PermissionsEx.getUser(player).inGroup("narbo")) {
            for(Player all : Bukkit.getServer().getOnlinePlayers()) {
                if (PermissionsEx.getUser(all).inGroup("narbo")) {
                    all.sendMessage("§8[§e@team§8] §3" + player.getName() + " §7» §f" + event.getMessage());
                    return;
                }
            }
        }
    }
}
