package org.kasun.xpmultiplierplus;

import org.kasun.xpmultiplierplus.Commands.CommandsManager;
import org.kasun.xpmultiplierplus.Config.ConfigManager;
import org.kasun.xpmultiplierplus.Listeners.ListenerManager;
import org.kasun.xpmultiplierplus.Multiplier.MultiplierManager;
import org.kasun.xpmultiplierplus.Runnables.RunnableManager;
import org.kasun.xpmultiplierplus.Utils.FileManager;
import org.kasun.xpmultiplierplus.Utils.OutdatedReminder;
import org.kasun.xpmultiplierplus.Utils.StartupManager;

public class MainManager {
    private OutdatedReminder outdatedReminder;
    private StartupManager startupManager;
    private FileManager fileManager;
    private ConfigManager configManager;
    private MultiplierManager multiplierManager;
    private CommandsManager commandsManager;
    private ListenerManager listenerManager;
    private RunnableManager runnableManager;


    public MainManager() {
        fileManager = new FileManager();
        configManager = new ConfigManager();
        outdatedReminder = new OutdatedReminder(configManager);
        startupManager = new StartupManager(configManager, outdatedReminder);
        multiplierManager = new MultiplierManager();
        multiplierManager.setDefaultMultiplier(configManager.getMainConfig().defaultMultiplier);
        commandsManager = new CommandsManager();
        listenerManager = new ListenerManager();
        runnableManager = new RunnableManager();
    }


    //getters and setters


    public OutdatedReminder getOutdatedReminder() {
        return outdatedReminder;
    }

    public void setOutdatedReminder(OutdatedReminder outdatedReminder) {
        this.outdatedReminder = outdatedReminder;
    }

    public StartupManager getStartupManager() {
        return startupManager;
    }

    public void setStartupManager(StartupManager startupManager) {
        this.startupManager = startupManager;
    }

    public FileManager getFileManager() {
        return fileManager;
    }

    public void setFileManager(FileManager fileManager) {
        this.fileManager = fileManager;
    }

    public RunnableManager getRunnableManager() {
        return runnableManager;
    }

    public void setRunnableManager(RunnableManager runnableManager) {
        this.runnableManager = runnableManager;
    }

    public ConfigManager getConfigManager() {
        return configManager;
    }

    public void setConfigManager(ConfigManager configManager) {
        this.configManager = configManager;
    }

    public MultiplierManager getMultiplierManager() {
        return multiplierManager;
    }

    public void setMultiplierManager(MultiplierManager multiplierManager) {
        this.multiplierManager = multiplierManager;
    }

    public CommandsManager getCommandsManager() {
        return commandsManager;
    }

    public void setCommandsManager(CommandsManager commandsManager) {
        this.commandsManager = commandsManager;
    }

    public ListenerManager getListenerManager() {
        return listenerManager;
    }

    public void setListenerManager(ListenerManager listenerManager) {
        this.listenerManager = listenerManager;
    }
}
