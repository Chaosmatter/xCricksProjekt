package de.chaosmatter.xcricksprojekt;

import de.chaosmatter.xcricksprojekt.commands.*;
import de.chaosmatter.xcricksprojekt.listener.*;
import lombok.Getter;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scoreboard.ScoreboardManager;

import java.util.logging.Level;

public final class Projekt extends JavaPlugin {

    @Getter
    private final String prefix = "§b§lLightfall §8» ";
    @Getter
    private static Projekt instance;
    @Getter
    private Data data;
    @Getter
    private TablistManager tablistManager;
    @Getter
    private LiveCommand liveCommand;
    @Getter
    private VoteManager voteManager;
    @Getter
    private PlayerHelper playerHelper;
    @Override
    public void onEnable() {
        instance = this;
        data = new Data(this);
        tablistManager = new TablistManager(this);
        liveCommand = new LiveCommand(this);
        voteManager = new VoteManager(this);
        playerHelper = new PlayerHelper(this);
        // Plugin startup logic
        this.getLogger().setLevel(Level.ALL);
        this.getLogger().info("Plugin enabled succsesfully.");
        getCommand("setspawn").setExecutor(new SetSpawnCommand(this));
        getCommand("spawn").setExecutor(new SpawnCommand(this));
        getCommand("freeze").setExecutor(new FreezeCommand(this));
        getCommand("spectate").setExecutor(new SpecCommand(this));
        getCommand("spec").setExecutor(new SpecCommand(this));
        getCommand("stadt").setExecutor(new StadtCommand(this));
        getCommand("kick").setExecutor(new KickCommand(this));
        getCommand("ban").setExecutor(new BanCommand(this));
        getCommand("teleport").setExecutor(new TeleportCommand(this));
        getCommand("tp").setExecutor(new TeleportCommand(this));
        getCommand("unban").setExecutor(new UnbanCommand(this));
        getCommand("live").setExecutor(new LiveCommand(this));
        getCommand("vote").setExecutor(new VoteCommand(this));

        Bukkit.getPluginManager().registerEvents(new PlayerCommandPreprocessListener(this), this);
        Bukkit.getPluginManager().registerEvents(new PlayerJoinListener(this), this);
        Bukkit.getPluginManager().registerEvents(new PlayerMoveListener(this), this);
        Bukkit.getPluginManager().registerEvents(new PlayerChatListener(this), this);
        Bukkit.getPluginManager().registerEvents(new PlayerDeathListener(this), this);

        this.tablistManager.createScoreboard();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
