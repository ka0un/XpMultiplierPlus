package org.kasun.xpmultiplierplus.Listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerExpChangeEvent;
import org.kasun.xpmultiplierplus.Multiplier.Multiplier;
import org.kasun.xpmultiplierplus.XpMultiplierPlus;

import java.util.List;

public class XpListener implements Listener {

    List<Multiplier> multipliers;
    XpMultiplierPlus plugin = XpMultiplierPlus.getInstance();

    @EventHandler(priority = EventPriority.HIGH, ignoreCancelled = false)
    public void onXpGain(PlayerExpChangeEvent event) {
        multipliers = plugin.getMainManager().getConfigManager().getMainConfig().multipliers;
        Player player = event.getPlayer();
        int xp = event.getAmount();

        for (Multiplier m : multipliers) {
            if (player.hasPermission(m.getPermission())) {
                event.setAmount((int) (xp * m.getMultiplier()));
                player.sendMessage("You have " + m.getMultiplier() + "X XP!");
                return;
            }
        }

    }
}
