package org.kasun.xpmultiplierplus.Listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.kasun.xpmultiplierplus.Utils.OutdatedReminder;
import org.kasun.xpmultiplierplus.XpMultiplierPlus;

public class PlayerJoinListener implements Listener {
    XpMultiplierPlus plugin = XpMultiplierPlus.getInstance();
    OutdatedReminder outdatedReminder;
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        outdatedReminder = plugin.getMainManager().getOutdatedReminder();
        Player player = event.getPlayer();
        if (player.hasPermission("xpm.admin") || player.isOp()) {
            outdatedReminder.remind(player);
        }
    }
}
