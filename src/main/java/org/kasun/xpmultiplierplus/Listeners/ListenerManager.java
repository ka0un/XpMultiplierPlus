package org.kasun.xpmultiplierplus.Listeners;

import org.kasun.xpmultiplierplus.XpMultiplierPlus;

public class ListenerManager {
    //register the listeners here
    public ListenerManager() {
        XpMultiplierPlus plugin = XpMultiplierPlus.getInstance();
        plugin.getServer().getPluginManager().registerEvents(new XpListener(), plugin);
    }

}
