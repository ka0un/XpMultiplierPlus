package org.kasun.xpmultiplierplus.utils;

import com.ibm.jvm.j9.dump.extract.Main;
import org.kasun.xpmultiplierplus.Config.MainConfig;
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
            plugin.getLogger().info("Copying file lang.yml to " + plugin.getDataFolder().getName());
            FileUtils.copyFileFromPlugin(plugin, "en-us.yml", plugin.getDataFolder().getAbsolutePath() + "/lang/en-us.yml");
        }
    }
}
