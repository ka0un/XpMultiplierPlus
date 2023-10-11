package org.kasun.xpmultiplierplus.Placeholders;

import me.clip.placeholderapi.expansion.PlaceholderExpansion;
import org.bukkit.entity.Player;
import org.kasun.xpmultiplierplus.Multiplier.MultiplierProvider;
import org.kasun.xpmultiplierplus.XpMultiplierPlus;

public class MultiplierPlaceholder extends PlaceholderExpansion {
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
        return null;
    }
}
