package org.kasun.xpmultiplierplus.Runnables;

import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import org.kasun.xpmultiplierplus.Multiplier.GlobalMultiplier;
import org.kasun.xpmultiplierplus.Multiplier.Multiplier;
import org.kasun.xpmultiplierplus.Multiplier.MultiplierManager;
import org.kasun.xpmultiplierplus.XpMultiplierPlus;

import java.util.HashMap;
import java.util.List;
import java.util.UUID;

public class DebugRunnable extends BukkitRunnable {
    private XpMultiplierPlus plugin;
    private HashMap<UUID, List<Multiplier>> multiplierMap;
    private MultiplierManager multiplierManager;
    public DebugRunnable(XpMultiplierPlus plugin) {
        this.plugin = plugin;
    }
    @Override
    public void run() {


        plugin.getMainManager().getMultiplierManager().getMultipliers();
        multiplierManager = plugin.getMainManager().getMultiplierManager();

        if (multiplierManager == null || plugin.getMainManager() == null){
            return;
        }

        if (multiplierMap == null){
           return;
        }

        for (UUID uuid : multiplierMap.keySet()) {
            plugin.getLogger().info("Multipliers: ========================");
            plugin.getLogger().info("Player: " + uuid.toString());
            for (Multiplier m : multiplierMap.get(uuid)) {
                plugin.getLogger().info("Permission: " + m.getPermission());
            }
            plugin.getLogger().info("=====================================");
        }

        if (multiplierManager.getGlobalMultipliers() == null){
            return;
        }

        //global multipliers
        plugin.getLogger().info("Global Multipliers: ========================");
        for (GlobalMultiplier m : multiplierManager.getGlobalMultipliers()) {
            plugin.getLogger().info("Multiplier: " + m.getMultiplier());
            plugin.getLogger().info("Duration : " + m.getDurationSecounds());
        }
        plugin.getLogger().info("=====================================");



    }
}
