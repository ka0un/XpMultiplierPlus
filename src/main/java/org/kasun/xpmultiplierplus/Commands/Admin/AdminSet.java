package org.kasun.xpmultiplierplus.Commands.Admin;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.kasun.xpmultiplierplus.Config.MainConfig;
import org.kasun.xpmultiplierplus.Multiplier.Multiplier;
import org.kasun.xpmultiplierplus.Utils.ColorUtils;
import org.kasun.xpmultiplierplus.XpMultiplierPlus;

import java.util.HashMap;
import java.util.List;
import java.util.UUID;

public class AdminSet {
    private CommandSender sender;
    private Command command;
    private String label;
    private String[] args;
    private XpMultiplierPlus plugin;
    private List<Multiplier> multipliers;
    private HashMap<UUID, Multiplier> multiplierMap;

    public AdminSet(CommandSender sender, Command command, String label, String[] args) {
        plugin = XpMultiplierPlus.getInstance();
        MainConfig mainConfig = plugin.getMainManager().getConfigManager().getMainConfig();
        this.sender = sender;
        this.command = command;
        this.label = label;
        this.args = args;
        multipliers = plugin.getMainManager().getConfigManager().getMainConfig().multipliers;
        multiplierMap = plugin.getMainManager().getMultiplierManager().getMultipliers();

        //xpm admin set <player> <multiplier>

        if (args.length == 2) {
            sender.sendMessage(ColorUtils.color(mainConfig.langMap.get("admin-set-usage")));
            return;
        }

        if (args.length == 3) {
            sender.sendMessage(ColorUtils.color(mainConfig.langMap.get("admin-set-usage")));
            return;
        }

        if (args.length == 4) {
            if (plugin.getServer().getPlayer(args[2]) == null) {
                sender.sendMessage(ColorUtils.color(mainConfig.langMap.get("player-not-found")));
                return;
            }

            if (args[3].equalsIgnoreCase("0")) {
                sender.sendMessage(ColorUtils.color(mainConfig.langMap.get("admin-set-usage")));
                return;
            }

            //check if given <multiplier> exisits in multiplier list
            boolean found = false;
            int indexOfMultiplier = 0;
            for (Multiplier m : multipliers) {
                if (m.getMultiplier() == Double.parseDouble(args[3])) {
                    indexOfMultiplier = multipliers.indexOf(m);
                    found = true;
                    break;
                }
            }

            if (!found) {
                sender.sendMessage(ColorUtils.color(mainConfig.langMap.get("admin-set-usage")));
                return;
            }

            //check if player already has a multiplier
            if (multiplierMap.containsKey(plugin.getServer().getPlayer(args[2]).getUniqueId())) {
                multiplierMap.remove(plugin.getServer().getPlayer(args[2]).getUniqueId());
                Multiplier multiplier = multipliers.get(indexOfMultiplier);
                multiplierMap.put(plugin.getServer().getPlayer(args[2]).getUniqueId(), multiplier);
                sender.sendMessage(ColorUtils.color(mainConfig.langMap.get("admin-set-success").replace("%player%", args[2]).replace("%multiplier%", args[3])));
                return;
            }else{
                Multiplier multiplier = multipliers.get(indexOfMultiplier);
                multiplierMap.put(plugin.getServer().getPlayer(args[2]).getUniqueId(), multiplier);
                sender.sendMessage(ColorUtils.color(mainConfig.langMap.get("admin-set-success").replace("%player%", args[2]).replace("%multiplier%", args[3])));
                return;
            }
        }
    }
}
