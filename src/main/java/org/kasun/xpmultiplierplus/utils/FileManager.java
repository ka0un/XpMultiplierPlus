package org.kasun.xpmultiplierplus.utils;

import org.kasun.xpmultiplierplus.XpMultiplierPlus;

import java.io.File;

public class FileManager {

    private XpMultiplierPlus plugin;
    public FileManager() {
        plugin = XpMultiplierPlus.getInstance();
        copyLangFile();
    }

    private void copyLangFile() {
        if (!new File(plugin.getDataFolder(), "/lang/en-us.yml").exists()) {
            if (!new File(plugin.getDataFolder(), "/lang").exists()) {
                new File(plugin.getDataFolder(), "/lang").mkdir();
            }
            FileUtils.copyResourceFileToFolder("en-us.yml", plugin.getDataFolder() + "/lang");
        }
    }
}
