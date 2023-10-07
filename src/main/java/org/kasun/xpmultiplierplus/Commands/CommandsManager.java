package org.kasun.xpmultiplierplus.Commands;


import org.kasun.xpmultiplierplus.XpMultiplierPlus;

public class CommandsManager {

    public CommandsManager() {
        XpMultiplierPlus plugin = XpMultiplierPlus.getInstance();
        plugin.getCommand("xpm").setExecutor(new XPMCommand());
    }

}
