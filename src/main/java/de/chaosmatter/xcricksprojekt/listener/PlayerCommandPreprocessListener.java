package de.chaosmatter.xcricksprojekt.listener;

import de.chaosmatter.xcricksprojekt.Projekt;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

public class PlayerCommandPreprocessListener implements Listener {
    private final Projekt plugin;

    public PlayerCommandPreprocessListener(Projekt plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void handlePlayerCommandPreprocess(PlayerCommandPreprocessEvent event) {
        if(event.getPlayer().isOp()) {
            event.setCancelled(false);
            return;
        }

        if(event.getMessage().equalsIgnoreCase("/pl") || event.getMessage().equalsIgnoreCase("/plugins") || event.getMessage().equalsIgnoreCase("/version") || event.getMessage().equalsIgnoreCase("/ver") || event.getMessage().equalsIgnoreCase("/help") || event.getMessage().equalsIgnoreCase("/?")) {
            event.setCancelled(true);
            return;
        }
    }
}
