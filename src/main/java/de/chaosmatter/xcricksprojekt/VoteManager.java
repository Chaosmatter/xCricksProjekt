package de.chaosmatter.xcricksprojekt;

import com.avaje.ebean.validation.NotNull;
import org.bukkit.Bukkit;
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
    public HashMap<UUID, Integer> candidates = new HashMap<>();

    public Player stopVote(String stadt) {
        int max = Collections.max(this.loadHashMap(stadt).values());
        List<UUID> keys = new ArrayList<>();
        for (Map.Entry<UUID, Integer> entry : this.loadHashMap(stadt).entrySet()) {
            if (entry.getValue()==max) {
                keys.add(entry.getKey());
            }
        }

        Player player = Bukkit.getPlayer(keys.get(0));

        File file = new File("plugins/Projekt/" + stadt + ".yml");
        file.delete();

        return player;
    }

    public void startVote(String stadt, Player candidate) {
        System.out.println("1");
        this.candidates.put(candidate.getUniqueId(), 1);
        System.out.println("2");
        try {
            this.getVoteFile(stadt).save(new File("plugins/Projekt/" + stadt + ".yml"));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        System.out.println("3");
        this.saveHashMap(this.candidates, this.plugin.getPlayerHelper().getStadt(candidate.getUniqueId()));
        try {
            YamlConfiguration yamlConfiguration1 = YamlConfiguration.loadConfiguration(new File("plugins/Projekt/" + stadt + "yml"));
            yamlConfiguration1.save(new File("plugins/Projekt/" + stadt + ".yml"));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        System.out.println("4");
        this.candidates.remove(candidate.getUniqueId());
        System.out.println("5");
    }

    public void setPlayerRun(UUID uuid) {
        if(this.loadHashMap(this.plugin.getPlayerHelper().getStadt(uuid)) == null) {
            this.candidates.put(uuid, 1);
            this.saveHashMap(this.candidates, this.plugin.getPlayerHelper().getStadt(uuid));
            return;
        }
        this.loadHashMap(this.plugin.getPlayerHelper().getStadt(uuid)).put(uuid, this.loadHashMap(this.plugin.getPlayerHelper().getStadt(uuid)).get(uuid) + 1);
        this.saveHashMap(this.candidates, this.plugin.getPlayerHelper().getStadt(uuid));
    }

    public void votePlayer(UUID uuid) {
        this.loadHashMap(this.plugin.getPlayerHelper().getStadt(uuid)).put(uuid, this.loadHashMap(this.plugin.getPlayerHelper().getStadt(uuid)).get(uuid) + 1);
    }

    public void setPlayerVoted(UUID uuid) {
        String playersVoted = this.getVoteFile(this.plugin.getPlayerHelper().getStadt(uuid)).getString("playersVoted");
        if(playersVoted == null) {
            this.getVoteFile(this.plugin.getPlayerHelper().getStadt(uuid)).set("playersVoted", uuid.toString());
            return;
        }
        this.getVoteFile(this.plugin.getPlayerHelper().getStadt(uuid)).set("playersVoted", playersVoted + ", " + uuid.toString());
    }

    public void saveHashMap(HashMap<UUID, Integer> candidates, String stadt) {
        for (Object key : candidates.keySet()) {
            System.out.println("6");
            this.getVoteFile(stadt).set("HashMap." + key, candidates.get(key));
            System.out.println("7");
        }
        try {
            this.getVoteFile(stadt).save(new File("plugins/Projekt/" + stadt + ".yml"));
            System.out.println("8");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public HashMap<UUID, Integer> loadHashMap(String stadt) {
        HashMap<UUID, Integer> candidates = new HashMap<UUID, Integer>();

        for (String key : this.getVoteFile(stadt).getConfigurationSection("HashMap").getKeys(false)) {
            candidates.put(UUID.fromString(key), this.getVoteFile(stadt).getInt("HashMap."+key));
        }

        return candidates;
    }


        public boolean hasVoted(UUID uuid) {
        YamlConfiguration yamlConfiguration = YamlConfiguration.loadConfiguration(new File(this.plugin.getPlayerHelper().getStadt(uuid) + ".yml"));
        if(yamlConfiguration.getString("hasVoted") == null) {
            return false;
        }
        if(yamlConfiguration.getString("hasVoted").contains(uuid.toString())) {
            return true;
        }
        return false;
    }

    public YamlConfiguration getVoteFile(String stadt) {
        return YamlConfiguration.loadConfiguration(new File("plugins/Projekt/" + stadt + ".yml"));
    }

    public boolean isVoteActive(String stadt) {
        File file = new File(stadt + ".yml");
        if(file.exists()) {
            return true;
        }
        return false;
    }
}
