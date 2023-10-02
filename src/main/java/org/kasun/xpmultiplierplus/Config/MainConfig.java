package org.kasun.xpmultiplierplus.Config;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.kasun.xpmultiplierplus.Multiplier.Multiplier;
import org.kasun.xpmultiplierplus.XpMultiplierPlus;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class MainConfig {
    public List<Multiplier> multipliers;
    XpMultiplierPlus plugin = XpMultiplierPlus.getInstance();
    private File configFile;
    private FileConfiguration config;


    public MainConfig() {
        plugin.getConfig().options().copyDefaults();
        plugin.saveDefaultConfig();
        configFile = new File(plugin.getDataFolder(), "config.yml");
        config = YamlConfiguration.loadConfiguration(configFile);
        loadMultipliers();
    }

    public void loadMultipliers(){
        multipliers = new ArrayList<>();

        for (String key : config.getConfigurationSection("multipliers").getKeys(false)) {
            double multiplier = config.getDouble("multipliers." + key + ".multiplier");
            String permission = config.getString("multipliers." + key + ".permission");
            Multiplier m = new Multiplier(multiplier, permission);
            multipliers.add(m);
        }

        //gotta change the order of the multipliers to make sure the highest multiplier is first
        multipliers.sort((o1, o2) -> {
            if (o1.getMultiplier() > o2.getMultiplier()) {
                return -1;
            } else if (o1.getMultiplier() < o2.getMultiplier()) {
                return 1;
            } else {
                return 0;
            }
        });
    }
}
