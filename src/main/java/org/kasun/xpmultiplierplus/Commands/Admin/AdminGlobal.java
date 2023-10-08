package org.kasun.xpmultiplierplus.Commands.Admin;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.kasun.xpmultiplierplus.Multiplier.GlobalMultiplier;
import org.kasun.xpmultiplierplus.Utils.ColorUtils;
import org.kasun.xpmultiplierplus.Utils.TimeStringToSecondsConverter;
import org.kasun.xpmultiplierplus.XpMultiplierPlus;

import java.sql.Timestamp;
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

        //xpm admin global <multiplier> <duration>

        if (args.length == 3) {
            plugin.getMainManager().getMultiplierManager().getGlobalMultipliers().add(new GlobalMultiplier(Double.parseDouble(args[2]), false, 0, null));
            sender.sendMessage(ColorUtils.color(plugin.getMainManager().getConfigManager().getMainConfig().langMap.get("admin-global-set")).replace("%multiplier%", args[2]));
            return;
        }

        if (args.length == 4){
            if (args[3].equalsIgnoreCase("PERMANENT")){
                plugin.getMainManager().getMultiplierManager().getGlobalMultipliers().add(new GlobalMultiplier(Double.parseDouble(args[2]), false, 0, null));
                sender.sendMessage(ColorUtils.color(plugin.getMainManager().getConfigManager().getMainConfig().langMap.get("admin-global-set")).replace("%multiplier%", args[2]));
                return;
            }else{
                Timestamp timestamp = new Timestamp(System.currentTimeMillis());
                plugin.getMainManager().getMultiplierManager().getGlobalMultipliers().add(new GlobalMultiplier(Double.parseDouble(args[2]), true, TimeStringToSecondsConverter.convertToSeconds(args[3]), timestamp));
                sender.sendMessage(ColorUtils.color(plugin.getMainManager().getConfigManager().getMainConfig().langMap.get("admin-global-set")).replace("%multiplier%", args[2]));
                return;
            }
        }
    }
}
