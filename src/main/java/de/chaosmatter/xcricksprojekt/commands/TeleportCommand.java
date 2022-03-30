package de.chaosmatter.xcricksprojekt.commands;

import de.chaosmatter.xcricksprojekt.Projekt;
import org.apache.commons.lang.StringUtils;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import ru.tehkode.permissions.bukkit.PermissionsEx;

public class TeleportCommand implements CommandExecutor {
    private final Projekt plugin;

    public TeleportCommand(Projekt plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(command.getName().equalsIgnoreCase("teleport") || command.getName().equalsIgnoreCase("tp")) {
            if(sender instanceof Player) {
                Player player = (Player) sender;
                if(!PermissionsEx.getUser(player).inGroup("Mod") && !player.isOp()) {
                    player.sendMessage(this.plugin.getPrefix() + "§cUnzureichende Berechtigungen.");
                    return false;
                }
                if(args.length == 1) {
                    //teleport sender to another player
                    Player target = Bukkit.getPlayer(args[0]);
                    if(target != null) {
                        player.teleport(target.getLocation());
                        return false;
                    }
                    player.sendMessage(this.plugin.getPrefix() + "§cDieser Spieler ist nicht online/existiert nicht.");
                    return false;
                }
                if (args.length == 2) {
                    //teleport player to another player
                    Player targetX = Bukkit.getPlayer(args[0]);
                    Player targetY = Bukkit.getPlayer(args[1]);
                    if(targetY != null && targetX != null) {
                        targetX.teleport(targetY.getLocation());
                        player.sendMessage(this.plugin.getPrefix() + "§e" + targetX.getName() + " §7wurde zu §e" + targetY.getName() + " §7teleportiert.");
                        return false;
                    }
                    player.sendMessage(this.plugin.getPrefix() + "§cMindestens einer der Spieler ist nicht online/existiert nicht.");
                    return false;
                }
                if(args.length == 3) {
                    //player wants to teleport to cords
                    if(StringUtils.isNumeric(args[0]) && StringUtils.isNumeric(args[1]) && StringUtils.isNumeric(args[2])) {
                        int locationX = Integer.parseInt(args[0]);
                        int locationY = Integer.parseInt(args[1]);
                        int locationZ = Integer.parseInt(args[2]);
                        player.teleport(new Location(player.getWorld(), locationX, locationY, locationZ));
                        return false;
                    }
                    player.sendMessage(this.plugin.getPrefix() + "§cBitte gib Koordinaten an.");
                    return false;
                }
                if (args.length == 4) {
                    //player wants to teleport another player to cords
                    Player target = Bukkit.getPlayer(args[0]);
                    if(target != null) {
                        if(StringUtils.isNumeric(args[0]) && StringUtils.isNumeric(args[1]) && StringUtils.isNumeric(args[2])) {
                            int locationX = Integer.parseInt(args[1]);
                            int locationY = Integer.parseInt(args[2]);
                            int locationZ = Integer.parseInt(args[3]);
                            target.teleport(new Location(player.getWorld(), locationX, locationY, locationZ));
                            player.sendMessage(this.plugin.getPrefix() + "§e" + target.getName() + " §7wurde zu den angegebenen Koordinaten teleportiert.");
                            return false;
                        }
                        player.sendMessage(this.plugin.getPrefix() + "§cBitte gib Koordinaten an.");
                        return false;
                    }
                    player.sendMessage(this.plugin.getPrefix() + "§cDieser Spieler ist nicht online/existiert nicht.");
                    return false;
                }
                player.sendMessage(this.plugin.getPrefix() + "§cBitte nutze /teleport [Spieler] [Koordinaten] [<Spieler>].");
            }
        }
        return false;
    }
}
