package org.kasun.xpmultiplierplus.utils;

import org.bukkit.Color;
import org.kasun.xpmultiplierplus.Config.ConfigManager;
import org.kasun.xpmultiplierplus.Config.MainConfig;
import org.kasun.xpmultiplierplus.XpMultiplierPlus;

public class StartupManager {
    ConfigManager configManager;
    XpMultiplierPlus plugin = XpMultiplierPlus.getInstance();
    MainConfig mainConfig;
    public StartupManager(ConfigManager configManager) {
        this.configManager = configManager;
        mainConfig = configManager.getMainConfig();
        sendStartupMessage();
    }

    public void sendStartupMessage() {
        plugin.getLogger().info(ColorUtils.color(" "));
        plugin.getLogger().info(ColorUtils.color( mainConfig.langMap.get("startup-message-1").replace("%version%", plugin.getDescription().getVersion())));
        plugin.getLogger().info(ColorUtils.color( mainConfig.langMap.get("startup-message-2").replace("%author%", plugin.getDescription().getAuthors().toString())));
        plugin.getLogger().info(ColorUtils.color( mainConfig.langMap.get("startup-message-3").replace("%website%", plugin.getDescription().getWebsite())));
        plugin.getLogger().info(ColorUtils.color(" "));
    }
}
