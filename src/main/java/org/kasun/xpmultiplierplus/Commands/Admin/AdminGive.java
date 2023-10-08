package org.kasun.xpmultiplierplus.Commands.Admin;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.kasun.xpmultiplierplus.Config.MainConfig;
import org.kasun.xpmultiplierplus.Multiplier.Multiplier;
import org.kasun.xpmultiplierplus.Multiplier.TempMultiplier;
import org.kasun.xpmultiplierplus.Utils.ColorUtils;
import org.kasun.xpmultiplierplus.Utils.TimeStringToSecondsConverter;
import org.kasun.xpmultiplierplus.XpMultiplierPlus;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

public class AdminGive {
    private CommandSender sender;
    private Command command;
    private String label;
    private String[] args;
    private XpMultiplierPlus plugin;
    private List<Multiplier> multipliers;
    private HashMap<UUID, List<Multiplier>> multiplierMap;

    public AdminGive(CommandSender sender, Command command, String label, String[] args) {
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
            sender.sendMessage(ColorUtils.color(mainConfig.langMap.get("admin-give-usage")));
            return;
        }

        if (args.length == 3) {
            sender.sendMessage(ColorUtils.color(mainConfig.langMap.get("admin-give-usage")));
            return;
        }

        if (args.length >= 4) {
            if (plugin.getServer().getPlayer(args[2]) == null) {
                sender.sendMessage(ColorUtils.color(mainConfig.langMap.get("player-not-found")));
                return;
            }

            if (args[3].equalsIgnoreCase("0")) {
                sender.sendMessage(ColorUtils.color(mainConfig.langMap.get("admin-give-usage")));
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
                sender.sendMessage(ColorUtils.color(mainConfig.langMap.get("admin-give-usage")));
                return;
            }

            if (args.length == 5){

                if (args[4].equalsIgnoreCase("0")){
                    sender.sendMessage(ColorUtils.color(mainConfig.langMap.get("admin-give-usage")));
                    return;
                }

                if (args[4].equalsIgnoreCase("PERMANENT") || args.length == 4){
                    Multiplier multiplier = multipliers.get(indexOfMultiplier);
                    List<Multiplier> multiplierList = multiplierMap.get(plugin.getServer().getPlayer(args[2]).getUniqueId());

                    if (multiplierList != null) {

                    }else{
                        multiplierList = new ArrayList<>();
                    }

                    multiplierList.add(multiplier);
                    multiplierMap.put(plugin.getServer().getPlayer(args[2]).getUniqueId(), multiplierList);
                    sender.sendMessage(ColorUtils.color(mainConfig.langMap.get("admin-give-success").replace("%player%", args[2]).replace("%multiplier%", args[3])));
                    return;
                }else{

                    Long timeSecounds = TimeStringToSecondsConverter.convertToSeconds(args[4]);
                    Timestamp timestamp = new Timestamp(System.currentTimeMillis());

                    TempMultiplier multiplier = new TempMultiplier(multipliers.get(indexOfMultiplier).getMultiplier(), "", timestamp, timeSecounds);
                    List<Multiplier> multiplierList = multiplierMap.get(plugin.getServer().getPlayer(args[2]).getUniqueId());

                    if (multiplierList != null) {
                        for (Multiplier m : multiplierList) {
                            if (m.getMultiplier() == multiplier.getMultiplier()) {
                                if (m instanceof TempMultiplier){
                                    ((TempMultiplier) m).setTimeSecounds(((TempMultiplier) m).getTimeSecounds() * 2);
                                    sender.sendMessage(ColorUtils.color(mainConfig.langMap.get("admin-give-success-temp").replace("%player%", args[2]).replace("%multiplier%", args[3]).replace("%time%", args[4])));
                                    return;
                                }
                            }
                        }
                    }else{
                        multiplierList = new ArrayList<>();
                    }

                    try{
                        multiplierList.add(multiplier);
                        multiplierMap.put(plugin.getServer().getPlayer(args[2]).getUniqueId(), multiplierList);
                        sender.sendMessage(ColorUtils.color(mainConfig.langMap.get("admin-give-success-temp").replace("%player%", args[2]).replace("%multiplier%", args[3]).replace("%time%", args[4])));
                        return;
                    }catch (Exception e){
                        sender.sendMessage(ColorUtils.color(mainConfig.langMap.get("admin-give-usage")));
                        return;
                    }

                }

            }

        }
    }
}
