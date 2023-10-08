package org.kasun.xpmultiplierplus.Runnables;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import org.kasun.xpmultiplierplus.Multiplier.Multiplier;
import org.kasun.xpmultiplierplus.Multiplier.MultiplierManager;
import org.kasun.xpmultiplierplus.Multiplier.TempMultiplier;
import org.kasun.xpmultiplierplus.XpMultiplierPlus;

import java.util.HashMap;
import java.util.List;
import java.util.UUID;

public class PermissionCheckRunnable extends BukkitRunnable {

    private XpMultiplierPlus plugin;
    private List<Multiplier> multipliers;
    private MultiplierManager multiplierManager;
    private HashMap<UUID, String> tempPermissionMap;

    public PermissionCheckRunnable(XpMultiplierPlus plugin) {
        this.plugin = plugin;
        tempPermissionMap = new HashMap<>();

    }

    @Override
    public void run() {
        multipliers = plugin.getMainManager().getConfigManager().getMainConfig().multipliers;
        multiplierManager = plugin.getMainManager().getMultiplierManager();

        // if player has perms added him a multiplier
        for (Player player : Bukkit.getOnlinePlayers()) {

            if (player.isOp()){
                continue;
            }

            for (Multiplier m : multipliers) {
                if (player.hasPermission(m.getPermission())) {
                    multiplierManager.getMultipliers().put(player.getUniqueId(), m);
                    tempPermissionMap.put(player.getUniqueId(), m.getPermission());
                    break;  // Exit the loop once a permission is found
                }
            }
        }

        //if player doesnt have perms removes his multiplier
        for (UUID uuid : tempPermissionMap.keySet()) {
            if (!(Bukkit.getPlayer(uuid) == null)) {
                if (!(Bukkit.getPlayer(uuid).hasPermission(tempPermissionMap.get(uuid)))) {
                    multiplierManager.getMultipliers().remove(uuid);
                    tempPermissionMap.remove(uuid);
                }
            }
        }

        //if temp multiplier outdated removes it
        for (UUID uuid : multiplierManager.getMultipliers().keySet()) {
            if (multiplierManager.getMultipliers().get(uuid) instanceof TempMultiplier) {
                if (((TempMultiplier) multiplierManager.getMultipliers().get(uuid)).getStartTime() != null) {
                    if (((TempMultiplier) multiplierManager.getMultipliers().get(uuid)).getTimeSecounds() != 0) {
                        if (((TempMultiplier) multiplierManager.getMultipliers().get(uuid)).getStartTime().getTime() + (((TempMultiplier) multiplierManager.getMultipliers().get(uuid)).getTimeSecounds() * 1000) < System.currentTimeMillis()) {
                            multiplierManager.getMultipliers().remove(uuid);
                        }
                    }
                }
            }
        }

    }
}
