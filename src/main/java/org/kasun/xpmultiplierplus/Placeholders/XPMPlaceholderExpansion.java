package org.kasun.xpmultiplierplus.Placeholders;

import me.clip.placeholderapi.expansion.PlaceholderExpansion;
import org.bukkit.entity.Player;
import org.kasun.xpmultiplierplus.Multiplier.GlobalMultiplier;
import org.kasun.xpmultiplierplus.Multiplier.MultiplierManager;
import org.kasun.xpmultiplierplus.Multiplier.MultiplierProvider;
import org.kasun.xpmultiplierplus.XpMultiplierPlus;

import java.util.ArrayList;

public class XPMPlaceholderExpansion extends PlaceholderExpansion {
    XpMultiplierPlus plugin = XpMultiplierPlus.getInstance();
    @Override
    public String getIdentifier() {
        return "xpm";
    }

    @Override
    public String getAuthor() {
        return "Kasun Hapangama";
    }

    @Override
    public String getVersion() {
        return plugin.getDescription().getVersion();
    }

    @Override
    public String onPlaceholderRequest(Player player, String identifier) {
        if (identifier.equals("multiplier")) {
            MultiplierProvider multiplierProvider = new MultiplierProvider(plugin.getMainManager().getMultiplierManager().getMultipliers());
            return String.valueOf(multiplierProvider.getPlayersBestMultiplier(player.getUniqueId()).getMultiplier());
        }

        if (identifier.equals("global")) {
            MultiplierManager multiplierManager = plugin.getMainManager().getMultiplierManager();
            ArrayList<GlobalMultiplier> globalMultipliers = multiplierManager.getGlobalMultipliers();
            GlobalMultiplier bestGlobalMultiplier = globalMultipliers.get(0);
            for (GlobalMultiplier globalMultiplier : globalMultipliers) {
                if (bestGlobalMultiplier.getMultiplier() < globalMultiplier.getMultiplier()) {
                    bestGlobalMultiplier = globalMultiplier;
                }
            }
            return String.valueOf(bestGlobalMultiplier.getMultiplier());
        }

        if (identifier.equals("xp_points")){
            return String.valueOf(player.getTotalExperience());
        }

        if (identifier.equals("xp_level")){
            return String.valueOf(player.getLevel());
        }


        return null;
    }
}
