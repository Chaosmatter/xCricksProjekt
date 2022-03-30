package de.chaosmatter.xcricksprojekt;

import lombok.SneakyThrows;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.Scoreboard;
import ru.tehkode.permissions.bukkit.PermissionsEx;

import java.io.File;

public class TablistManager {
    final private Projekt plugin;
    private final Scoreboard scoreboard;

    public TablistManager(Projekt plugin) {
        this.plugin = plugin;
        this.scoreboard = this.createScoreboard();
    }

    public Scoreboard createScoreboard() {
        Scoreboard scoreboard = Bukkit.getScoreboardManager().getNewScoreboard();

        scoreboard.registerNewTeam("01Lightfall");
        scoreboard.registerNewTeam("02Mantaria");
        scoreboard.registerNewTeam("03Nightclaw");
        scoreboard.registerNewTeam("04Aymaray");
        scoreboard.registerNewTeam("05Narbo");
        scoreboard.registerNewTeam("06Default");
        scoreboard.getTeam("01Lightfall").setPrefix("§b ");
        scoreboard.getTeam("02Mantaria").setPrefix("§a ");
        scoreboard.getTeam("03Nightclaw").setPrefix("§0 ");
        scoreboard.getTeam("04Aymaray").setPrefix("§6 ");
        scoreboard.getTeam("05Narbo").setPrefix("§3 ");
        scoreboard.getTeam("06Default").setPrefix("§f ");

        //Mod-Teams
        scoreboard.registerNewTeam("07LightfallMod");
        scoreboard.registerNewTeam("08MantariaMod");
        scoreboard.registerNewTeam("09NightclawMod");
        scoreboard.registerNewTeam("10AymarayMod");
        scoreboard.registerNewTeam("11NarboMod");
        scoreboard.registerNewTeam("12DefaultMod");
        scoreboard.getTeam("07LightfallMod").setPrefix("§b ");
        scoreboard.getTeam("08MantariaMod").setPrefix("§a ");
        scoreboard.getTeam("09NightclawMod").setPrefix("§0 ");
        scoreboard.getTeam("10AymarayMod").setPrefix("§6 ");
        scoreboard.getTeam("11NarboMod").setPrefix("§3 ");
        scoreboard.getTeam("12DefaultMod").setPrefix("§f ");
        scoreboard.getTeam("07LightfallMod").setSuffix("§7[§cMod§7]");
        scoreboard.getTeam("08MantariaMod").setSuffix("§7[§cMod§7]");
        scoreboard.getTeam("09NightclawMod").setSuffix("§7[§cMod§7]");
        scoreboard.getTeam("10AymarayMod").setSuffix("§7[§cMod§7]");
        scoreboard.getTeam("11NarboMod").setSuffix("§7[§cMod§7]");
        scoreboard.getTeam("12DefaultMod").setSuffix("§7[§cMod§7]");

        //Admin-Teams
        scoreboard.registerNewTeam("13LightfallAdmin");
        scoreboard.registerNewTeam("14MantariaAdmin");
        scoreboard.registerNewTeam("15NightclawAdmin");
        scoreboard.registerNewTeam("16AymarayAdmin");
        scoreboard.registerNewTeam("17NarboAdmin");
        scoreboard.registerNewTeam("18DefaultAdmin");
        scoreboard.getTeam("13LightfallAdmin").setPrefix("§b ");
        scoreboard.getTeam("14MantariaAdmin").setPrefix("§a ");
        scoreboard.getTeam("15NightclawAdmin").setPrefix("§0 ");
        scoreboard.getTeam("16AymarayAdmin").setPrefix("§6 ");
        scoreboard.getTeam("17NarboAdmin").setPrefix("§3 ");
        scoreboard.getTeam("18DefaultAdmin").setPrefix("§f ");
        scoreboard.getTeam("13LightfallAdmin").setSuffix("§7[§4Admin§7]");
        scoreboard.getTeam("14MantariaAdmin").setSuffix("§7[§4Admin§7]");
        scoreboard.getTeam("15NightclawAdmin").setSuffix("§7[§4Admin§7]");
        scoreboard.getTeam("16AymarayAdmin").setSuffix("§7[§4Admin§7]");
        scoreboard.getTeam("17NarboAdmin").setSuffix("§7[§4Admin§7]");
        scoreboard.getTeam("18DefaultAdmin").setSuffix("§7[§4Admin§7]");

        //live-teams
        scoreboard.registerNewTeam("19LightfallLive");
        scoreboard.registerNewTeam("20MantariaLive");
        scoreboard.registerNewTeam("21NightclawLive");
        scoreboard.registerNewTeam("22AymarayLive");
        scoreboard.registerNewTeam("23NarboLive");
        scoreboard.registerNewTeam("24DefaultLive");
        scoreboard.getTeam("19LightfallLive").setPrefix("§b ");
        scoreboard.getTeam("20MantariaLive").setPrefix("§a ");
        scoreboard.getTeam("21NightclawLive").setPrefix("§0 ");
        scoreboard.getTeam("22AymarayLive").setPrefix("§6 ");
        scoreboard.getTeam("23NarboLive").setPrefix("§3 ");
        scoreboard.getTeam("24DefaultLive").setPrefix("§f ");
        scoreboard.getTeam("19LightfallLive").setSuffix("§7[§5Live§7]");
        scoreboard.getTeam("20MantariaLive").setSuffix("§7[§5Live§7]");
        scoreboard.getTeam("21NightclawLive").setSuffix("§7[§5Live§7]");
        scoreboard.getTeam("22AymarayLive").setSuffix("§7[§5Live§7]");
        scoreboard.getTeam("23NarboLive").setSuffix("§7[§5Live§7]");
        scoreboard.getTeam("24DefaultLive").setSuffix("§7[§5Live§7]");
        return scoreboard;
    }

