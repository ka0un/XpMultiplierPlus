package org.kasun.xpmultiplierplus.Config;

import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.kasun.xpmultiplierplus.Multiplier.Multiplier;
import org.kasun.xpmultiplierplus.XpMultiplierPlus;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainConfig {
    public List<Multiplier> multipliers;
    public String lang;
    XpMultiplierPlus plugin = XpMultiplierPlus.getInstance();
    private File configFile;
    private FileConfiguration config;
    public HashMap<String, String> langMap = new HashMap<>();
    public double defaultMultiplier;
    public int debugPeriod;
    public boolean debugEnabled;


    public MainConfig() {
        plugin.getConfig().options().copyDefaults();
        plugin.saveDefaultConfig();
        configFile = new File(plugin.getDataFolder(), "config.yml");
        config = YamlConfiguration.loadConfiguration(configFile);
        loadLang();
        loadMultipliers();
        loadMainSettings();
        loadDebugSettings();
    }

    public void loadDebugSettings(){
        ConfigurationSection debugSection = config.getConfigurationSection("debug-settings");
        debugEnabled = debugSection.getBoolean("debug");
        debugPeriod = debugSection.getInt("debug-period");
    }
    public void loadMainSettings(){
        ConfigurationSection mainSection = config.getConfigurationSection("main-settings");
        defaultMultiplier = mainSection.getDouble("default-multiplier");
    }

    public void loadLang(){
        lang = config.getString("lang");
        File langFile = new File(plugin.getDataFolder(), "/lang/" + lang + ".yml");
        FileConfiguration langConfig = YamlConfiguration.loadConfiguration(langFile);
        for (String key : langConfig.getConfigurationSection("lang").getKeys(false)) {
            String value = langConfig.getString("lang." + key);
            langMap.put(key, value);
        }
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
