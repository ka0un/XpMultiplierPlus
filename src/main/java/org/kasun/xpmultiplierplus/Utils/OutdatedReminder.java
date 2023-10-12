package org.kasun.xpmultiplierplus.Utils;

import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import org.kasun.xpmultiplierplus.Config.ConfigManager;
import org.kasun.xpmultiplierplus.Config.MainConfig;
import org.kasun.xpmultiplierplus.XpMultiplierPlus;

public class OutdatedReminder {
    private boolean outdated = false;
    XpMultiplierPlus plugin = XpMultiplierPlus.getInstance();
    MainConfig mainConfig;
    ConfigManager configManager;
    public OutdatedReminder(ConfigManager configManager) {
        mainConfig = configManager.getMainConfig();

    }

    public void remind(Player player) {
        if (isOutdated()) {
            new BukkitRunnable() {
                @Override
                public void run() {
                    player.sendMessage(ColorUtils.color(" "));
                    player.sendMessage(ColorUtils.color("&6&lXpMultiplierPlus is outdated!"));
                    player.sendMessage(ColorUtils.color(" "));
                    player.sendMessage(ColorUtils.color("&fDownload the latest version for"));
                    player.sendMessage(ColorUtils.color("&fnew Features and BugFixes!"));
                    player.sendMessage(ColorUtils.color(" "));
                    player.sendMessage(ColorUtils.color("&ehttps://ka0un.github.io/xpm/"));
                    player.sendMessage(ColorUtils.color(" "));
                    player.playSound(player.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1, 1);
                }
            }.runTaskLater(plugin, 5*20);
        }
    }

    public boolean isOutdated() {
        return outdated;
    }

    public void setOutdated(boolean outdated) {
        this.outdated = outdated;
    }
}
