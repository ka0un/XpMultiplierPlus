package org.kasun.xpmultiplierplus.Listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerExpChangeEvent;
import org.kasun.xpmultiplierplus.Multiplier.Multiplier;
import org.kasun.xpmultiplierplus.Multiplier.MultiplierManager;
import org.kasun.xpmultiplierplus.XpMultiplierPlus;

import java.util.List;
import java.util.UUID;

public class XpListener implements Listener {

    List<Multiplier> multipliers;
    XpMultiplierPlus plugin = XpMultiplierPlus.getInstance();
    MultiplierManager multiplierManager;

    @EventHandler(priority = EventPriority.LOW, ignoreCancelled = false)
    public void onXpGain(PlayerExpChangeEvent event) {

        if (plugin.getMainManager().getMultiplierManager() != null){
            multiplierManager = plugin.getMainManager().getMultiplierManager();
        }

        multipliers = plugin.getMainManager().getConfigManager().getMainConfig().multipliers;
        Player player = event.getPlayer();
        int xp = event.getAmount();
        UUID uuid = player.getUniqueId();

        if (multiplierManager.getMultipliers().containsKey(uuid)) {
            Multiplier m = multiplierManager.getMultipliers().get(uuid);
            event.setAmount((int) (xp * m.getMultiplier()));
            player.sendMessage("You have " + m.getMultiplier() + "X XP!");
            return;
        }

    }
}
