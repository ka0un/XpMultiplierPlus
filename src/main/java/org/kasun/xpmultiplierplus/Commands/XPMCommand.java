package org.kasun.xpmultiplierplus.Commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import org.bukkit.entity.Player;
import org.kasun.xpmultiplierplus.Commands.Admin.AdminCommandManager;
import org.kasun.xpmultiplierplus.Config.MainConfig;
import org.kasun.xpmultiplierplus.Utils.ColorUtils;
import org.kasun.xpmultiplierplus.XpMultiplierPlus;

import java.util.ArrayList;
import java.util.List;

public class XPMCommand implements TabExecutor {
    MainConfig mainConfig;
    XpMultiplierPlus plugin;
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        plugin = XpMultiplierPlus.getInstance();
        mainConfig = plugin.getMainManager().getConfigManager().getMainConfig();

        if (args.length == 0) {
            return true;
        }

        if (args[0].equalsIgnoreCase("admin")){
            if (sender.isOp() || !(sender instanceof Player)){
                AdminCommandManager adminCommandManager = new AdminCommandManager(sender, command, label, args);
                return true;
            }else{

                if (sender instanceof Player){
                    Player player = (Player) sender;
                    if (player.hasPermission("xpm.admin")){
                        AdminCommandManager adminCommandManager = new AdminCommandManager(sender, command, label, args);
                        return true;
                    }
                    player.sendMessage(ColorUtils.color(mainConfig.langMap.get("no-permission")));
                    return true;
                }
                sender.sendMessage(ColorUtils.color(mainConfig.langMap.get("no-permission")));
                return true;
            }
        }



        return true;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command cmd, String label, String[] args) {
        if (args.length == 1) {
            List<String> arguments = new ArrayList<>();
            arguments.add("admin");
            return arguments;
        }
        if (args[0].equalsIgnoreCase("forcesend")) {
            if (args.length == 2) {
                return null;
            }

        }
        return null;
    }

}
