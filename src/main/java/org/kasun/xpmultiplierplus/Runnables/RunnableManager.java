package org.kasun.xpmultiplierplus.Runnables;

import org.kasun.xpmultiplierplus.Config.ConfigManager;
import org.kasun.xpmultiplierplus.XpMultiplierPlus;

public class RunnableManager {
    XpMultiplierPlus plugin = XpMultiplierPlus.getInstance();
    public RunnableManager(ConfigManager configManager) {

        XpMultiplierPlus plugin = XpMultiplierPlus.getInstance();
        PermissionCheckRunnable permissionCheckRunnable = new PermissionCheckRunnable(plugin);
        DebugRunnable debugRunnable = new DebugRunnable(plugin);
        int taskId = permissionCheckRunnable.runTaskTimerAsynchronously(plugin, 0, 20 * 5).getTaskId();
        if (configManager.getMainConfig().debugEnabled){
            int debugPeriod = configManager.getMainConfig().debugPeriod;
            debugRunnable.runTaskTimerAsynchronously(plugin, 0, 20 * debugPeriod).getTaskId();
        }

    }
}
