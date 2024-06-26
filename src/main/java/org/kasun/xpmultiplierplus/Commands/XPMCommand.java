package org.kasun.xpmultiplierplus.Commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import org.bukkit.entity.Player;
import org.kasun.xpmultiplierplus.Commands.Admin.AdminCommandManager;
import org.kasun.xpmultiplierplus.Config.MainConfig;
import org.kasun.xpmultiplierplus.Multiplier.Multiplier;
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
        plugin = XpMultiplierPlus.getInstance();
        mainConfig = plugin.getMainManager().getConfigManager().getMainConfig();

        switch (args.length){
            case 1:
                List<String> arguments = new ArrayList<>();
                arguments.add("admin");
                return arguments;
            case 2:
                List<String> arguments2 = new ArrayList<>();
                arguments2.add("help");
                arguments2.add("give");
                arguments2.add("take");
                arguments2.add("view");
                arguments2.add("global");
                arguments2.add("reload");
                return arguments2;
            case 3:
                List<String> arguments3 = new ArrayList<>();
                if (args[1].equalsIgnoreCase("give") || args[1].equalsIgnoreCase("view") || args[1].equalsIgnoreCase("take")){
                    for (Player player : plugin.getServer().getOnlinePlayers()){
                        arguments3.add(player.getName());
                    }
                }
                if (args[1].equalsIgnoreCase("global")){
                    for (Multiplier m: plugin.getMainManager().getConfigManager().getMainConfig().multipliers){
                        arguments3.add(String.valueOf(m.getMultiplier()));
                    }
                }
                return arguments3;

            case 4:
                List<String> arguments4 = new ArrayList<>();
                if (args[1].equalsIgnoreCase("give") || args[1].equalsIgnoreCase("take")){
                    for (Multiplier m: plugin.getMainManager().getConfigManager().getMainConfig().multipliers){
                        arguments4.add(String.valueOf(m.getMultiplier()));
                    }
                }
                if (args[1].equalsIgnoreCase("global")){
                    arguments4.add("PERMANENT");
                    arguments4.add("5s");
                    arguments4.add("1H");
                }
                return arguments4;
            case 5:
                List<String> arguments5 = new ArrayList<>();
                if (args[1].equalsIgnoreCase("give")){
                    arguments5.add("PERMANENT");
                    arguments5.add("5s");
                    arguments5.add("1H");
                }
                return arguments5;
        }

        return null;
    }

}
