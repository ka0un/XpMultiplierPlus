package org.kasun.xpmultiplierplus;

import org.kasun.xpmultiplierplus.Commands.CommandsManager;
import org.kasun.xpmultiplierplus.Config.ConfigManager;
import org.kasun.xpmultiplierplus.Listeners.ListenerManager;
import org.kasun.xpmultiplierplus.Multiplier.MultiplierManager;
import org.kasun.xpmultiplierplus.Runnables.RunnableManager;
import org.kasun.xpmultiplierplus.utils.FileManager;
import org.kasun.xpmultiplierplus.utils.StartupManager;

public class MainManager {
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
        startupManager = new StartupManager(configManager);
        multiplierManager = new MultiplierManager();
        commandsManager = new CommandsManager();
        listenerManager = new ListenerManager();
        runnableManager = new RunnableManager();
    }


    //getters and setters


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
