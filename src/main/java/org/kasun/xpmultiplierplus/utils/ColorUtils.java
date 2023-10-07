package org.kasun.xpmultiplierplus.Utils;

import org.bukkit.ChatColor;
import org.bukkit.Color;

public class ColorUtils {
    //convert color codes to color
    public static String color(String message) {
        String translated = message.replaceAll("&([0-9a-fk-orA-FK-OR])", "§$1");
        return ChatColor.translateAlternateColorCodes('&', translated);
    }
}
