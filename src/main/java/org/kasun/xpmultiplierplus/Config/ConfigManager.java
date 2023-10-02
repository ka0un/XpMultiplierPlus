package org.kasun.xpmultiplierplus.Config;

public class ConfigManager {
    private MainConfig mainConfig;

    public ConfigManager() {
        mainConfig = new MainConfig();
    }

    public MainConfig getMainConfig() {
        return mainConfig;
    }
}
