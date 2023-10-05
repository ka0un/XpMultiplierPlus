package org.kasun.xpmultiplierplus.utils;

import org.kasun.xpmultiplierplus.XpMultiplierPlus;

import java.io.File;

public class FileUtils {
    //methode for copy file from plugin to specified location
    public static void copyFileFromPlugin(XpMultiplierPlus plugin, String source, String destination) {
        File sourceFile = new File(plugin.getDataFolder(), source);
        File destinationFile = new File(destination);
        if (!destinationFile.exists()) {
            plugin.getLogger().info("Copying file " + sourceFile.getName() + " to " + destinationFile.getName());
            plugin.saveResource(source, false);
        }
    }

}
