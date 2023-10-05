package org.kasun.xpmultiplierplus.utils;

import org.bukkit.Color;

public class ColorUtils {
    //convert color codes to color
    public static String color(String message) {
        message = message.replaceAll("&0", "\u001B[0;30m");  // Black
        message = message.replaceAll("&1", "\u001B[0;34m");  // Dark Blue
        message = message.replaceAll("&2", "\u001B[0;32m");  // Dark Green
        message = message.replaceAll("&3", "\u001B[0;36m");  // Dark Aqua
        message = message.replaceAll("&4", "\u001B[0;31m");  // Dark Red
        message = message.replaceAll("&5", "\u001B[0;35m");  // Dark Purple
        message = message.replaceAll("&6", "\u001B[0;33m");  // Gold
        message = message.replaceAll("&7", "\u001B[0;37m");  // Gray
        message = message.replaceAll("&8", "\u001B[0;30;1m");  // Dark Gray
        message = message.replaceAll("&9", "\u001B[0;34;1m");  // Blue
        message = message.replaceAll("&a", "\u001B[0;32;1m");  // Green
        message = message.replaceAll("&b", "\u001B[0;36;1m");  // Aqua
        message = message.replaceAll("&c", "\u001B[0;31;1m");  // Red
        message = message.replaceAll("&d", "\u001B[0;35;1m");  // Purple
        message = message.replaceAll("&e", "\u001B[0;33;1m");  // Yellow
        message = message.replaceAll("&f", "\u001B[0;37;1m");  // White
        message = message.replaceAll("&r", "\u001B[0m");  // Reset
        return message;
    }
}
