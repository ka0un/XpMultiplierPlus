package org.kasun.xpmultiplierplus.Runnables;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import org.kasun.xpmultiplierplus.Multiplier.Multiplier;
import org.kasun.xpmultiplierplus.Multiplier.MultiplierManager;
import org.kasun.xpmultiplierplus.XpMultiplierPlus;

import java.util.List;

public class PermissionCheckRunnable extends BukkitRunnable {

    private XpMultiplierPlus plugin;
    private List<Multiplier> multipliers;
    private MultiplierManager multiplierManager;

    public PermissionCheckRunnable(XpMultiplierPlus plugin) {
        this.plugin = plugin;

    }

    @Override
    public void run() {
        multipliers = plugin.getMainManager().getConfigManager().getMainConfig().multipliers;
        multiplierManager = plugin.getMainManager().getMultiplierManager();


        for (Player player : Bukkit.getOnlinePlayers()) {
            for (Multiplier m : multipliers) {
                if (player.hasPermission(m.getPermission())) {
                    multiplierManager.getMultipliers().put(player.getUniqueId(), m);
                    break;  // Exit the loop once a permission is found
                }
            }
        }
    }
}
