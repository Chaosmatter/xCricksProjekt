package de.chaosmatter.xcricksprojekt.commands;

import de.chaosmatter.xcricksprojekt.Projekt;
import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import ru.tehkode.permissions.bukkit.PermissionsEx;

import java.io.File;
import java.util.HashMap;
import java.util.UUID;

public class VoteCommand implements CommandExecutor {
    private final Projekt plugin;

    public VoteCommand(Projekt plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(command.getName().equalsIgnoreCase("vote")) {
            if(sender instanceof Player) {
                Player player = (Player) sender;

                if(args.length == 1) {
                    if(args[0].equalsIgnoreCase("run")) {
                        if(this.plugin.getVoteManager().hasVoted(player.getUniqueId())) {
                            player.sendMessage(this.plugin.getPrefix() + "§cDu hast bereits abgestimmt und kannst dich daher nicht mehr zur Wahl stellen. Versuche es bei der nächsten Wahl.");
                            return false;
                        }
                        this.plugin.getVoteManager().setPlayerRun(player.getUniqueId());
                        this.plugin.getVoteManager().setPlayerVoted(player.getUniqueId());
                        player.sendMessage(this.plugin.getPrefix() + "§aDu hast dich erfolgreich zur Wahl gestellt und dich automatisch selbst gewählt.");
                        return false;
                    }
                    player.sendMessage(this.plugin.getPrefix() + "§cBitte nutze /vote <start/stop> <Stadt>.");
                    return false;
                }

                if(args.length == 3) {
                    if (player.hasPermission("projekt.startvote")) {
                        if(this.plugin.getVoteManager().isVoteActive(args[1])) {
                            player.sendMessage(this.plugin.getPrefix() + "§cFür diese Stadt sind bereits Wahlen aktiv!");
                        }
                        if (args[0].equalsIgnoreCase("start")) {
                            Player candidate = Bukkit.getPlayer(args[2]);
                            if(candidate == null) {
                                player.sendMessage(this.plugin.getPrefix() + "§cDieser Spieler ist nicht online.");
                                return false;
                            }
                            if(!(args[1].equalsIgnoreCase("lightfall") || args[1].equalsIgnoreCase("aymaray") || args[1].equalsIgnoreCase("mantaria") || args[1].equalsIgnoreCase("nightclaw") || args[1].equalsIgnoreCase("narbo"))) {
                                player.sendMessage(this.plugin.getPrefix() + "§cDiese Stadt existiert nicht.");
                                return false;
                            }
                            this.plugin.getVoteManager().startVote(args[1], candidate);
                            player.sendMessage(this.plugin.getPrefix() + "§eDu hast die Wahlen für " + args[1] + " gestartet!");
                            HashMap<UUID, Integer> map = new HashMap<UUID, Integer>();
                            map.put(player.getUniqueId(), 1);
                            map.keySet().forEach(uuid -> this.plugin.getConfig().set("mutes." + uuid, map.get(map)));
                            for (Player all : Bukkit.getServer().getOnlinePlayers()) {
                                if (PermissionsEx.getUser(all).inGroup(args[1].toLowerCase())) {
                                    all.sendMessage(this.plugin.getPrefix() + "Die Wahlen für " + args[1] + " wurden gestartet! Nutze /vote run um dich zur Wahl zu stellen, und /vote, um Personen zu wählen!");
                                }
                            }
                            return false;
                        }
                        if (args[0].equalsIgnoreCase("stop")) {
                            if(!this.plugin.getVoteManager().isVoteActive(args[1])) {
                                player.sendMessage(this.plugin.getPrefix() + "§cFür diese Stadt ist aktuell keine Wahl aktiv!");
                                return false;
                            }
                            //Player winner = this.plugin.getVoteManager().stopVote(args[1]);
                            //if(!PermissionsEx.getUser(winner).inGroup("bürgermeister")) {
                              //  PermissionsEx.getUser(winner).addGroup("bürgermeister");
                                ////todo remove old Bürgermeister from config.yml
                          //  }
                            for (Player all : Bukkit.getServer().getOnlinePlayers()) {
                                if (PermissionsEx.getUser(all).inGroup(args[1].toLowerCase())) {
                                   // all.sendMessage(this.plugin.getPrefix() + "§e" + winner.getName() + " §7wurde zum Bürgermeister gewählt!");
                                }
                            }
                            return false;
                        }
                        player.sendMessage(this.plugin.getPrefix() + "§cBitte nutze /vote <start/stop> <Stadt>.");
                        return false;
                    }
                    player.sendMessage(this.plugin.getPrefix() + "§cUnzureichende Berechtigungen.");
                    return false;
                }
                player.sendMessage(this.plugin.getPrefix() + "§cBitte nutze /vote <start/stop> <Stadt>.");
                return false;
            }
            sender.sendMessage("Must be a player.");
        }
        return false;
    }
}
