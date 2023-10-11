package org.kasun.xpmultiplierplus.ActionBar;


import com.hakan.core.HCore;
import me.clip.placeholderapi.PlaceholderAPI;
import org.bukkit.entity.Player;
import org.kasun.xpmultiplierplus.Utils.ColorUtils;
import org.kasun.xpmultiplierplus.XpMultiplierPlus;


public class DisplayXpCollectActionBar {
    private int collectedXP;
    private double activeMultiplier;
    private Player player;
    private XpMultiplierPlus plugin = XpMultiplierPlus.getInstance();

    public DisplayXpCollectActionBar(int collectedXP, double activeMultiplier, Player player) {
        this.collectedXP = collectedXP;
        this.activeMultiplier = activeMultiplier;
        this.player = player;
        sendActionBar();
    }

    private String getActionBarMessage(){
        String baseMessage = plugin.getMainManager().getConfigManager().getMainConfig().langMap.get("xp_collect_action_bar");
        String message = baseMessage.replace("%xp%", String.valueOf(collectedXP));
        String colouredMessage = ColorUtils.color(message);

        return PlaceholderAPI.setPlaceholders(player, colouredMessage);
    }

    private void sendActionBar(){
        HCore.sendActionBar(player, getActionBarMessage());

    }

}
