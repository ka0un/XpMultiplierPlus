package org.kasun.xpmultiplierplus.Runnables;

import org.kasun.xpmultiplierplus.XpMultiplierPlus;

public class RunnableManager {
    XpMultiplierPlus plugin = XpMultiplierPlus.getInstance();
    public RunnableManager() {

        XpMultiplierPlus plugin = XpMultiplierPlus.getInstance();
        PermissionCheckRunnable permissionCheckRunnable = new PermissionCheckRunnable(plugin);
        int taskId = permissionCheckRunnable.runTaskTimerAsynchronously(plugin, 0, 20 * 5).getTaskId();
    }
}
