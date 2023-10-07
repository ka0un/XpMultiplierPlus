package org.kasun.xpmultiplierplus.Commands.Admin;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.kasun.xpmultiplierplus.Config.MainConfig;
import org.kasun.xpmultiplierplus.Utils.ColorUtils;
import org.kasun.xpmultiplierplus.XpMultiplierPlus;

public class AdminHelp {

    private XpMultiplierPlus plugin;
    public AdminHelp(CommandSender  sender) {
        plugin = XpMultiplierPlus.getInstance();
        MainConfig mainConfig = plugin.getMainManager().getConfigManager().getMainConfig();

        if (sender instanceof Player){
            Player player = (Player) sender;
            player.sendMessage(ColorUtils.color(mainConfig.langMap.get("admin-help-1")));
            player.sendMessage(ColorUtils.color(mainConfig.langMap.get("admin-help-2")));
            player.sendMessage(ColorUtils.color(mainConfig.langMap.get("admin-help-3")));
            player.sendMessage(ColorUtils.color(mainConfig.langMap.get("admin-help-4")));
            player.sendMessage(ColorUtils.color(mainConfig.langMap.get("admin-help-5")));
            player.sendMessage(ColorUtils.color(mainConfig.langMap.get("admin-help-6")));
            player.sendMessage(ColorUtils.color(mainConfig.langMap.get("admin-help-7")));

        }else{
            sender.sendMessage(ColorUtils.color(mainConfig.langMap.get("admin-help-1")));
            sender.sendMessage(ColorUtils.color(mainConfig.langMap.get("admin-help-2")));
            sender.sendMessage(ColorUtils.color(mainConfig.langMap.get("admin-help-3")));
            sender.sendMessage(ColorUtils.color(mainConfig.langMap.get("admin-help-4")));
            sender.sendMessage(ColorUtils.color(mainConfig.langMap.get("admin-help-5")));
            sender.sendMessage(ColorUtils.color(mainConfig.langMap.get("admin-help-6")));
            sender.sendMessage(ColorUtils.color(mainConfig.langMap.get("admin-help-7")));
        }



    }
}
