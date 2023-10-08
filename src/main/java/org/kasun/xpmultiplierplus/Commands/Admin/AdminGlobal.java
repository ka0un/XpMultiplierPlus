package org.kasun.xpmultiplierplus.Commands.Admin;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.kasun.xpmultiplierplus.Utils.ColorUtils;
import org.kasun.xpmultiplierplus.XpMultiplierPlus;

import java.util.HashMap;

public class AdminGlobal {
    CommandSender sender;
    Command command;
    String label;
    String[] args;
    XpMultiplierPlus plugin;
    public AdminGlobal(CommandSender sender, Command command, String label, String[] args) {
        this.sender = sender;
        this.command = command;
        this.label = label;
        this.args = args;
        plugin = XpMultiplierPlus.getInstance();

        //xpm admin global <multiplier>

        if (args.length == 3) {
            if (plugin.getMainManager().getMultiplierManager().getDefaultMultiplier() == Double.parseDouble(args[2])) {
                sender.sendMessage(ColorUtils.color(plugin.getMainManager().getConfigManager().getMainConfig().langMap.get("admin-global-alredy-is")).replace("%multiplier%", args[2]));
                return;
            }
            plugin.getMainManager().getMultiplierManager().setDefaultMultiplier(Double.parseDouble(args[2]));
            sender.sendMessage(ColorUtils.color(plugin.getMainManager().getConfigManager().getMainConfig().langMap.get("admin-global-set")).replace("%multiplier%", args[2]));
            return;
        }
    }
}
