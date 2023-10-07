package org.kasun.xpmultiplierplus.Utils;

import org.bukkit.Color;
import org.bukkit.command.ConsoleCommandSender;
import org.kasun.xpmultiplierplus.Config.ConfigManager;
import org.kasun.xpmultiplierplus.Config.MainConfig;
import org.kasun.xpmultiplierplus.XpMultiplierPlus;

public class StartupManager {
    ConfigManager configManager;
    XpMultiplierPlus plugin = XpMultiplierPlus.getInstance();
    MainConfig mainConfig;
    OutdatedReminder outdatedReminder;
    public StartupManager(ConfigManager configManager, OutdatedReminder outdatedReminder) {
        this.configManager = configManager;
        mainConfig = configManager.getMainConfig();
        this.outdatedReminder = outdatedReminder;
        sendStartupMessage();
    }

    public void sendStartupMessage() {
        ConsoleCommandSender console = plugin.getServer().getConsoleSender();
        console.sendMessage(ColorUtils.color(" "));
        console.sendMessage(ColorUtils.color( mainConfig.langMap.get("startup-message-1").replace("%version%", plugin.getDescription().getVersion())));
        console.sendMessage(ColorUtils.color( mainConfig.langMap.get("startup-message-2").replace("%author%", plugin.getDescription().getAuthors().toString())));
        console.sendMessage(ColorUtils.color( mainConfig.langMap.get("startup-message-3").replace("%website%", plugin.getDescription().getWebsite())));
        console.sendMessage(ColorUtils.color(" "));
        UpdateChecker updateChecker = new UpdateChecker(plugin, "https://raw.githubusercontent.com/ka0un/dashboard/main/xpm/version.txt", plugin.getDescription().getVersion(), outdatedReminder);
    }
}
