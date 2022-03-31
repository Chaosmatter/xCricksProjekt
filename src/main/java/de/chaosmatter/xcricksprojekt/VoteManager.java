package de.chaosmatter.xcricksprojekt;

import com.avaje.ebean.validation.NotNull;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import javax.annotation.CheckForNull;
import java.io.File;
import java.io.IOException;
import java.util.*;

public class VoteManager {
    private final Projekt plugin;

    public VoteManager(Projekt plugin) {
        this.plugin = plugin;
    }

    public void stopVote(String stadt) {

        File file = new File("plugins/Projekt/" + stadt + ".yml");
        file.delete();

    }

    public void startVote(String stadt, Player candidate) {

        Map<UUID, Integer> map = new HashMap<UUID, Integer>();
        map.put(candidate.getUniqueId(), 1);
        this.setPlayerVoted(candidate.getUniqueId());
        map.keySet().forEach(key -> this.plugin.getConfig().set("votes." + stadt + "." + key, map.get(map)));
        this.plugin.saveConfig();
    }

    public void setPlayerRun(UUID uuid) {
        HashMap<UUID, Integer> map = new HashMap<UUID, Integer>();
    }

    public void votePlayer(UUID uuid) {

    }

    public void setPlayerVoted(UUID uuid) {
        String playersVoted = this.plugin.getConfig().getString("playersvoted." + this.plugin.getPlayerHelper().getStadt(uuid));
        if(playersVoted == null) {
            this.plugin.getConfig().set("playersVoted." + this.plugin.getPlayerHelper().getStadt(uuid), uuid.toString());
            return;
        } else {
            this.plugin.getConfig().set("playersVoted.", playersVoted + ", " + uuid.toString());
        }
            this.plugin.saveConfig();
    }





        public boolean hasVoted(UUID uuid) {
        if(this.plugin.getConfig().getString("hasVoted." + this.plugin.getPlayerHelper().getStadt(uuid)) == null) {
            return false;
        }
        if(this.plugin.getConfig().getString("hasVoted." + this.plugin.getPlayerHelper().getStadt(uuid)).contains(uuid.toString())) {
            return true;
        }
        return false;
    }

    public boolean isVoteActive(String stadt) {
        if(this.plugin.getConfig().getString("playersVoted." + stadt) != null) {
            return true;
        }
        return false;
    }
}
