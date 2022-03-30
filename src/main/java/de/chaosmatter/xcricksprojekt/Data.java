package de.chaosmatter.xcricksprojekt;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;
import java.util.List;

@lombok.Data
public class Data {
    private Projekt plugin;

    public Data(Projekt plugin) {
        this.plugin = plugin;

        new File("plugins/Projekt").mkdir();
        YamlConfiguration yamlConfiguration = YamlConfiguration.loadConfiguration(new File("plugins/Projekt/config.yml"));

        yamlConfiguration.addDefault("locations.spawn.x", 1);
        yamlConfiguration.addDefault("locations.spawn.y", 1);
        yamlConfiguration.addDefault("locations.spawn.z", 1);

        yamlConfiguration.addDefault("locations.lightfall.x", 1);
        yamlConfiguration.addDefault("locations.lightfall.y", 1);
        yamlConfiguration.addDefault("locations.lightfall.z", 1);

        yamlConfiguration.addDefault("locations.mantaria.x", 1);
        yamlConfiguration.addDefault("locations.mantaria.y", 1);
        yamlConfiguration.addDefault("locations.mantaria.z", 1);

        yamlConfiguration.addDefault("locations.nightclaw.x", 1);
        yamlConfiguration.addDefault("locations.nightclaw.y", 1);
        yamlConfiguration.addDefault("locations.nightclaw.z", 1);

        yamlConfiguration.addDefault("locations.aymaray.x", 1);
        yamlConfiguration.addDefault("locations.aymaray.y", 1);
        yamlConfiguration.addDefault("locations.aymaray.z", 1);

        yamlConfiguration.addDefault("locations.narbo.x", 1);
        yamlConfiguration.addDefault("locations.narbo.y", 1);
        yamlConfiguration.addDefault("locations.narbo.z", 1);

        yamlConfiguration.addDefault("players.lightfall", null);
        yamlConfiguration.addDefault("players.mantaria", null);
        yamlConfiguration.addDefault("players.nightclaw", null);
        yamlConfiguration.addDefault("players.aymaray", null);
        yamlConfiguration.addDefault("players.narbo", null);
        yamlConfiguration.addDefault("freezedplayers", null);

        yamlConfiguration.options().copyDefaults(true);
        try {
            yamlConfiguration.save(new File("plugins/Projekt/config.yml"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        this.spawnLocationX = yamlConfiguration.getInt("locations.spawn.x");
        this.spawnLocationY = yamlConfiguration.getInt("locations.spawn.y");
        this.spawnLocationZ = yamlConfiguration.getInt("locations.spawn.z");

        this.lightfallLocationX = yamlConfiguration.getInt("locations.lightfall.x");
        this.lightfallLocationY = yamlConfiguration.getInt("locations.lightfall.y");
        this.lightfallLocationZ = yamlConfiguration.getInt("locations.lightfall.z");

        this.mantariaLocationX = yamlConfiguration.getInt("locations.mantaria.x");
        this.mantariaLocationY = yamlConfiguration.getInt("locations.mantaria.y");
        this.mantariaLocationZ = yamlConfiguration.getInt("locations.mantaria.z");

        this.nightclawLocationX = yamlConfiguration.getInt("locations.nightclaw.x");
        this.nightclawLocationY = yamlConfiguration.getInt("locations.nightclaw.y");
        this.nightclawLocationZ = yamlConfiguration.getInt("locations.nightclaw.z");

        this.aymarayLocationX = yamlConfiguration.getInt("locations.aymaray.x");
        this.aymarayLocationY = yamlConfiguration.getInt("locations.aymaray.y");
        this.aymarayLocationZ = yamlConfiguration.getInt("locations.aymaray.z");

        this.narboLocationX = yamlConfiguration.getInt("locations.narbo.x");
        this.narboLocationX = yamlConfiguration.getInt("locations.narbo.y");
        this.narboLocationX = yamlConfiguration.getInt("locations.narbo.z");

        this.lightfallPlayers = yamlConfiguration.getList("players.lightfall");
        this.mantariaPlayers = yamlConfiguration.getList("players.mantaria");
        this.nightclawPlayers = yamlConfiguration.getList("players.nightclaw");
        this.aymarayPlayers = yamlConfiguration.getList("players.aymaray");
        this.narboPlayers = yamlConfiguration.getList("players.narbo");

        this.freezedPlayers = yamlConfiguration.getList("freezedplayers");

    }

    private String prefix = "§9§lSkyWars §8» §7";

    private int spawnLocationX;
    private int spawnLocationY;
    private int spawnLocationZ;

    private int lightfallLocationX;
    private int lightfallLocationY;
    private int lightfallLocationZ;

    private int mantariaLocationX;
    private int mantariaLocationY;
    private int mantariaLocationZ;

    private int nightclawLocationX;
    private int nightclawLocationY;
    private int nightclawLocationZ;

    private int aymarayLocationX;
    private int aymarayLocationY;
    private int aymarayLocationZ;

    private int narboLocationX;
    private int narboLocationY;
    private int narboLocationZ;

    private List lightfallPlayers;
    private List mantariaPlayers;
    private List nightclawPlayers;
    private List aymarayPlayers;
    private List narboPlayers;

    private List freezedPlayers;


    public void updateConfig(YamlConfiguration yamlConfiguration) {
        try {
            yamlConfiguration.save(new File("plugins/Projekt/config.yml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
