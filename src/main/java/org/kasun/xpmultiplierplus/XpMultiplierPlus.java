package org.kasun.xpmultiplierplus;

import com.hakan.core.HCore;
import org.bukkit.plugin.java.JavaPlugin;


public final class XpMultiplierPlus extends JavaPlugin {

    static XpMultiplierPlus plugin;
    private MainManager mainManager;

    @Override
    public void onEnable() {
        plugin = this;
        mainManager = new MainManager();
        HCore.initialize(this);


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
