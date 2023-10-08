package org.kasun.xpmultiplierplus.Runnables;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import org.kasun.xpmultiplierplus.Multiplier.Multiplier;
import org.kasun.xpmultiplierplus.Multiplier.MultiplierManager;
import org.kasun.xpmultiplierplus.Multiplier.TempMultiplier;
import org.kasun.xpmultiplierplus.XpMultiplierPlus;

import java.util.*;

public class PermissionCheckRunnable extends BukkitRunnable {

    private XpMultiplierPlus plugin;
    private List<Multiplier> multipliers;
    private MultiplierManager multiplierManager;
    private HashMap<UUID, List<String>> tempPermissionMap;

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

            List<Multiplier> playersMultiplierList = new ArrayList<>();
            List<String> playersPermissionList = new ArrayList<>();

            for (Multiplier m : multipliers) {
                if (player.hasPermission(m.getPermission())) {
                    playersMultiplierList.add(m);
                    playersPermissionList.add(m.getPermission());
                }
            }

            if (playersMultiplierList.size() != 0){
                multiplierManager.getMultipliers().put(player.getUniqueId(), playersMultiplierList);
            }

            if (playersPermissionList.size() != 0) {
                tempPermissionMap.put(player.getUniqueId(), playersPermissionList);
            }

        }

        //if player doesn't have perms removes his multiplier
        for (UUID uuid : tempPermissionMap.keySet()) {
            if (!(Bukkit.getPlayer(uuid) == null)) {
                for (String permission : tempPermissionMap.get(uuid)) {
                    if (!(Bukkit.getPlayer(uuid).hasPermission(permission))) {
                        multiplierManager.getMultipliers().get(uuid).removeIf(multiplier -> multiplier.getPermission().equalsIgnoreCase(permission));
                    }
                }
            }
        }

        //if temp multiplier outdated removes it
        HashMap<UUID, Multiplier> removeMuliplierMap = new HashMap<>();

        for (UUID uuid : multiplierManager.getMultipliers().keySet()) {
            List<Multiplier> playersMultiplierList = multiplierManager.getMultipliers().get(uuid);
            for (Multiplier m : playersMultiplierList) {
                if (m instanceof TempMultiplier) {
                    if (((TempMultiplier) m).getStartTime() != null) {
                        if (((TempMultiplier) m).getTimeSecounds() != 0) {
                            if (((TempMultiplier) m).getStartTime().getTime() + (((TempMultiplier) m).getTimeSecounds() * 1000) < System.currentTimeMillis()) {
                                    removeMuliplierMap.put(uuid, m);
                            }
                        }
                    }
                }
            }
        }

        if (removeMuliplierMap.size() != 0){
            for (UUID uuid : removeMuliplierMap.keySet()){
                multiplierManager.getMultipliers().get(uuid).remove(removeMuliplierMap.get(uuid));
            }
        }

    }
}
