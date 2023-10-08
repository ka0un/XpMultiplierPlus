package org.kasun.xpmultiplierplus.Commands.Admin;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.kasun.xpmultiplierplus.Multiplier.Multiplier;
import org.kasun.xpmultiplierplus.Utils.ColorUtils;
import org.kasun.xpmultiplierplus.XpMultiplierPlus;

import java.util.HashMap;
import java.util.List;
import java.util.UUID;

public class AdminTake {
    CommandSender sender;
    Command command;
    String label;
    String[] args;
    XpMultiplierPlus plugin;
    private HashMap<UUID, List<Multiplier>> multiplierMap;
    public AdminTake(CommandSender sender, Command command, String label, String[] args) {
        this.sender = sender;
        this.command = command;
        this.label = label;
        this.args = args;
        plugin = XpMultiplierPlus.getInstance();
        multiplierMap = plugin.getMainManager().getMultiplierManager().getMultipliers();

        //xpm admin take <player> <multiplier>

        if (args.length == 4){
            if (plugin.getServer().getPlayer(args[2]) == null){
                sender.sendMessage(ColorUtils.color(plugin.getMainManager().getConfigManager().getMainConfig().langMap.get("player-not-found")));
                return;
            }

            if (multiplierMap.containsKey(plugin.getServer().getPlayer(args[2]).getUniqueId())){

                if (multiplierMap.get(plugin.getServer().getPlayer(args[2]).getUniqueId()).size() == 0){
                    sender.sendMessage(ColorUtils.color(plugin.getMainManager().getConfigManager().getMainConfig().langMap.get("admin-view-no-multipliers")).replace("%player%", plugin.getServer().getPlayer(args[2]).getName()));
                    return;
                }

                List<Multiplier> multiplierList = multiplierMap.get(plugin.getServer().getPlayer(args[2]).getUniqueId());

                if (multiplierList.contains(multiplierList.stream().filter(multiplier -> multiplier.getMultiplier() == Double.parseDouble(args[3])).findFirst().orElse(null))) {
                    multiplierList.remove(multiplierList.stream().filter(multiplier -> multiplier.getMultiplier() == Double.parseDouble(args[3])).findFirst().orElse(null));
                    multiplierMap.put(plugin.getServer().getPlayer(args[2]).getUniqueId(), multiplierList);

                    sender.sendMessage(ColorUtils.color(plugin.getMainManager().getConfigManager().getMainConfig().langMap.get("admin-take-1")).replace("%player%", plugin.getServer().getPlayer(args[2]).getName()).replace("%multiplier%", args[3]));
                    return;
                }

            }else{
                sender.sendMessage(ColorUtils.color(plugin.getMainManager().getConfigManager().getMainConfig().langMap.get("admin-view-no-multipliers")).replace("%player%", plugin.getServer().getPlayer(args[2]).getName()));
                return;
            }
        }
    }
}