    @SneakyThrows
    public void updatePrefixes(final Player player) {
        String team = "";
        if(player == null) {
            return;
        }
        if(PermissionsEx.getUser(player).inGroup("lightfall")) {
            team = "01Lightfall";
            if(PermissionsEx.getUser(player).inGroup("Mod")) {
                team = "07LightfallMod";
            }
            if(player.isOp()) {
                team = "13LightfallAdmin";
            }
            if(this.plugin.getLiveCommand().isLive(player)) {
                team = "19LightfallLive";
            }
        }
        if(PermissionsEx.getUser(player).inGroup("mantaria")) {
            team = "02Mantaria";
            if(PermissionsEx.getUser(player).inGroup("Mod")) {
                team = "08MantariaMod";
            }
            if(player.isOp()) {
                team = "14MantariaAdmin";
            }
            if(this.plugin.getLiveCommand().isLive(player)) {
                team = "20MantariaLive";
            }
        }
        if(PermissionsEx.getUser(player).inGroup("nightclaw")) {
            team = "03Nightclaw";
            if(PermissionsEx.getUser(player).inGroup("Mod")) {
                team = "09NightclawMod";
            }
            if(player.isOp()) {
                team = "15NightclawAdmin";
            }
            if(this.plugin.getLiveCommand().isLive(player)) {
                team = "21NightclawLive";
            }
        }
        if(PermissionsEx.getUser(player).inGroup("aymaray")) {
            team = "04Aymaray";
            if(PermissionsEx.getUser(player).inGroup("Mod")) {
                team = "10AymarayMod";
            }
            if(player.isOp()) {
                team = "16AymarayAdmin";
            }
            if(this.plugin.getLiveCommand().isLive(player)) {
                team = "22AymarayLive";
            }
        }
        if(PermissionsEx.getUser(player).inGroup("narbo")) {
            team = "05Narbo";
            if(PermissionsEx.getUser(player).inGroup("Mod")) {
                team = "11NarboMod";
            }
            if(player.isOp()) {
                team = "17NarboAdmin";
            }
            if(this.plugin.getLiveCommand().isLive(player)) {
                team = "23NarboLive";
            }
        }
        if(PermissionsEx.getUser(player).inGroup("default")) {
            team = "06Default";
            if(PermissionsEx.getUser(player).inGroup("Mod")) {
                team = "12DefaultMod";
            }
            if(player.isOp()) {
                team = "18DefaultAdmin";
            }
            if(this.plugin.getLiveCommand().isLive(player)) {
                team = "24DefaultLive";
            }
        }
        scoreboard.getTeam(team).addPlayer(player);
        for (final Player all : Bukkit.getServer().getOnlinePlayers()) {
            all.setScoreboard(this.scoreboard);
        }
    }
}
