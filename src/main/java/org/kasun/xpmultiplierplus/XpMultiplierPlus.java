package org.kasun.xpmultiplierplus;

import org.bukkit.plugin.java.JavaPlugin;

public final class XpMultiplierPlus extends JavaPlugin {

    static XpMultiplierPlus plugin;
    private MainManager mainManager;

    @Override
    public void onEnable() {
        plugin = this;
        mainManager = new MainManager();


    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public static XpMultiplierPlus getInstance() {
        return plugin;
    }

    public MainManager getMainManager() {
        return mainManager;
    }
}
