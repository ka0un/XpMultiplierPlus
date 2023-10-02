package org.kasun.xpmultiplierplus;

import org.kasun.xpmultiplierplus.Commands.CommandsManager;
import org.kasun.xpmultiplierplus.Config.ConfigManager;
import org.kasun.xpmultiplierplus.Listeners.ListenerManager;
import org.kasun.xpmultiplierplus.Multiplier.MultiplierManager;

public class MainManager {
    private ConfigManager configManager;
    private MultiplierManager multiplierManager;
    private CommandsManager commandsManager;
    private ListenerManager listenerManager;

    public MainManager() {
        configManager = new ConfigManager();
        multiplierManager = new MultiplierManager();
        commandsManager = new CommandsManager();
        listenerManager = new ListenerManager();
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
